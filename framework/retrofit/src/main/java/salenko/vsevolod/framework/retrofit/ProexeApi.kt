package salenko.vsevolod.framework.retrofit

import retrofit2.http.GET

interface ProexeApi {
    @GET("json.json")
    suspend fun getCells(): List<CellDataModel>
}