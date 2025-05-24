package com.example.app

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.app.ui.theme.AppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TipCalculatorTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate20PercentTip() {
        // Start the app
        composeTestRule.setContent {
            AppTheme {
                TipTimeApp()
            }
        }

        // Enter $10 into the Bill Amount field
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")

        // Enter 20% as the tip percentage
        composeTestRule.onNodeWithText("Tip Percentage")
            .performTextInput("20")

        // Verify the tip amount is $2.00
        val expectedTip = formatCurrency(2.0)
        composeTestRule.onNodeWithText("Tip amount: $expectedTip")
            .assertExists()
    }
}