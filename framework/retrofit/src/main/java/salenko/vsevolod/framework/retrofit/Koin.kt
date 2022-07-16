package salenko.vsevolod.framework.retrofit

import org.koin.dsl.module
import salenko.vsevolod.domain.repositories.CellsRepository

object Koin {
    val retrofitModule = module {
        single { HttpClientBuilder.getClient() }
        single { RetrofitBuilder.getRetrofitClient(httpClient = get(), url = get()) }
        single<CellsRepository> { RetrofitCellsRepository(api = get()) }
    }
}