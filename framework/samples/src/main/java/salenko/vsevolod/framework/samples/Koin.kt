package salenko.vsevolod.framework.samples

import org.koin.dsl.module
import salenko.vsevolod.domain.repositories.CellsRepository

object Koin {
    val samplesModule = module {
        single<CellsRepository> { SampleCellsRepository() }
    }
}