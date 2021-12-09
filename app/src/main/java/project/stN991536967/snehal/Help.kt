package project.stN991536967.snehal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.navigation.NavigationView
import project.stN991536967.snehal.databinding.FragmentAboutBinding


class Help : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var binding = DataBindingUtil.inflate<FragmentAboutBinding>(inflater,
        R.layout.fragment_about,container,false)
        val navigationView = requireActivity().findViewById<NavigationView>(R.id.navbar)
        val menu = navigationView.menu
        val target: MenuItem = menu.findItem(R.id.registerFragment)
        target.setVisible(true)
        val target2: MenuItem = menu.findItem(R.id.loginFragment)
        target2.setVisible(true)
        val target3: MenuItem = menu.findItem(R.id.about)
        target3.setVisible(true)
        val target4: MenuItem = menu.findItem(R.id.help)
        target4.setVisible(true)
        val first: MenuItem = menu.findItem(R.id.addlogsFragment)
        first.setVisible(false)
        val second: MenuItem = menu.findItem(R.id.viewlogFragment)
        second.setVisible(false)
        val third: MenuItem = menu.findItem(R.id.bmiFragment)
        third.setVisible(false)
        val forth: MenuItem = menu.findItem(R.id.welcomeFragment)
        forth.setVisible(false)


        binding.textView4.setText(R.string.help)

        return binding.root
    }

}