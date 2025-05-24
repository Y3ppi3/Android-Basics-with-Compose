package com.example.app

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.app.data.dogs
import com.example.app.ui.theme.AppTheme
import org.junit.Rule
import org.junit.Test

class WoofAccessibilityTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun woof_app_list_content_exists() {
        // Start the app
        composeTestRule.setContent { 
            AppTheme {
                WoofApp()
            }
        }

        // Verify the first dog's name is displayed
        composeTestRule
            .onNodeWithText(dogs[0].name)
            .assertIsDisplayed()
    }
    
    @Test
    fun expanding_card_shows_hobby() {
        // Start the app
        composeTestRule.setContent { 
            AppTheme {
                WoofApp()
            }
        }

        // Find and click the "Show more" button for the first dog
        composeTestRule
            .onNodeWithContentDescription("Show more")
            .performClick()

        // Verify the hobby text is now displayed
        composeTestRule
            .onNodeWithText(dogs[0].hobbies)
            .assertIsDisplayed()
    }
}