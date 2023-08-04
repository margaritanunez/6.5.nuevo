package com.example.a65.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//p30

@Database (entities = [TerrenoEntity::class], version = 1)
abstract class TerrenoDataBase: RoomDatabase() {

    abstract fun getTerrenoDao() :TerrenoDao

    companion object {
        @Volatile
        private var INSTANCE: TerrenoDataBase?= null

        fun getDataBase(context: Context): TerrenoDataBase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TerrenoDataBase::class.java,
                    "terrenos_database"
                ).build()

                INSTANCE =instance
                return instance
            }
        }
    }
}