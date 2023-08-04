package ir.behrooz.bmicalculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTest {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_170_height_65_weight_BMItext_contain_22(){

        onView(withId(R.id.edt_height))
            .perform(typeText("170"))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.edt_weight))
            .perform(typeText("65"))
            .perform(closeSoftKeyboard())

        onView(withId(R.id.btn_calculate))
            .perform(click())

        onView(withId(R.id.tv_result_bmi))
            .check(matches(withText(containsString("22"))))

    }


}