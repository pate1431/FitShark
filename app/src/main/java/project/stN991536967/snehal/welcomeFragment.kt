package project.stN991536967.snehal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import project.stN991536967.snehal.databinding.FragmentWelcomeBinding


class welcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(
            inflater,
            R.layout.fragment_welcome, container, false
        )
      /*  val navigationView = requireActivity().findViewById<NavigationView>(R.id.navView)
        val menu = navigationView.menu
        val target: MenuItem = menu.findItem(R.id.registerFragment)
        target.setVisible(true)
        val target2: MenuItem = menu.findItem(R.id.loginFragment)
        target2.setVisible(true)*/

        binding.buttonGoToLogin.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_welcomeFragment_to_loginFragment)
        }

        binding.buttonGetStarted.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_welcomeFragment_to_registerFragment)
        }

        return binding.root

    }
}
