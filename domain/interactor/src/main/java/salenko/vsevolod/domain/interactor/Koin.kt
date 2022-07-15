package salenko.vsevolod.domain.interactor

import org.koin.dsl.module

object Koin {
    val useCasesModule = module {
        factory { GetCellsUseCase(cellsRepository = get()) }
    }
}