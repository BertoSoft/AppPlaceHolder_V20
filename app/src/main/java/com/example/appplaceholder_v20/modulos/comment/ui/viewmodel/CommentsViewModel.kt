package com.example.appplaceholder_v20.modulos.comment.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appplaceholder_v20.modulos.comment.domain.model.DatosComments
import com.example.appplaceholder_v20.modulos.comment.domain.usecase.CommentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CommentsUiEstado(
    val isCargando: Boolean = false,
    val msgError: String? = null,
    val lista: List<DatosComments>? = null
)

@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val useCase: CommentsUseCase
): ViewModel() {

    private val _estado = MutableStateFlow<CommentsUiEstado>(CommentsUiEstado())
    val estado: StateFlow<CommentsUiEstado> get() = _estado


    fun initApp() {
        _estado.update { estadoACtual ->
            estadoACtual.copy(
                isCargando = true
            )
        }
        viewModelScope.launch {
            try {
                val lista = useCase.getListaCommentsUseCase()
                if(lista.isNotEmpty()){
                    _estado.update { estadoActual ->
                        estadoActual.copy(
                            isCargando = false,
                            msgError = null,
                            lista = lista
                        )
                    }
                }
                else{
                    _estado.update { estadoActual ->
                        estadoActual.copy(
                            isCargando = false,
                            msgError = "Error al recibir datos de Comments...",
                            lista = null
                        )
                    }
                }
            }
            catch (e: Exception){
                _estado.update { estadoActual ->
                    estadoActual.copy(
                        isCargando = false,
                        msgError = "Error al recibir datos de Comments: ${e.message}",
                        lista = null
                    )
                }
            }
        }
    }

}