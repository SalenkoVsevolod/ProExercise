package salenko.vsevolod.presentation.ui.cell_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import salenko.vsevolod.presentation.common_ui.SelectionProvider
import salenko.vsevolod.presentation.ui.cell_details.databinding.FragmentCellDetailsBinding

class CellDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentCellDetailsBinding.inflate(inflater, container, false).let {
            initBinding(it)
            it.root
        }

    private fun initBinding(binding: FragmentCellDetailsBinding) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.selectedCell = SelectionProvider.selection
    }
}