package project.stN991536967.snehal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.ListFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import project.stN991536967.snehal.Database.fitDatabase
import project.stN991536967.snehal.Entity.ExerciseEntity
import project.stN991536967.snehal.RecycleView.MyRecyclerViewExerciseLog
import project.stN991536967.snehal.databinding.FragmentViewlogBinding


class viewlogFragment : Fragment() {

    private lateinit var database : fitDatabase
    private var exerciselogList = listOf<ExerciseEntity>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var binding: FragmentViewlogBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_viewlog,container,false)

        val application = requireNotNull(this.activity).application
        database = fitDatabase.getInstance(application)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        val list = database.exerciseDao().getAll(UserLoginCheck.user.id)
        binding.recyclerView.adapter = MyRecyclerViewExerciseLog(list.toMutableList())


        // Inflate the layout for this fragment
        return binding.root
    }

   /* override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ExerciseListAdapter{
            view?.findNavController()?.navigate(R.id.action_)
        }
    }*/


}