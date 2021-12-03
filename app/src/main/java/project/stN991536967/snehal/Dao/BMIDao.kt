package project.stN991536967.snehal.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import project.stN991536967.snehal.Entity.BMIEntity


@Dao
interface BMIDao {
    @Query("SELECT * FROM bmi")
    fun getAll(): List<BMIEntity>
    @Query("DELETE FROM bmi")
    fun deleteAllBmi()
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(bmi: BMIEntity)
}