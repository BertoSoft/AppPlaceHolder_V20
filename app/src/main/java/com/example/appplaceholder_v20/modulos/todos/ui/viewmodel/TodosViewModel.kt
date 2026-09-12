package com.example.appplaceholder_v20.modulos.todos.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appplaceholder_v20.modulos.todos.domain.model.DatosTodos
import com.example.appplaceholder_v20.modulos.todos.domain.usecase.TodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class TodosUiEstado(
    val isCargando: Boolean = false,
    val msgError: String? = null,
    val lista: List<DatosTodos>? = null
)


@HiltViewModel
class TodosViewModel@Inject constructor(
    private val useCase: TodosUseCase
): ViewModel() {

    private val _estado = MutableStateFlow<TodosUiEstado>(TodosUiEstado())
    val estado: StateFlow<TodosUiEstado> get()= _estado

    fun initApp(){
        _estado.update { estadoActual ->
            estadoActual.copy(
                isCargando = true
            )
        }
        viewModelScope.launch {
            try {
                val lista = useCase.getListaTodosUseCase()
                if(lista.isNotEmpty()){
                    _estado.update { estadoActual ->
                        estadoActual.copy(
                            isCargando = false,
                            lista = lista,
                            msgError = null
                        )
                    }
                }
                else{
                    _estado.update { estadoActual ->
                        estadoActual.copy(
                            isCargando = false,
                            lista = null,
                            msgError = "Error al leer datos de Todos"
                        )
                    }
                }
            }
            catch (e: Exception){
                _estado.update { estadoActual ->
                    estadoActual.copy(
                        isCargando = false,
                        lista = null,
                        msgError = "Error: ${e.message}"
                    )
                }
            }
        }
    }


}