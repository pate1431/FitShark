package project.stN991536967.snehal.viewModel

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import project.stN991536967.snehal.Dao.ExerciseDao

import project.stN991536967.snehal.Entity.ExerciseEntity
import project.stN991536967.snehal.UserLoginCheck

class ExerciseViewModel (val exerciseDao: ExerciseDao): ViewModel(){

    fun insert(view: View, date:String, distance:String,speed:String){
        if(speed!!.isEmpty() || distance!!.isEmpty())
        {
            Toast.makeText(view.context,"Please Enter the Values", Toast.LENGTH_SHORT)
        }
        else
        {
            val exercise= ExerciseEntity(0,UserLoginCheck.user.id,date,distance.toFloat(),speed.toFloat())
            exerciseDao.insert(exercise)
        }
    }

    fun update(view: View, id:Long,date:String,distance: String,speed: String){
        if(speed!!.isEmpty() || distance!!.isEmpty())
        {
            Toast.makeText(view.context,"Please Enter the Values", Toast.LENGTH_SHORT)
        }
        else{
            val exercise= ExerciseEntity(
                id,UserLoginCheck.user.id,date,distance.toFloat(),
                speed.toFloat()
            )
            exerciseDao.update(exercise)
            Toast.makeText(view.context,"Update Success", Toast.LENGTH_SHORT)
        }
    }



}