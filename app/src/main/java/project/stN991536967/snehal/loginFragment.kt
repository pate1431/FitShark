package project.stN991536967.snehal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import project.stN991536967.snehal.Database.fitDatabase
import project.stN991536967.snehal.Entity.LoginEntity
import project.stN991536967.snehal.databinding.FragmentLoginBinding


class loginFragment : Fragment() {

    companion object{
        private lateinit var user : LoginEntity

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                             savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,
            R.layout.fragment_login,container,false)


        val navigationView = requireActivity().findViewById<NavigationView>(R.id.navbar)
        val menu = navigationView.menu
        val target: MenuItem = menu.findItem(R.id.registerFragment)
        target.setVisible(true)
        val target2: MenuItem = menu.findItem(R.id.loginFragment)
        target2.setVisible(true)

        /*val target7: MenuItem = menu.findItem(R.id.articleFragment)
        target7.setVisible(false)*/

        val application = requireNotNull(this.activity).application
        val loginDao = fitDatabase.getInstance(application).loginDao()

        binding.btnLogin.setOnClickListener {
            if(binding.editTextEmail.text.trim().isEmpty() || binding.editTextPass.text.trim().isEmpty()) {

                Toast.makeText(activity, "Invalid Emailid or Password", Toast.LENGTH_SHORT).show()

            }
            /*else if(binding.editTextPass.text.trim().isEmpty()){
                Toast.makeText(activity, "Enter your PASSWORD!", Toast.LENGTH_SHORT).show()
            }*/
            else{
                val user = loginDao.search(binding.editTextEmail.text.toString(), binding.editTextPass.text.toString())
                if(user==null){
                    Toast.makeText(activity, "Incorrect Information", Toast.LENGTH_SHORT).show()
                }else{
                    UserLoginCheck.user = user
                    view?.findNavController()?.navigate(R.id.action_loginFragment_to_homeFragment)
                }
            }
            //view?.findNavController()?.navigate(R.id.action_loginFragment_to_appFragment)
        }

        return binding.root
    }
}