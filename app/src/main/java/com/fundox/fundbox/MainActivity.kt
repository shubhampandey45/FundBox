package com.fundox.fundbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.fundox.fundbox.navigation.NavGraph
import com.fundox.fundbox.presentation.feature.auth.AuthViewModel
import com.fundox.fundbox.presentation.feature.auth.components.checkAuthState
import com.fundox.fundbox.ui.theme.FundBoxTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FundBoxTheme {
                navController = rememberNavController()
                NavGraph(
                    navController = navController
                )
                checkAuthState(viewModel, navController = navController)
            }
        }
    }
}