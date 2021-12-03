package project.stN991536967.snehal.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "bmi")
data class BMIEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @ColumnInfo(name = "height")
    var height: Int,

    @ColumnInfo(name = "weight")
    var weight: Int,

    @ColumnInfo(name = "finalValue")
    var finalValue: Int
)