import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.realworld_kmp.home.HomeScreen
import com.example.realworld_kmp.layout.MainLayout
import com.example.realworld_kmp.layout.nav.NavTab
import com.example.realworld_kmp.layout.nav.NavViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview


object AppRoutes {
  const val HOME = "home"
  const val LOGIN = "login"
  const val REGISTER = "register"
}


@Composable
@Preview
fun App(onNavHostReady: suspend (NavController) -> Unit = {}) {
  val navController = rememberNavController()
  // Erstellen Sie die ViewModel-Instanz hier und geben Sie sie weiter
  val navViewModel = remember { NavViewModel() }

  // Beobachten Sie den ausgewählten Tab aus dem ViewModel.
  // Wenn sich der Tab im ViewModel ändert, wird dieser Code neu ausgeführt.
  val selectedTab by navViewModel.selectedTab.collectAsState(initial = navViewModel.selectedTab.value)

  // Diese Logik wird ausgelöst, wenn sich `selectedTab` ändert
  LaunchedEffect(selectedTab) {
    val route = when (selectedTab) {
      NavTab.HOME -> AppRoutes.HOME
      NavTab.SIGN_IN -> AppRoutes.LOGIN
      NavTab.SIGN_UP -> AppRoutes.REGISTER
    }
    navController.navigate(route) { launchSingleTop = true }
    onNavHostReady(navController)
  }


  MainLayout(navViewModel = navViewModel) { innerPadding ->
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



