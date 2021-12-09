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
        target.setVisible(false)
        val target2: MenuItem = menu.findItem(R.id.loginFragment)
        target2.setVisible(false)
        val target3: MenuItem = menu.findItem(R.id.about)
        target3.setVisible(false)
        val target4: MenuItem = menu.findItem(R.id.help)
        target4.setVisible(false)
        val first: MenuItem = menu.findItem(R.id.addlogsFragment)
        first.setVisible(true)
        val second: MenuItem = menu.findItem(R.id.viewlogFragment)
        second.setVisible(true)
        val third: MenuItem = menu.findItem(R.id.bmiFragment)
        third.setVisible(true)
        val forth: MenuItem = menu.findItem(R.id.welcomeFragment)
        forth.setVisible(true)

        binding.btnCalculateBMI.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_homeFragment_to_bmiFragment)
        }

        binding.btnAddLog.setOnClickListener {
            var bundle = Bundle()
            bundle.putLong("exerciseId",0)
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