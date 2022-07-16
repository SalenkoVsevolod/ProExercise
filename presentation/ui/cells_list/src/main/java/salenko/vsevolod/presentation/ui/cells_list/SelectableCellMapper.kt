package salenko.vsevolod.presentation.ui.cells_list

import salenko.vsevolod.entity.entity.Cell
import salenko.vsevolod.presentation.common_ui.SelectableCell

internal fun List<Cell>.toSelectableCells(selectedIndex: Int): List<SelectableCell> =
    mapIndexed { index, cell ->
        cell.toSelectableCells(index, index == selectedIndex)
    }

internal fun Cell.toSelectableCells(id: Int, selected: Boolean = false) =
    SelectableCell(id = id, cell = this, isSelected = selected)
