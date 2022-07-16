package salenko.vsevolod.presentation.ui.cells_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import salenko.vsevolod.presentation.common_ui.CellSelectionListener
import salenko.vsevolod.presentation.common_ui.SelectableCell
import salenko.vsevolod.presentation.ui.cells_list.databinding.ItemCellBinding

internal class CellsRecyclerAdapter(private val selectionListener: CellSelectionListener) :
    ListAdapter<SelectableCell, CellViewHolder>(CellItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder =
        CellViewHolder(
            ItemCellBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            ::onCellSelected
        )

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        val item = getItem(holder.adapterPosition)
        holder.bind(item)
    }

    private fun onCellSelected(selectedCell: SelectableCell) {
        val data = ArrayList(currentList)
        val previouslySelectedIndex = data.indexOfFirst { it.isSelected }
        if (previouslySelectedIndex != -1) {
            val unselected = data[previouslySelectedIndex].run { SelectableCell(id, cell) }
            data[previouslySelectedIndex] = unselected
        }
        val newSelectedIndex = data.indexOf(selectedCell)
        val selected = selectedCell.run {
            SelectableCell(id, cell, true)
        }
        data[newSelectedIndex] = selected
        submitList(data)
        selectionListener.onCellSelected(selected)
    }
}