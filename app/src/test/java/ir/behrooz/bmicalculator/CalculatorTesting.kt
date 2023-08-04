package ir.behrooz.bmicalculator

import org.junit.Assert.assertEquals
import org.junit.Test


class CalculatorTesting {
    private val calculate = Calculate()
    @Test
    fun calculate_BMI_testing(){
        assertEquals( 22.49,calculate.calculateBMI(1.70,65.0))

    }

    @Test
    fun calculate_BMI_null_testing(){
        assertEquals( null,calculate.calculateBMI(null,null))
    }
}