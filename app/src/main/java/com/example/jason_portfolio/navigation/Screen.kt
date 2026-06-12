package com.example.jason_portfolio.navigation

sealed class Screen(
    val title:String
) {

    object Home : Screen("Home")

    object Experience : Screen("Experience")

    object Tech : Screen("Tech")

    object Education : Screen("Education")
}