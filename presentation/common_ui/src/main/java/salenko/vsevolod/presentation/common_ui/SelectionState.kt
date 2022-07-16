package salenko.vsevolod.presentation.common_ui

sealed interface SelectionState {
    object Nothing : SelectionState
    class Initial(val cell: SelectableCell) : SelectionState
    class Input(val cell: SelectableCell) : SelectionState

    fun selectedCellOrNull() =
        when (this) {
            is Initial -> cell
            is Input -> cell
            Nothing -> null
        }
}