package com.manu.memeappretrofitmvvm

import android.app.Application
import com.manu.memeappretrofitmvvm.api.ApiUtilities
import com.manu.memeappretrofitmvvm.api.MemesAPI
import com.manu.memeappretrofitmvvm.repository.MemesRepository
import com.manu.memeappretrofitmvvm.room.MemesDatabase

class MyApplication: Application() {
    lateinit var memesRepository: MemesRepository
    override fun onCreate() {
        super.onCreate()

        val apiInterface = ApiUtilities.getInstance().create(MemesAPI::class.java)
        val db = MemesDatabase.getDatabase(applicationContext)
        memesRepository = MemesRepository(apiInterface, db, applicationContext)
    }
}