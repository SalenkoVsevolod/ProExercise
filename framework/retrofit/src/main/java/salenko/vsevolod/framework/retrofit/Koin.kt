package salenko.vsevolod.framework.retrofit

import org.koin.dsl.module
import retrofit2.Retrofit
import salenko.vsevolod.domain.repositories.CellsRepository

object Koin {
    val retrofitModule = module {
        single { HttpClientBuilder.getClient() }
        single {
            RetrofitBuilder.getRetrofitClient(
                httpClient = get(),
                url = "http://client.proexe.eu/"
            )
        }
        single<ProexeApi> {
            get<Retrofit>().create(ProexeApi::class.java)
        }
        single<CellsRepository> {
            RetrofitCellsRepository(api = get())
        }
    }
}