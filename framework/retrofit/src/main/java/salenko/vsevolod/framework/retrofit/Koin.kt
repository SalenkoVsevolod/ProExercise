package salenko.vsevolod.framework.retrofit

import org.koin.dsl.module
import salenko.vsevolod.domain.repositories.CellsRepository

object Koin {
    val retrofitModule = module {
        single<CellsRepository> { RetrofitCellsRepository() }
    }
}