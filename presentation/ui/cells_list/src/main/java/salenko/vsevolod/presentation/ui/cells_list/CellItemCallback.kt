package salenko.vsevolod.presentation.ui.cells_list

import androidx.recyclerview.widget.DiffUtil
import salenko.vsevolod.presentation.common_ui.SelectableCell

internal object CellItemCallback : DiffUtil.ItemCallback<SelectableCell>() {

    override fun areItemsTheSame(oldItem: SelectableCell, newItem: SelectableCell): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: SelectableCell, newItem: SelectableCell): Boolean =
        oldItem.cell == newItem.cell && oldItem.isSelected == newItem.isSelected
}