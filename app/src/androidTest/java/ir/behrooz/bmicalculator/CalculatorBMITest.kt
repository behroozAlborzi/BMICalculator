package ir.behrooz.bmicalculator

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorBMITest {


    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

//    @Test
//    fun calculate_BMI_testing(){
//        val main = MainActivity()
//        assertEquals(22,main.calculateBMI(170.0,65.0))
//    }

}