package hu.bme.aut.android.simpledrawer.ui.theme.screen

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DrawingViewModel : ViewModel() {

    private val _drawingMode = MutableStateFlow(DrawingMode.LINE)
    val drawingMode: StateFlow<DrawingMode> = _drawingMode

    private val _drawElements = MutableStateFlow<List<Any>>(emptyList())
    val drawElements: StateFlow<List<Any>> = _drawElements

    fun setDrawingMode(mode: DrawingMode) {
        viewModelScope.launch { //ez csak addig fog futni, amig az Acitivity el,
            _drawingMode.value = mode //amugy memoriaszivargas lenne (Coroutines)
        }
    }

    fun setDrawElement(element: Any) {
        viewModelScope.launch {
            _drawElements.value += element
        }
    }
}

enum class DrawingMode {
    LINE,
    POINT
}