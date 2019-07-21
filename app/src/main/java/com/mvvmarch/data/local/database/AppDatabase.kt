package com.mvvmarch.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mvvmarch.data.local.database.dao.UserDao
import com.mvvmarch.data.local.database.entity.UserLocalEntity

@Database(
    entities = [
        UserLocalEntity::class
    ],
    version = 1
)
@TypeConverters()
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    override fun clearAllTables() {
        userDao().deleteAll()

    }

    companion object {
        const val NAME = "temp_db"
    }
}