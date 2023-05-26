import com.example.basictriviacopy.MyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://opentdb.com/"
interface ApiInterface{
    @GET("api.php")

    fun getData(selectedCategory: Int, amount: Int, selectedDifficulty: String, type: String):Call<MyData>
}