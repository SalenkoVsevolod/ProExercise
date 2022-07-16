package salenko.vsevolod.presentation.ui.cells_list

import androidx.recyclerview.widget.RecyclerView
import salenko.vsevolod.presentation.ui.cells_list.databinding.ItemCellBinding

internal class CellViewHolder(
    private val binding: ItemCellBinding,
    selectionListener: CellSelectionListener
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.selectionListener = selectionListener
    }

    fun bind(selectableCell: SelectableCell) {
        binding.cell = selectableCell
        binding.root.setOnClickListener {
        }
    }
}