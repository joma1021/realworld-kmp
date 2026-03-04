package com.example.realworld_kmp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.realworld_kmp.home.HomeScreen
import com.example.realworld_kmp.layout.MainLayout
import com.example.realworld_kmp.layout.nav.AppRoutes
import com.example.realworld_kmp.layout.nav.NavAction
import com.example.realworld_kmp.layout.nav.NavTab
import com.example.realworld_kmp.layout.nav.NavViewModel


@Composable
@Preview
fun App(onNavHostReady: suspend (NavController) -> Unit = {}) {
  val navController = rememberNavController()
  val navViewModel = remember { NavViewModel() }
  val navAction = remember(navController) { NavAction(navController) }


  LaunchedEffect(navController) {
    onNavHostReady(navController)
    navController.currentBackStackEntryFlow.collect { entry ->
      println("Navigation: Aktuelle Route ist nun: ${entry.destination.route}")
    }
  }

  LaunchedEffect(navController) {
    navController.currentBackStackEntryFlow.collect { entry ->
      val route = entry.destination.route
      val tab = when (route) {
        AppRoutes.HOME -> NavTab.HOME
        AppRoutes.LOGIN -> NavTab.SIGN_IN
        AppRoutes.REGISTER -> NavTab.SIGN_UP
        else -> NavTab.HOME
      }
      navViewModel.selectTab(tab) // ViewModel nur informieren!
    }
  }



  MainLayout(
    navViewModel = navViewModel,
    onTabSelected = navAction::onTabSelected,
  ) { innerPadding ->
    NavHost(
      navController = navController,
      startDestination = AppRoutes.HOME,
      modifier = Modifier.padding(innerPadding)
    ) {
      composable(AppRoutes.HOME) {
        HomeScreen()
      }
      composable(AppRoutes.LOGIN) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
          Text("Login Screen")
        }
      }
      composable(AppRoutes.REGISTER) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
          Text("Register Screen")
        }
      }
    }


  }
}



