package project.stN991536967.snehal.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class ExerciseEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "userID")
    var userID: Long,
    @ColumnInfo(name = "Exercise_Name")
    var exerciseName: String,
    @ColumnInfo(name = "date")
    var date: String,
    @ColumnInfo(name = "Description")
    var description: String,

)