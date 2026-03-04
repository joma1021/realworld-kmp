package com.example.realworld_kmp.shared.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class NavViewModel {

  private val _selectedTab = MutableStateFlow(NavTab.HOME)
  val selectedTab = _selectedTab.asStateFlow()

  fun selectTab(newTab: NavTab) {
    _selectedTab.update { newTab }
    println("ViewModel state updated to tab: $newTab")
  }
}