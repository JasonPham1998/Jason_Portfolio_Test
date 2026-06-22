package com.example.jason_portfolio.ui.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable

fun ContactBar(
                email: String?,
                phone: String?,
                linkedIn: String?,
                gitHub: String?,
                onEmailClick: () ->Unit,
                onPhoneClick: () -> Unit,
                onLinkedInClick: () -> Unit,
                onGitHubClick: () -> Unit) {

    var expanded by remember { mutableStateOf<String?>(null)}

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
        )
        {
            Column {
                Text(
                    text = "📧 Gmail",
                    modifier = Modifier.clickable {
                        expanded = if (expanded == "email") null else "email"
                        onEmailClick()
                    }
                )
                if (expanded == "email") {
                    Text(
                        text = email ?: "No email available",
                        modifier = Modifier.padding(start = 16.dp)
                    )

                }
                Column {
                    Text(
                        text = "📱 Phone",
                        modifier = Modifier.clickable {
                            expanded = if (expanded == "phone") null else "phone"
                            onPhoneClick()
                        }
                    )

                    if (expanded == "phone") {
                        Text(
                            text = phone ?: "No phone available",
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }


                Column {
                    Text(
                        text = "💼 LinkedIn",
                        modifier = Modifier.clickable {
                            expanded = if (expanded == "linkedIn") null else "linkedIn"
                            onLinkedInClick()
                        }
                    )

                    if (expanded == "linkedIn") {
                        Text(
                            text = linkedIn ?: "No LinkedIn available",
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
                Column {
                    Text(
                        text = "🐙 GitHub",
                        modifier = Modifier.clickable {
                            expanded = if (expanded == "gitHub") null else "gitHub"
                            onGitHubClick()
                        }
                    )

                    if (expanded == "gitHub") {
                        Text(
                            text = gitHub ?: "No GitHub available",
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
        }
    }
}



