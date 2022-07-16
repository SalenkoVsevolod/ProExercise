package salenko.vsevolod.presentation.ui.cells_list

import salenko.vsevolod.entity.entity.Cell

internal data class SelectableCell(
    val id: Int, //id for DiffUtils
    var cell: Cell,
    var isSelected: Boolean = false
)