package project.stN991536967.snehal.viewModel

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import project.stN991536967.snehal.Dao.ExerciseDao
import project.stN991536967.snehal.Entity.ExerciseEntity
import project.stN991536967.snehal.UserLoginCheck


class AddLogViewModel (val runningDao: ExerciseDao): ViewModel(){

    //insert
    fun insert(view: View, date:String, distance: String, speed:String){

        if(distance!!.isEmpty() || speed!!.isEmpty())
        {
            Toast.makeText(view.context,"Please Enter Valid Information", Toast.LENGTH_SHORT)
        }
        else{
            val newExercise = ExerciseEntity(0, UserLoginCheck.user.id,date,distance.toFloat(),speed.toFloat())

            runningDao.insert(newExercise)
        }
    }
/*    fun update(view: View, date:String, distance: String, speed:String)
    {
        if(distance!!.isEmpty() || speed!!.isEmpty())
        {
            Toast.makeText(view.context,"Please Enter Valid Information", Toast.LENGTH_SHORT)
        }
        else{
            val newExercise = ExerciseEntity(
                 UserLoginCheck.user.id, date,
                distance.toFloat(), speed.toFloat()
            )

            runningDao.update(newExercise)
        }
    }*/
}