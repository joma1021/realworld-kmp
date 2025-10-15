package com.example.realworld_kmp.layout.nav

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class NavViewModel {
  // Der aktuell ausgewählte Tab, standardmäßig HOME.
  var selectedTab by mutableStateOf(NavTab.HOME)
    private set // Kann nur innerhalb des ViewModels geändert werden.

  /**
   * Aktualisiert den ausgewählten Tab.
   */
  fun setTab(newTab: NavTab) {
    selectedTab = newTab
    // Hier würde die eigentliche Navigation stattfinden (z.B. mit Voyager)
    println("Navigation zu Tab: $newTab")
  }
}