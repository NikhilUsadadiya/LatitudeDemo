package com.project.latitudetechnolabs.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.latitudetechnolabs.data.db.dao.*
import com.project.latitudetechnolabs.data.db.entities.*


@Database(
    entities = [ScreenSaverMasters::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract val screenSaverMastersDao : ScreenSaverMastersDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: buildDatabase(
                    context
                ).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "MyDatabase.db"
            ).allowMainThreadQueries().build()


    }

}