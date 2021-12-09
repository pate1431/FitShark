package project.stN991536967.snehal.Dao

import androidx.room.*
import project.stN991536967.snehal.Entity.ExerciseEntity

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(exercise: ExerciseEntity)

    /*@Delete
    fun delete(exercise: ExerciseEntity)*/

    @Query("SELECT * FROM exercise where userID=:userID")
    fun getAll(userID: Long): List<ExerciseEntity>

    @Query("DELETE FROM exercise WHERE id=:logId")
    fun delete(logId : Long)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update (exercise: ExerciseEntity)

}