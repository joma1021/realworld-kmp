package com.example.realworld_kmp.layout.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

// Ein Enum, das die verschiedenen Tabs repräsentiert, analog zu NavTab in Flutter.
enum class NavTab {
  HOME,
  SIGN_IN,
  SIGN_UP
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavBar(
  selectedTab: NavTab,
  onTabSelected: (NavTab) -> Unit
) {
  TopAppBar(
    title = {
      TextButton(
        onClick = { onTabSelected(NavTab.HOME) }
      ) {
        Text(
          text = "conduit",
          style = MaterialTheme.typography.headlineSmall.copy(
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.W900,
          )

        )
      }
    },
    actions = {
      NavTextButton(
        name = "Home",
        isSelected = (selectedTab == NavTab.HOME),
        onClick = { onTabSelected(NavTab.HOME) },
        icon = Icons.Default.Home
      )
      NavTextButton(
        name = "Sign in",
        isSelected = (selectedTab == NavTab.SIGN_IN),
        onClick = { onTabSelected(NavTab.SIGN_IN) },
        icon = Icons.AutoMirrored.Filled.Login
      )
      NavTextButton(
        name = "Sign up",
        isSelected = (selectedTab == NavTab.SIGN_UP),
        onClick = { onTabSelected(NavTab.SIGN_UP) }
      )
    },
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = MaterialTheme.colorScheme.surface,
      titleContentColor = MaterialTheme.colorScheme.secondary
    )
  )
}



