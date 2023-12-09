package com.manu.memeappretrofitmvvm.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manu.memeappretrofitmvvm.api.MemesAPI
import com.manu.memeappretrofitmvvm.model.Data
import com.manu.memeappretrofitmvvm.model.Jokes
import com.manu.memeappretrofitmvvm.room.MemesDatabase
import com.manu.memeappretrofitmvvm.util.MyUtils

class MemesRepository(
    private val memesAPI: MemesAPI,
    private val memesDatabase: MemesDatabase,
    private val applicationContext: Context,
    ) {
    private val _memes = MutableLiveData<Jokes>()
    val memes: LiveData<Jokes>
        get() = _memes

    suspend fun getMemes() {
        if(MyUtils.isInternetAvailable(applicationContext)) {
            val result = memesAPI.getMemes()
            if(result.body() != null) {

                memesDatabase.memesDao().insertMeme(result.body()!!.data.memes)
                _memes.postValue(result.body())
            } else {
                val memes = memesDatabase.memesDao().getMemes()
                val memesList = Jokes(Data(memes), true)
                _memes.postValue(memesList)
            }
        }
    }

}