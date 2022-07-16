package salenko.vsevolod.framework.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object HttpClientBuilder {

    fun getClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

}