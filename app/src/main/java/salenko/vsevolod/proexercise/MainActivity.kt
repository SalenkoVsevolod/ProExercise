package salenko.vsevolod.proexercise

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import salenko.vsevolod.presentation.common_ui.SelectionProvider
import salenko.vsevolod.presentation.common_ui.SelectionState
import salenko.vsevolod.presentation.ui.cell_details.CellDetailsFragment
import salenko.vsevolod.presentation.ui.cells_list.CellsFragment

class MainActivity : AppCompatActivity() {

    private val detailsFragmentTag = CellDetailsFragment::class.simpleName
    private var ignoreFirstInputEvent = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSelectionMode(savedInstanceState)
    }

    private fun initSelectionMode(savedInstanceState: Bundle?) {
        if (isTabletLandscape()) {
            val displayingDetailsFragment = getDisplayingDetailsFragment()
            if (displayingDetailsFragment != null) {
                supportFragmentManager.popBackStack()
                showCellsFragment()
            }
        } else {
            if (savedInstanceState != null) {
                ignoreFirstInputEvent = true
            }
            observeSelection()
        }
    }

    private fun observeSelection() {
        lifecycleScope.launch {
            SelectionProvider.selection.collectLatest { state ->
                if (!ignoreFirstInputEvent) {
                    if (state is SelectionState.Input) {
                        if (getDisplayingDetailsFragment() == null) {
                            showDetailsFragment()
                        }
                    }
                } else {
                    ignoreFirstInputEvent = false
                }
            }
        }
    }

    private fun showDetailsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, CellDetailsFragment(), detailsFragmentTag)
            .addToBackStack(detailsFragmentTag)
            .commit()
    }

    private fun showCellsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, CellsFragment())
            .commit()
    }

    private fun getDisplayingDetailsFragment() =
        supportFragmentManager.findFragmentByTag(detailsFragmentTag)

    private fun isTabletLandscape(): Boolean {
        val configuration = resources.configuration
        val isTablet = configuration.smallestScreenWidthDp >= 600
        val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        return isTablet && isLandscape
    }
}