package salenko.vsevolod.proexercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import salenko.vsevolod.presentation.common_ui.SelectionProvider
import salenko.vsevolod.presentation.common_ui.SelectionState
import salenko.vsevolod.presentation.ui.cell_details.CellDetailsFragment

class MainActivity : AppCompatActivity() {

    private val detailsFragmentTag = CellDetailsFragment::class.simpleName
    private var ignoreFirstInputEvent = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            ignoreFirstInputEvent = true
        }
        if (!isTabletLandscape()) {
            observeSelection()
        }
    }

    private fun observeSelection() {
        lifecycleScope.launch {
            SelectionProvider.selection.collectLatest { state ->
                if (!ignoreFirstInputEvent) {
                    if (state is SelectionState.Input) {
                        showDetailsFragment()
                    }
                } else {
                    ignoreFirstInputEvent = false
                }

            }
        }
    }

    private fun showDetailsFragment() {
        val alreadyDisplayingDetail =
            supportFragmentManager.findFragmentByTag(detailsFragmentTag) != null
        if (!alreadyDisplayingDetail) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, CellDetailsFragment(), detailsFragmentTag)
                .addToBackStack(detailsFragmentTag)
                .commit()
        }
    }

    private fun isTabletLandscape(): Boolean {
        //TODO
        return false
    }
}