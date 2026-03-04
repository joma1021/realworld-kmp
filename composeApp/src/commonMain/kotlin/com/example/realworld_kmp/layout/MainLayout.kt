package com.example.realworld_kmp.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.example.realworld_kmp.layout.nav.NavBar
import com.example.realworld_kmp.layout.nav.NavTab
import com.example.realworld_kmp.layout.nav.NavViewModel
import com.example.realworld_kmp.theme.RealWorldTheme

@Composable
fun MainLayout(
  navViewModel: NavViewModel = remember { NavViewModel() },
  onTabSelected: (NavTab) -> Unit, //
  content: @Composable (paddingValues: PaddingValues) -> Unit

) {
  val selectedTab by navViewModel.selectedTab.collectAsState()
  RealWorldTheme {
    Scaffold(
      topBar = {
        NavBar(
          selectedTab = selectedTab,
          onTabSelected = { newTab ->
            onTabSelected(newTab)
          }
        )
      }
    ) { innerPadding ->
      content(innerPadding)
    }
  }
}