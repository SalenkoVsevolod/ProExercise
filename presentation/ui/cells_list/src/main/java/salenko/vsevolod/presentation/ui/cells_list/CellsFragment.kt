package salenko.vsevolod.presentation.ui.cells_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import salenko.vsevolod.entity.entity.Cell
import salenko.vsevolod.presentation.common_ui.CellSelectionListener
import salenko.vsevolod.presentation.common_ui.SelectableCell
import salenko.vsevolod.presentation.common_ui.SelectionProvider
import salenko.vsevolod.presentation.common_ui.SelectionState
import salenko.vsevolod.presentation.ui.cells_list.databinding.FragmentCellsBinding
import salenko.vsevolod.presentation.view_models.CellsViewModel


class CellsFragment : Fragment() {
    private val cellsViewModel: CellsViewModel by viewModel()

    //TODO move to binding
    private val adapter by lazy { CellsRecyclerAdapter(CellsFragmentInputHandler()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentCellsBinding.inflate(inflater, container, false)
            .apply(::initBinding)
            .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cellsViewModel.refreshIfRequired()
    }

    private fun initBinding(binding: FragmentCellsBinding) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.cellsViewModel = cellsViewModel
        binding.cellsRecyclerView.adapter = adapter
        //TODO move to binding
        lifecycleScope.launchWhenCreated {
            cellsViewModel.state.collect {
                it.getDataOrNull()?.let(::updateCells)
            }
        }
    }

    private fun updateCells(cells: List<Cell>) {
        val selectedCell = SelectionProvider.selection.value.selectedCellOrNull()
        val index = if (selectedCell == null) {
            val defaultSelectedIndex = 0
            val defaultSelectedCell =
                cells[defaultSelectedIndex].toSelectableCells(defaultSelectedIndex, true)
            SelectionProvider.selection.value = SelectionState.Initial(defaultSelectedCell)
            defaultSelectedIndex
        } else {
            selectedCell.id
        }
        adapter.submitList(cells.toSelectableCells(index))
    }

    internal inner class CellsFragmentInputHandler : CellSelectionListener {

        override fun onCellSelected(selectedCell: SelectableCell) {
            SelectionProvider.selection.value = SelectionState.Input(selectedCell)
        }
    }
}