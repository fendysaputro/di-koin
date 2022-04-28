package id.phephen.firstdepedencyinjectionkoin.data.api

import id.phephen.firstdepedencyinjectionkoin.data.model.User
import retrofit2.Response

/**
 * Created by Phephen on 25/01/2022.
 */
interface ApiHelper {

    suspend fun getUsers(): Response<List<User>>

}