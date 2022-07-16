package salenko.vsevolod.presentation.common_ui

sealed interface SelectionState {
    object Nothing : SelectionState
    class Initial(val selectedCell: SelectableCell) : SelectionState
    class Input(val selectedCell: SelectableCell) : SelectionState

    fun selectedCellOrNull() =
        when (this) {
            is Initial -> selectedCell
            is Input -> selectedCell
            Nothing -> null
        }

    fun selectedCellTextOrNull() =
        selectedCellOrNull()?.cell?.name

    fun selectedCellImageOrNull() =
        selectedCellOrNull()?.cell?.imageUrl
}