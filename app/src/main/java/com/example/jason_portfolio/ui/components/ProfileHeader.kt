package com.example.jason_portfolio.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image

import androidx.compose.foundation.border

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import com.example.jason_portfolio.navigation.Screen

import com.example.jason_portfolio.ui.screens.EducationScreen
import com.example.jason_portfolio.ui.screens.HomeScreen
import com.example.jason_portfolio.ui.screens.TechScreen
import com.example.jason_portfolio.ui.screens.ExperienceScreen
import com.example.jason_portfolio.R


@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun ProfileHeader() {
    var selectedTab by remember {
        mutableStateOf(0)
    }

    val tabs = listOf(
        Screen.Home,
        Screen.Experience,
        Screen.Tech,
        Screen.Education
    )
    Image(
        painter = painterResource(R.drawable.jason_photo),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .border(
                3.dp,
                Color.Black,
                CircleShape
            )
    )

    Spacer(modifier = Modifier.height(20.dp))

    Text(
        text = "Jason Pham",
        color = Color.Black,
        fontSize = 40.sp,
        fontWeight = FontWeight.ExtraBold,
        fontStyle = FontStyle.Italic
    )

    Text(
        text = "Android Developer",
        color = Color.Green,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    )

    Spacer(modifier = Modifier.height(16.dp))

    ContactBar(
    )

    Spacer(modifier = Modifier.height(16.dp))

    Column {

        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color.LightGray.copy(alpha= 0.5f),
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 2.dp)
                .clip(RoundedCornerShape(50)),
            indicator = {tabPosition -> TabRowDefaults.SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPosition[selectedTab]),
                color= Color.Blue,
                height = 4.dp
            )}
        ) {
            tabs.forEachIndexed { index, item ->
                Tab(
                    selected = selectedTab == index,
                    onClick = {
                        selectedTab = index
                    },
                    text = { Text(item.title)
                    }
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








