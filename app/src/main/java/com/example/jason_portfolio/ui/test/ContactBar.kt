package com.example.jason_portfolio.ui.test

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContactBar(
    email: String?,
    phone: String?,
    linkedIn: String?,
    gitHub: String?,
    onEmailClick: () -> Unit,
    onPhoneClick: () -> Unit,
    onLinkedInClick: () -> Unit,
    onGitHubClick: () -> Unit
) {
    var emailExpanded by remember { mutableStateOf(false) }
    var phoneExpanded by remember { mutableStateOf(false) }
    var linkedInExpanded by remember { mutableStateOf(false) }
    var gitHubExpanded by remember { mutableStateOf(false) }

    Surface(
        tonalElevation = 6.dp,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Email Section
            Column {
                Text(
                    text = "📧 Gmail",
                    modifier = Modifier.clickable {
                        emailExpanded = !emailExpanded
                        onEmailClick()
                    }
                )
                if (emailExpanded) {
                    Text(
                        text = email ?: "No email available",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            // Phone Section
            Column {
                Text(
                    text = "📱 Phone",
                    modifier = Modifier.clickable {
                        phoneExpanded = !phoneExpanded
                        onPhoneClick()
                    }
                )
                if (phoneExpanded) {
                    Text(
                        text = phone ?: "No phone available",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            // LinkedIn Section
            Column {
                Text(
                    text = "💼 LinkedIn",
                    modifier = Modifier.clickable {
                        linkedInExpanded = !linkedInExpanded
                        onLinkedInClick()
                    }
                )
                if (linkedInExpanded) {
                    Text(
                        text = linkedIn ?: "No LinkedIn available",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }

            // GitHub Section
            Column {
                Text(
                    text = "🐙 GitHub",
                    modifier = Modifier.clickable {
                        gitHubExpanded = !gitHubExpanded
                        onGitHubClick()
                    }
                )
                if (gitHubExpanded) {
                    Text(
                        text = gitHub ?: "No GitHub available",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}
