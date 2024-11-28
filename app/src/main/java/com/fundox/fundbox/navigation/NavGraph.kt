package com.fundox.fundbox.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fundox.fundbox.presentation.feature.auth.AuthScreen
import com.fundox.fundbox.presentation.feature.profile.ProfileScreen

@Composable
@ExperimentalAnimationApi
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AuthScreen.route,
        enterTransition = {EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(
            route = Screen.AuthScreen.route
        ) {
            AuthScreen(
                navigateToProfileScreen = {
                    navController.navigate(Screen.ProfileScreen.route)
                }
            )
        }
        composable(
            route = Screen.ProfileScreen.route
        ) {
            ProfileScreen(
                navigateToAuthScreen = {
                    navController.popBackStack()
                    navController.navigate(Screen.AuthScreen.route)
                }
            )
        }
    }
}