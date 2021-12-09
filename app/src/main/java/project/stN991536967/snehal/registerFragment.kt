package project.stN991536967.snehal
/*
* sadada*/
import android.os.Bundle
import android.util.Patterns
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
import project.stN991536967.snehal.databinding.FragmentRegisterBinding


class registerFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater,
            R.layout.fragment_register,container,false)

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


        val application = requireNotNull(this.activity).application
        val loginDao = fitDatabase.getInstance(application).loginDao()

        binding.btnRegister.setOnClickListener {
            if(binding.editTextName.text.trim().isEmpty()  ||  binding.editTextEmail.text.trim().isEmpty() ||
                binding.editTextPass.text.trim().isEmpty()
                    ) {
                Toast.makeText(activity, "Enter Valid Information", Toast.LENGTH_SHORT).show()
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(binding.editTextEmail.text.toString()).matches()){
                Toast.makeText(activity, "Enter valid email address!", Toast.LENGTH_SHORT).show()
            }
            /*else if (loginDao.exists(binding.editTextEmail.text.trim().toString()) == true){
                Toast.makeText(activity, "Email is already registered!", Toast.LENGTH_SHORT).show()
            }*/
            else if (binding.checkBoxTerms.isChecked!=true) {
                Toast.makeText(activity, "Please Agree to Terms", Toast.LENGTH_SHORT).show()
            }
            else{
                val newUser = LoginEntity(0, binding.editTextName.text.toString(), binding.editTextEmail.text.toString(), binding.editTextPass.text.toString())
                loginDao.userRegister(newUser)
                view?.findNavController()?.navigate(R.id.action_registerFragment_to_welcomeFragment)
            }
        }
        return binding.root
    }
}