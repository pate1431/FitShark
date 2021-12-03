package project.stN991536967.snehal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import project.stN991536967.snehal.Entity.ExerciseEntity
import project.stN991536967.snehal.viewModel.AddLogViewModel
import project.stN991536967.snehal.viewModel.AddLogViewModelFactory
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import project.stN991536967.snehal.databinding.FragmentAddlogsBinding


class addlogsFragment : Fragment() {

    private val viewModel: AddLogViewModel by activityViewModels{
        AddLogViewModelFactory(
            (activity?.application as fitsharkApplication).database.exerciseDao()
        )
    }
    lateinit var exercise:ExerciseEntity


    private var _binding: FragmentAddlogsBinding? = null
    private val binding get() = _binding!!

    /*private fun bind(exercise: ExerciseEntity){
        binding.apply {
            userID
        }
    }*/
    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.dateField.text.toString(),
            binding.input1.text.toString(),
            binding.input2.text.toString()
        )

    }
    private fun addNewItem() {
        if (isEntryValid()) {
            viewModel.addNewExercise(
                UserLoginCheck.user.id,
                binding.dateField.text.toString(),
                binding.input1.text.toString(),
                binding.input2.text.toString(),)
        }
        view?.findNavController()?.navigate(R.id.action_addlogsFragment_to_viewlogFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddlogsBinding.inflate(inflater, container, false)
        return binding.root
    }


}


