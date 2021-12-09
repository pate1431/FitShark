package project.stN991536967.snehal

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import project.stN991536967.snehal.Entity.ExerciseEntity
import androidx.databinding.DataBindingUtil
import com.google.android.material.navigation.NavigationView
import project.stN991536967.snehal.Database.fitDatabase
import project.stN991536967.snehal.databinding.FragmentAddlogsBinding
import java.text.SimpleDateFormat
import java.util.*


class addlogsFragment : Fragment() {
        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var calender: Calendar = Calendar.getInstance()
        val binding: FragmentAddlogsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_addlogs,
            container,
            false
        )
        val navigationView = requireActivity().findViewById<NavigationView>(R.id.navbar)
        val menu = navigationView.menu
        val target: MenuItem = menu.findItem(R.id.registerFragment)
        target.setVisible(true)
        val target2: MenuItem = menu.findItem(R.id.loginFragment)
        target2.setVisible(true)




        binding.input1.setHint("Distance")
        binding.input2.setHint("Speed")
        binding.input3.visibility = View.GONE



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

        val application = requireNotNull(this.activity).application
        val exerciseDao = fitDatabase.getInstance(application).exerciseDao()

        binding.btnAdd.setOnClickListener {
            if(binding.input1.text.isEmpty() || binding.editTextExercise.text.isEmpty() || binding.input2.text.isEmpty() || binding.dateField.text.isEmpty())
            {
                Toast.makeText(view?.context,"Please Enter Valid Information", Toast.LENGTH_SHORT)
            }
            else{
                val newExercise = ExerciseEntity(0, UserLoginCheck.user.id,binding.editTextExercise.text.toString(),binding.dateField.text.toString(),binding.input1.text.toString().toFloat(), binding.input2.text.toString().toFloat())
                exerciseDao.insert(newExercise)
            }
        }





        return binding.root
    }

}


