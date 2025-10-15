package com.example.realworld_kmp.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.realworld_kmp.layout.nav.NavBar
import com.example.realworld_kmp.layout.nav.NavViewModel
import com.example.realworld_kmp.theme.RealworldTheme

/**
 * Eine wiederverwendbare Layout-Struktur, analog zum BaseScaffold aus Flutter.
 *
 * @param content Der Inhalt der Seite, der innerhalb des Layouts angezeigt werden soll.
 */
@Composable
fun MainLayout(
  // Optional: Übergeben Sie ein ViewModel, um es testbar zu machen.
  // `remember { NavViewModel() }` erstellt eine Instanz, die über den Lebenszyklus des Composables erhalten bleibt.
  navViewModel: NavViewModel = remember { NavViewModel() },
  content: @Composable (paddingValues: PaddingValues) -> Unit
) {
  // Holen Sie den aktuell ausgewählten Tab direkt aus dem ViewModel.
  val selectedTab = navViewModel.selectedTab

  RealworldTheme {
    Scaffold(
      topBar = {
        NavBar(
          selectedTab = selectedTab,
          onTabSelected = { newTab ->
            // Die Logik, was bei einem Klick passiert, wird hier definiert,
            // genau wie im `onPressed` der AppBar in Flutter.
            navViewModel.setTab(newTab)
          }
        )
      }
    ) { innerPadding ->
      // Der übergebene Inhalt wird hier aufgerufen.
      content(innerPadding)
    }
  }
}