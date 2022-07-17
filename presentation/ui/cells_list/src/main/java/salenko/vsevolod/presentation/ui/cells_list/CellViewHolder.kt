package salenko.vsevolod.presentation.ui.cells_list

import androidx.recyclerview.widget.RecyclerView
import salenko.vsevolod.presentation.common_ui.SelectableCell
import salenko.vsevolod.presentation.ui.cells_list.databinding.ItemCellBinding

internal class CellViewHolder(
    private val binding: ItemCellBinding,
    private val selectionListener: (SelectableCell) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(selectableCell: SelectableCell) {
        binding.cell = selectableCell
        binding.root.setOnClickListener {
            selectionListener(selectableCell)
        }
    }
}