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
    @ColumnInfo(name = "date")
    var date: String,
    @ColumnInfo(name = "distance")
    var distance: Float,
    @ColumnInfo(name = "speed")
    var speed: Float
)