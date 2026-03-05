package com.example.realworld_kmp.navigation

import androidx.navigation.NavController


class NavAction(private val navController: NavController) {
  fun onTabSelected(tab: NavTab) {
    val route = when (tab) {
      NavTab.HOME -> AppRoutes.HOME
      NavTab.SIGN_IN -> AppRoutes.LOGIN
      NavTab.SIGN_UP -> AppRoutes.REGISTER
    }
    navController.navigate(route) {
      launchSingleTop = true
      restoreState = true
    }
  }
}