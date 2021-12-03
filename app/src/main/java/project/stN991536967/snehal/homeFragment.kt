package project.stN991536967.snehal

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import project.stN991536967.snehal.databinding.FragmentHomeBinding


class homeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home, container, false
        )

        val navigationView = requireActivity().findViewById<NavigationView>(R.id.navbar)
        val menu = navigationView.menu
        val target: MenuItem = menu.findItem(R.id.registerFragment)
        target.setVisible(true)
        val target2: MenuItem = menu.findItem(R.id.loginFragment)
        target2.setVisible(true)

        binding.btnCalculateBMI.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homeFragment_to_bmiFragment)
        }

        binding.btnAddLog.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homeFragment_to_addlogsFragment)
        }

        binding.btnViewLogs.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homeFragment_to_viewlogFragment)
        }
/*
        binding.buttonArticle?.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_appFragment_to_articleFragment)
        }*/

        setHasOptionsMenu(true)

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item!!, requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }

}