package com.example.realworld_kmp.layout.nav

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

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
  onTabSelected: (NavTab) -> Unit // Callback, um auf Klicks zu reagieren
) {
  // TopAppBar ist das direkte Äquivalent zur AppBar in Flutter.
  TopAppBar(
    // 'title' wird verwendet, um das "conduit"-Logo zu platzieren.
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
    // 'actions' ist für die Navigationslinks auf der rechten Seite.
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
    // Farben für die TopAppBar selbst, die aus dem Theme stammen.
    colors = TopAppBarDefaults.topAppBarColors(
      containerColor = MaterialTheme.colorScheme.surface,
      titleContentColor = MaterialTheme.colorScheme.secondary
    )
  )
}

/**
 * Ein wiederverwendbarer Text-Button für die Navigationsleiste,
 * analog zum _NavTextButton in Ihrem Flutter-Code.
 */
@Composable
private fun NavTextButton(
  name: String,
  isSelected: Boolean,
  onClick: () -> Unit,
  icon: ImageVector? = null
) {
  TextButton(onClick = onClick) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      if (icon != null) {
        Icon(
          imageVector = icon,
          contentDescription = name, // Wichtig für Barrierefreiheit
          tint = if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurface.copy(
            alpha = 0.3f
          )
        )
        // Fügen Sie einen kleinen Abstand zwischen Icon und Text hinzu
        Spacer(modifier = Modifier.width(4.dp))
      }
      Text(
        text = name,
        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
        color = if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurface.copy(
          alpha = 0.3f
        )
      )
    }

  }
}

