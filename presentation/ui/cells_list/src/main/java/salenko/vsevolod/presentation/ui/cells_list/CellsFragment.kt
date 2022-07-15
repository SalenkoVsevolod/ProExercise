package salenko.vsevolod.presentation.ui.cells_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel
import salenko.vsevolod.presentation.view_models.CellsViewModel


class CellsFragment : Fragment() {
    private val cellsViewModel: CellsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeCells()
        return inflater.inflate(R.layout.fragment_cells, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cellsViewModel.refreshIfRequired()
    }

    private fun observeCells() {
        lifecycleScope.launchWhenCreated {
            cellsViewModel.state.collect {
                val cells = it.getDataOrNull()
                if (cells != null) {
                    Log.i("ProExcercise", cells.joinToString())
                }
            }
        }
    }
}