package salenko.vsevolod.framework.retrofit

import com.google.gson.annotations.SerializedName

data class CellDataModel(

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
    val img: String
)
