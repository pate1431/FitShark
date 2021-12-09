package project.stN991536967.snehal.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import project.stN991536967.snehal.Dao.ExerciseDao
import project.stN991536967.snehal.Dao.LoginDao
import project.stN991536967.snehal.Entity.BMIEntity
import project.stN991536967.snehal.Entity.ExerciseEntity
import project.stN991536967.snehal.Entity.LoginEntity

@Database(entities = [BMIEntity::class, ExerciseEntity:: class, LoginEntity::class], version = 6, exportSchema = false)
abstract class fitDatabase  : RoomDatabase(){
    abstract fun loginDao(): LoginDao
    abstract fun exerciseDao(): ExerciseDao

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

        fun getDatabase(context: Context): fitDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    fitDatabase::class.java,
                    "fit_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}