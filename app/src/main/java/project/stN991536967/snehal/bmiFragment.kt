package project.stN991536967.snehal
/*
* Snehal Patel
* */
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.material.navigation.NavigationView
import project.stN991536967.snehal.databinding.FragmentBmiBinding

class bmiFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                        savedInstanceState: Bundle?): View? {
        var binding = DataBindingUtil.inflate<FragmentBmiBinding>(inflater,
            R.layout.fragment_bmi,container,false)
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

        binding.btnCalculate.setOnClickListener {
            if(binding.weight.text.isEmpty() || binding.height.text.isEmpty()){
                Toast.makeText(activity, "Enter Valid Inputs", Toast.LENGTH_SHORT).show()
            }
            else{
                var result = 0.0
                val weight = binding.weight.text.toString().toFloat()
                val height = binding.height.text.toString().toFloat()

                result = ((weight/height/height * 10000).toDouble())

                if(result<18.5){
                    binding.textBmi.text = "Your BMI: %.2f".format(result)
                    binding.textHealth.text = "Underweight"
                }else if(result in 18.5..24.9){
                    binding.textBmi.text = "Your BMI: %.2f".format(result)
                    binding.textHealth.text = "Normal Weight"
                }else if(result in 25.0..29.9){
                    binding.textBmi.text = "Your BMI: %.2f".format(result)
                    binding.textHealth.text = "Overweight"
                }else if(result > 30){
                    binding.textBmi.text = "Your BMI: %.2f".format(result)
                    binding.textHealth.text = "Obesity"
                }
                binding.result.setText("BMI : \n Normal Weight = 19 - 25 \n Underweight = less than 19 \n" +
                        "Overweight is greater than 25")

            }
        }
        return binding.root
    }
}