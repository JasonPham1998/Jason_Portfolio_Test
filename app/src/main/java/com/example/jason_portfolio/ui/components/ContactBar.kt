package com.example.jason_portfolio.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
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
fun ContactBar() {
    var showEmail by remember { mutableStateOf(false) }
    var showPhone by remember { mutableStateOf(false) }
    var showLinkedIn by remember { mutableStateOf(false) }
    var showGitHub by remember { mutableStateOf(false) }
    Surface(
        tonalElevation = 5.dp,
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
            Column{
                Text(text="📧 Gmail",
                    modifier = Modifier.clickable{
                        showEmail = !showEmail
                    })
                AnimatedVisibility(visible = showEmail) {
                    Text(text = "baopham1422@gmail.com")}
            }

            Column {
                Text(text="📱 Phone",
                        modifier = Modifier.clickable {
                            showPhone = !showPhone
                        }
                    )

                    AnimatedVisibility(visible = showPhone) {
                        Text("604-726-9204")
                    }
                }

            Column {
                    Text(
                        text ="💼 LinkedIn",
                        modifier = Modifier.clickable {
                            showLinkedIn = !showLinkedIn
                        }
                    )

                    AnimatedVisibility(visible = showLinkedIn) {
                        Text("https://www.linkedin.com/in/jason-pham-057268229/")
                    }
                }

                Column {
                    Text(
                        text = "🐙 GitHub",
                        modifier = Modifier.clickable {
                            showGitHub = !showGitHub
                        }
                    )

                    AnimatedVisibility(visible = showGitHub) {
                        Text("https://github.com/JasonPham1998")
                    }
                }
    }
}
}
