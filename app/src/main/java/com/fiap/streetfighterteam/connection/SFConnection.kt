package com.fiap.streetfighterteam.connection

import com.fiap.streetfighterteam.model.Character
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class SFConnection {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://fiapstreetfighter.web.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(SFService::class.java)

}

interface SFService {
    @GET("sf.json")
    fun listCharacters(): Call<List<Character>>
}