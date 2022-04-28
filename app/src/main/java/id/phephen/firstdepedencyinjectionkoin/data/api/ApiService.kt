package id.phephen.firstdepedencyinjectionkoin.data.api

import id.phephen.firstdepedencyinjectionkoin.data.model.User
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Phephen on 25/01/2022.
 */
interface ApiService {

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

}