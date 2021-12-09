package project.stN991536967.snehal

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import project.stN991536967.snehal.Database.fitDatabase
import project.stN991536967.snehal.Entity.ExerciseEntity
import project.stN991536967.snehal.databinding.FragmentAddlogsBinding
import project.stN991536967.snehal.databinding.FragmentUpdateBinding
import java.text.SimpleDateFormat
import java.util.*


class updateFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var calender: Calendar = Calendar.getInstance()

        val binding: FragmentUpdateBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_update,
            container,
            false
        )

        val application = requireNotNull(this.activity).application
        val exerciseDao = fitDatabase.getInstance(application).exerciseDao()
        var exerciseID = requireArguments().getLong("exerciseId")

        val exercise: ExerciseEntity = exerciseDao.get(exerciseID.toLong())

            binding.editTextExercise.setText(exercise.exerciseName)
            binding.description.setText(exercise.description)
            binding.dateField.setText(exercise.date)

            binding.btnUpdate.setOnClickListener {
                if(binding.description.text.isEmpty() || binding.editTextExercise.text.isEmpty() || binding.dateField.text.isEmpty())
                {
                    Toast.makeText(view?.context,"Please Enter Valid Information", Toast.LENGTH_SHORT)
                }
                else{
                val newExercise = ExerciseEntity(exerciseID.toLong(), UserLoginCheck.user.id,binding.editTextExercise.text.toString(),binding.dateField.text.toString(),binding.description.text.toString())
                exerciseDao.update(newExercise)
                view?.findNavController()?.navigate(R.id.action_updateFragment_to_viewlogFragment)
                }
            }

        binding.dateField.setOnClickListener {
            val mYear = calender.get(Calendar.YEAR)
            val mMonth = calender.get(Calendar.MONTH)
            val mDay = calender.get(Calendar.DAY_OF_MONTH)


            val datePickerDialog = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                    calender.set(year, monthOfYear, dayOfMonth)
                    val calendar: Calendar = Calendar.getInstance()
                    val hour = calendar.get(Calendar.HOUR)
                    val minute = calendar.get(Calendar.MINUTE)
                    val timePickerDialog = TimePickerDialog(
                        requireContext(), TimePickerDialog.OnTimeSetListener { timePicker, i, i2 ->
                            val myHour = i
                            val myMinute = i2
                            val nameMonth = DateFormat.format("MMMM", calender) as String

                            val time = myHour.toString() + ":" +myMinute

                            val date12Format = SimpleDateFormat("hh:mm a")

                            val date24Format = SimpleDateFormat("HH:mm")

                            binding.dateField.text = nameMonth + " " + dayOfMonth + ", " + year + "    " +
                                    date12Format.format(date24Format.parse(time))

                        }, hour, minute,
                        DateFormat.is24HourFormat(requireContext())
                    )
                    timePickerDialog.show()
                },
                mYear,
                mMonth,
                mDay
            )
            datePickerDialog.show()
        }



        return binding.root

    }


}