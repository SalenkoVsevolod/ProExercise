package salenko.vsevolod.presentation.ui.cells_list

import salenko.vsevolod.entity.entity.Cell

internal fun List<Cell>.toSelectableCells(): List<SelectableCell> =
    mapIndexed { index, cell ->
        SelectableCell(index, cell, index == 0)
    }