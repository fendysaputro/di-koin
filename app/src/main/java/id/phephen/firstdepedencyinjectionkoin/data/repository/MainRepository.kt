package id.phephen.firstdepedencyinjectionkoin.data.repository

import id.phephen.firstdepedencyinjectionkoin.data.api.ApiHelper

/**
 * Created by Phephen on 25/01/2022.
 */
class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()

}