package com.github.iamcrysun.dieordie

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.github.iamcrysun.dieordie.daos.DoctorDao
import com.github.iamcrysun.dieordie.daos.SeeDao
import com.github.iamcrysun.dieordie.daos.UserDao
import com.github.iamcrysun.dieordie.models.Doctor
import com.github.iamcrysun.dieordie.models.See
import com.github.iamcrysun.dieordie.models.User
import com.github.iamcrysun.dieordie.utils.converters.BitmapConverter

@Database(entities = [Doctor::class, See::class, User::class], version = 1, exportSchema = false)
@TypeConverters(value = [BitmapConverter::class])
abstract class DieDB : RoomDatabase() {
    abstract fun doctorDao(): DoctorDao
    abstract fun seeDao(): SeeDao
    abstract fun userDao(): UserDao

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
                    .allowMainThreadQueries()
                    .build()

                _instance = instance

                return instance
            }
        }
    }
}