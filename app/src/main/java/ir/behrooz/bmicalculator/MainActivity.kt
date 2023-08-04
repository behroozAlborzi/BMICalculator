package ir.behrooz.bmicalculator

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import ir.behrooz.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViews()

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->

            val text = when (checkedId) {
                binding.radioBtnMale.id -> "Male"
                binding.radioBtnFemale.id -> "Female"
                else -> null
            }
            text?.let {


                Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            }

        }

        binding.swUsUnits.setOnCheckedChangeListener { buttonView, isChecked ->

            if (buttonView.isPressed.not()){
                return@setOnCheckedChangeListener
            }

            val text = if (isChecked) "Active" else "Inactive"

            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

        }

    }

    private fun setUpViews() {

        with(binding) {

            btnCalculate.setOnClickListener {

                hideKeyboard()
                var height = edtHeight.text.toString().toDoubleOrNull()
                val weight = edtWeight.text.toString().toDoubleOrNull()
                val bmi: Double? = if (height != null && weight != null) {
                    height /= 100.0
                    Calculate().calculateBMI(height, weight)
                } else {
                    null
                }

                if (bmi != null) {

                    printBMIText(bmi)

                } else {
                    Snackbar.make(root, "You must Fill int the blanks", Snackbar.LENGTH_SHORT)
                        .show()
                }

            }

        }

    }

    private fun printBMIText( bmi:Double) {
        with(binding){


            when (bmi) {
                in 1.0..18.5 -> {
                    tvResultBmi.text = String.format(
                        getString(R.string.main_lable_bmi),
                        bmi.toString(),
                        " You are Underweight "
                    )
                }

                in 18.5..25.0 -> {
                    tvResultBmi.text = String.format(
                        getString(R.string.main_lable_bmi),
                        bmi.toString(),
                        " You are a healthy weight "
                    )
                }

                in 25.0..29.9 -> {
                    tvResultBmi.text = String.format(
                        getString(R.string.main_lable_bmi),
                        bmi.toString(),
                        " You are Overweight "
                    )
                }

                else -> {
                    tvResultBmi.text = String.format(
                        getString(R.string.main_lable_bmi),
                        bmi.toString(),
                        " You are obese "
                    )
                }

            }

        }
    }


    private fun hideKeyboard() {

        val hide = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hide.hideSoftInputFromWindow(binding.btnCalculate.windowToken, 0)

    }
}