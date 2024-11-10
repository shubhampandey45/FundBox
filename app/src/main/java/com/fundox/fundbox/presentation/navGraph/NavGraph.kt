package com.fundox.fundbox.presentation.navGraph

import android.app.Activity.RESULT_OK
import android.content.Context
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.fundox.fundbox.presentation.features.auth.AuthScreen
import com.fundox.fundbox.presentation.features.auth.GoogleAuthUiClient
import com.fundox.fundbox.presentation.features.auth.viewmodels.AuthViewModel
import com.fundox.fundbox.presentation.features.home.HomeScreen
import kotlinx.coroutines.launch

@Composable
fun FundBoxNavGraph(
    googleAuthUiClient: GoogleAuthUiClient,
    navController: NavHostController = rememberNavController(),
    context : Context= LocalContext.current,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.AuthScreen.route
    ) {
        composable(route = Routes.AuthScreen.route) {
            val authViewModel: AuthViewModel = hiltViewModel()
            val state by authViewModel.state.collectAsStateWithLifecycle()
            val scope = rememberCoroutineScope()

            LaunchedEffect(key1 = Unit) {
                if (googleAuthUiClient.getSignedInUser() != null) {
                    navController.navigate(Routes.HomeScreen.route)
                }
            }

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult(),
                onResult = { result ->
                    if (result.resultCode == RESULT_OK) {
                        scope.launch {
                            val signInResult = googleAuthUiClient.signInWithIntent(
                                intent = result.data ?: return@launch
                            )
                            authViewModel.onSignInResult(signInResult)
                        }
                    }
                }
            )

            LaunchedEffect(key1 = state.isSignInSuccessful) {
                if (state.isSignInSuccessful) {
                    Toast.makeText(
                        context,
                        "Sign in successful",
                        Toast.LENGTH_LONG
                    ).show()
                    navController.navigate("home")
                    authViewModel.resetState()
                }
            }
            AuthScreen(
                state = state,
                onSignInClick = {
                    scope.launch {
                        val signInIntentSender = googleAuthUiClient.signIn()
                        launcher.launch(
                            IntentSenderRequest.Builder(
                                signInIntentSender ?: return@launch
                            ).build()
                        )
                    }
                }
            )
        }
        navigation(
            route = Routes.HomeScreen.route,
            startDestination = Routes.Home.route
        ) {
            composable(route = Routes.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(route = Routes.DonationList.route) {

            }
            composable(route = Routes.MyDonations.route) {

            }
            composable(route = Routes.Account.route) {

            }
        }
    }
}
