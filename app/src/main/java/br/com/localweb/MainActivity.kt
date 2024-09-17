package br.com.localweb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.localweb.Screens.CadastroScreen
import br.com.localweb.Screens.CalendarioScreen
import br.com.localweb.Screens.ConfirmacaoScreen
import br.com.localweb.Screens.HomeScreen
import br.com.localweb.Screens.LoginScreen
import br.com.localweb.Screens.Mensagem_CadastroScreen
import br.com.localweb.ui.theme.LocalWebTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LocalWebTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login" +
                                "",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.End,
                                tween(1000)
                            ) + fadeOut(animationSpec = tween(1500))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                tween(1000)
                            )
                        }

                    ) {
                        composable("login") {
                            //LoginScreen(navController)
                            CalendarioScreen(navController)
                        }
                        composable("cadastro") {
                            CadastroScreen(navController)
                        }
                        composable("confirmacao") {
                            ConfirmacaoScreen(navController)
                        }
                        composable("mensagem") {
                            Mensagem_CadastroScreen(navController)
                        }
                        composable("home"){
                            HomeScreen(navController)
                        }


                    }

                }
            }
        }
    }
}

