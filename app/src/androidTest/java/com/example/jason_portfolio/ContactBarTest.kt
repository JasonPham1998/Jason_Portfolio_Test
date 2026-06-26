package com.example.jason_portfolio

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.jason_portfolio.ui.test.ContactBar
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContactBarTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun contactBar_shows_all_details_when_expanded() {
        var emailClicked = false
        var phoneClicked = false
        var linkedInClicked = false
        var gitHubClicked = false
        composeRule.setContent {
            ContactBar(
                email = "john.doe@gmail.com",
                phone = "123456",
                linkedIn = "linkedin",
                gitHub = "github",
                onEmailClick = { emailClicked = true },
                onPhoneClick = { phoneClicked = true },
                onLinkedInClick = { linkedInClicked = true },
                onGitHubClick = { gitHubClicked = true }
            )
        }

        composeRule.onNodeWithText("📧 Gmail").performClick()
        composeRule.onNodeWithText("📱 Phone").performClick()
        composeRule.onNodeWithText("💼 LinkedIn").performClick()
        composeRule.onNodeWithText("🐙 GitHub").performClick()

        assert(emailClicked)
        assert(phoneClicked)
        assert(linkedInClicked)
        assert(gitHubClicked)
    }
}