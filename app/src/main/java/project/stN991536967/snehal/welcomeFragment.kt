package project.stN991536967.snehal

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import project.stN991536967.snehal.databinding.FragmentWelcomeBinding
import android.R.menu





class welcomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(
            inflater,
            R.layout.fragment_welcome, container, false
        )


       /* val navigationView = requireActivity().findViewById<NavigationView>(R.id.navbar)
        val menu2: Menu
         menu2 = navigationView.menu
        val target: MenuItem = menu2.findItem(R.id.registerFragment)
        target.setVisible(true)

        val target2: MenuItem = menu2.findItem(R.id.loginFragment)
        target2.setVisible(true)
        val target3: MenuItem = menu2.findItem(R.id.about)
        target3.setVisible(true)
        val target4: MenuItem = menu2.findItem(R.id.help)
        target4.setVisible(true)
        val first: MenuItem = menu2.findItem(R.id.addlogsFragment)
        first.setVisible(false)
        val second: MenuItem = menu2.findItem(R.id.viewlogFragment)
        second.setVisible(false)
        val third: MenuItem = menu2.findItem(R.id.bmiFragment)
        third.setVisible(false)
        val forth: MenuItem = menu2.findItem(R.id.welcomeFragment)
        forth.setVisible(false)*/

        binding.buttonGoToLogin.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_welcomeFragment_to_loginFragment)
        }

        binding.buttonGetStarted.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_welcomeFragment_to_registerFragment)
        }

        return binding.root

    }


}
