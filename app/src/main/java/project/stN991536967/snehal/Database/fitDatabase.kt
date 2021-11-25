package project.stN991536967.snehal.Database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import project.stN991536967.snehal.Dao.LoginDao

abstract class fitDatabase  : RoomDatabase(){
    abstract fun loginDao(): LoginDao

    companion object{
        @Volatile
        private var INSTANCE : fitDatabase? = null

        fun getInstance(context: Context) : fitDatabase {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    fitDatabase::class.java,
                    "fitappdatabase"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
            }
            return INSTANCE as fitDatabase
        }
    }

}