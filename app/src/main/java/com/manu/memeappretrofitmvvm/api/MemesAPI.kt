package com.manu.memeappretrofitmvvm.api

import com.manu.memeappretrofitmvvm.model.Jokes
import retrofit2.Response
import retrofit2.http.GET

interface MemesAPI {

    @GET("/get_memes")
    suspend fun getMemes(): Response<Jokes>
}