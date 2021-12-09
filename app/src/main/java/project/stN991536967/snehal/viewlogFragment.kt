package project.stN991536967.snehal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.ListFragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
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

        val navigationView = requireActivity().findViewById<NavigationView>(R.id.navbar)
        val menu = navigationView.menu
        val target: MenuItem = menu.findItem(R.id.registerFragment)
        target.setVisible(false)
        val target2: MenuItem = menu.findItem(R.id.loginFragment)
        target2.setVisible(false)
        val first: MenuItem = menu.findItem(R.id.addlogsFragment)
        first.setVisible(true)
        val second: MenuItem = menu.findItem(R.id.viewlogFragment)
        second.setVisible(true)
        val third: MenuItem = menu.findItem(R.id.bmiFragment)
        third.setVisible(true)
        val forth: MenuItem = menu.findItem(R.id.welcomeFragment)
        forth.setVisible(true)

        val application = requireNotNull(this.activity).application
        database = fitDatabase.getInstance(application)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        val list = database.exerciseDao().getAll(UserLoginCheck.user.id)
        binding.recyclerView.adapter = MyRecyclerViewExerciseLog(list.toMutableList())

        return binding.root
    }




}