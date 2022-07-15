package salenko.vsevolod.proexercise.core

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import salenko.vsevolod.domain.interactor.Koin.useCasesModule
import salenko.vsevolod.framework.retrofit.Koin.retrofitModule
import salenko.vsevolod.framework.samples.Koin.samplesModule
import salenko.vsevolod.presentation.view_models.Koin.viewModelsModule

class ProExerciseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidLogger()
            androidContext(this@ProExerciseApplication)
            modules(
                retrofitModule,
                samplesModule,
                useCasesModule,
                viewModelsModule
            )
        }
    }
}