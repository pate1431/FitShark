package project.stN991536967.snehal.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import project.stN991536967.snehal.Entity.LoginEntity

@Dao
interface LoginDao {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun userRegister(login: LoginEntity)

    @Query("SELECT * FROM login WHERE email=:email AND pass=:pass")
    fun search(email: String, pass: String) : LoginEntity



}