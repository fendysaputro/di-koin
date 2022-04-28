package id.phephen.firstdepedencyinjectionkoin.data.model

import com.squareup.moshi.Json

/**
 * Created by Phephen on 25/01/2022.
 */

data class User(
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "name")
    val name: String = "",
    @Json(name = "email")
    val email: String = "",
    @Json(name = "avatar")
    val avatar: String = ""
)
