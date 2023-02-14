package www.iesmurgi.u9_proyprofesoressqlite

import com.example.proyectorestapi.Nutriments
import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("_id") var _id:String,
    @SerializedName("product_name") var product_name:String,
    @SerializedName("nutriments") var nutriments: Nutriments
):java.io.Serializable
