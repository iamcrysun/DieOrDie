package com.github.iamcrysun.dieordie

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.iamcrysun.dieordie.daos.DoctorDao
import com.github.iamcrysun.dieordie.daos.SeeDao
import com.github.iamcrysun.dieordie.models.Doctor
import com.github.iamcrysun.dieordie.models.See

@Database(entities = [Doctor::class, See::class], version = 1)
abstract class DieDB : RoomDatabase() {
    abstract fun doctorDao(): DoctorDao
    abstract fun seeDao(): SeeDao

    companion object {
        @Volatile
        private var _instance: DieDB? = null

        fun Instance(context: Context): DieDB {
            val instance = _instance

            if (instance != null)
                return instance

            synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        DieDB::class.java,
                        "dieordiedb"
                    )
                    .build()

                _instance = instance

                return instance
            }
        }
    }
}