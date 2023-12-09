package com.manu.memeappretrofitmvvm.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.manu.memeappretrofitmvvm.model.Meme

@Database(entities = [Meme::class], version = 1)
abstract class MemesDatabase(): RoomDatabase() {
    abstract fun memesDao(): MemesDao

    companion object {
        private var INSTANCE: MemesDatabase? = null

        fun getDatabase(context: Context): MemesDatabase {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    MemesDatabase::class.java,
                    "memesDB"
                ).build()
            }
            return INSTANCE!!
        }
    }
}