package salenko.vsevolod.presentation.common_ui

import salenko.vsevolod.entity.entity.Cell

data class SelectableCell(
    val id: Int, //id for DiffUtils
    val cell: Cell,
    val isSelected: Boolean = false
)