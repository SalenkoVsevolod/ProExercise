package salenko.vsevolod.presentation.ui.cells_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import salenko.vsevolod.presentation.ui.cells_list.databinding.ItemCellBinding

internal class CellsRecyclerAdapter(private val selectionListener: CellSelectionListener) :
    ListAdapter<SelectableCell, CellViewHolder>(CellItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder =
        CellViewHolder(
            ItemCellBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            selectionListener
        )

    override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
        val item = getItem(holder.adapterPosition)
        holder.bind(item)
    }
}