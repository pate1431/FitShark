package project.stN991536967.snehal.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login")
class LoginEntity (
 @PrimaryKey(autoGenerate = true)
  var id: Long,

 @ColumnInfo(name="name")
  var name: String,

 @ColumnInfo(name="email")
  var email: String,

 @ColumnInfo(name="pass")
 var pass: String,
)