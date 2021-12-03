package project.stN991536967.snehal.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import project.stN991536967.snehal.Dao.ExerciseDao
import project.stN991536967.snehal.Entity.ExerciseEntity


class AddLogViewModel (private val exerciseDao: ExerciseDao): ViewModel(){

    private fun insertExercise(exercise: ExerciseEntity)
    {
        viewModelScope.launch {
            exerciseDao.insert(exercise)
        }
    }
    fun isEntryValid(date:String, distance:String, speed:String): Boolean {
        if (date.isEmpty() || distance.isBlank() || speed.isBlank()) {
            return false
        }
        return true
    }

    private fun getNewExerciseEntry(userid: Long,date:String, distance:String, speed:String): ExerciseEntity {

        return ExerciseEntity(
            userID = userid,
            date= date,
            distance = distance.toFloat(),
            speed = speed.toFloat()
        )
    }
    fun addNewExercise(userid: Long,date: String,distance:String, speed:String) {
        val newItem = getNewExerciseEntry(userid , date, distance, speed)
        insertExercise(newItem)
    }
    private fun updateExercise(exercise: ExerciseEntity) {
        viewModelScope.launch {
            exerciseDao.update(exercise)
        }
    }
    fun deleteItem(exercise: ExerciseEntity) {
        viewModelScope.launch {
            exerciseDao.delete(exercise)
        }
    }
    private fun getUpdatedExerciseEntry(
        userid: Long,
        date:String,
        distance: String,
        speed: String
    ): ExerciseEntity {
        return ExerciseEntity(
            userID = userid,
            date = date,
            distance = distance.toFloat(),
            speed = speed.toFloat()
        )
    }
    fun updateExercise(
        userid: Long,
        date:String,
        distance: String,
        speed: String
    ) {
        val updatedItem = getUpdatedExerciseEntry(userid,date,distance,speed)
        updateExercise(updatedItem)
    }


}
class AddLogViewModelFactory(private val exerciseDao: ExerciseDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(AddLogViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddLogViewModel(exerciseDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}