package salenko.vsevolod.presentation.common_ui

import kotlinx.coroutines.flow.MutableStateFlow

object SelectionProvider {
    val selection by lazy { MutableStateFlow<SelectionState>(SelectionState.Nothing) }
}