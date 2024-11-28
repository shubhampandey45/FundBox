@file:Suppress("DEPRECATION")

package com.fundox.fundbox.presentation.feature.auth.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.fundox.fundbox.components.ProgressBar
import com.fundox.fundbox.domain.model.Response
import com.fundox.fundbox.navigation.Screen
import com.fundox.fundbox.presentation.feature.auth.AuthViewModel
import com.google.android.gms.auth.api.identity.BeginSignInResult

@Composable
fun OneTapSignIn(
    viewModel: AuthViewModel = hiltViewModel(),
    launch: (result: BeginSignInResult) -> Unit
) {
    when(val oneTapSignInResponse = viewModel.oneTapSignInResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> oneTapSignInResponse.data?.let {
            LaunchedEffect(it) {
                launch(it)
            }
        }
        is Response.Failure -> LaunchedEffect(Unit) {
            print(oneTapSignInResponse.e)
        }
    }
}

fun checkAuthState(viewModel: AuthViewModel, navController: NavController) {
    if(viewModel.isUserAuthenticated) {
        navigateToProfileScreen(navController)
    }
}

private fun navigateToProfileScreen(navController: NavController) = navController.navigate(Screen.ProfileScreen.route)