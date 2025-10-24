package com.example.realworld_kmp.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.example.realworld_kmp.layout.nav.NavBar
import com.example.realworld_kmp.layout.nav.NavViewModel
import com.example.realworld_kmp.theme.RealWorldTheme

/**
 * Eine wiederverwendbare Layout-Struktur, analog zum BaseScaffold aus Flutter.
 *
 * @param content Der Inhalt der Seite, der innerhalb des Layouts angezeigt werden soll.
 */
@Composable
fun MainLayout(
  navViewModel: NavViewModel = remember { NavViewModel() },
  content: @Composable (paddingValues: PaddingValues) -> Unit
) {
  val selectedTab by navViewModel.selectedTab.collectAsState()
  RealWorldTheme {
    Scaffold(
      topBar = {
        NavBar(
          selectedTab = selectedTab,
          onTabSelected = { newTab ->

            navViewModel.setTab(newTab)
          }
        )
      }
    ) { innerPadding ->
      content(innerPadding)
    }
  }
}