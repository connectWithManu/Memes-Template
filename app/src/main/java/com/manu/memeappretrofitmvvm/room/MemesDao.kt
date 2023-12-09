package com.manu.memeappretrofitmvvm.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manu.memeappretrofitmvvm.model.Meme

@Dao
interface MemesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeme(meme: List<Meme>)

    @Query("SELECT * FROM memes")
    suspend fun getMemes(): List<Meme>
}