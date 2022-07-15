package salenko.vsevolod.presentation.view_models

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Koin {
    val viewModelsModule = module {
        viewModel { CellsViewModel(getCellsUseCase = get()) }
    }
}