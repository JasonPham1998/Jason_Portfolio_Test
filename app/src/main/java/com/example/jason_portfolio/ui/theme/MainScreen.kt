package com.example.jason_portfolio.ui.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jason_portfolio.navigation.Screen
import com.example.jason_portfolio.presentation.MainUiState
import com.example.jason_portfolio.ui.components.AnimatedWaveBackground
import com.example.jason_portfolio.ui.components.ProfileHeader
import com.example.jason_portfolio.ui.screens.education.EducationScreen
import com.example.jason_portfolio.ui.screens.experience.ExperienceScreen
import com.example.jason_portfolio.ui.screens.home.HomeScreen
import com.example.jason_portfolio.ui.screens.tech.TechScreen
import com.example.jason_portfolio.ui.components.ContactBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(uiState: MainUiState, onContactClick: (String) -> Unit) {

    var selectedTab by remember { mutableStateOf(0) }

    val tabs = listOf(
        Screen.Home,
        Screen.Experience,
        Screen.Tech,
        Screen.Education
    )

    AnimatedWaveBackground()
    Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally)

        { Spacer(modifier = Modifier.height(20.dp))
            ProfileHeader()
            Spacer(modifier = Modifier.height(16.dp))
            ContactBar(
                email = uiState.email,
                phone = uiState.phone,
                linkedIn = uiState.linkedIn,
                gitHub = uiState.gitHub,
                onEmailClick = { onContactClick("email") },
                onPhoneClick = { onContactClick("phone") },
                onLinkedInClick = { onContactClick("linkedIn") },
                onGitHubClick = { onContactClick("gitHub") }
            )



            PrimaryTabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color.LightGray.copy(alpha = 0.5f),
                contentColor = Color.Black,
                modifier = Modifier.padding(vertical = 8.dp, horizontal =0.dp)
                    .fillMaxWidth()
            )


            {
                tabs.forEachIndexed { index, item ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(item.title,
                            fontSize = 12.sp,
                            fontWeight = if (selectedTab == index)
                                FontWeight.Bold
                            else FontWeight.Normal,
                            ) }
                    )
                }
            }

            when (selectedTab) {
                0 -> HomeScreen()
                1 -> ExperienceScreen()
                2 -> TechScreen()
                3 -> EducationScreen()
            }
        }
    }



