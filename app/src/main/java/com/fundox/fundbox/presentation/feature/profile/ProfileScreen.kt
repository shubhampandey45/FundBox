package com.fundox.fundbox.presentation.feature.profile

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.fundox.fundbox.core.Constants.REVOKE_ACCESS_MESSAGE
import com.fundox.fundbox.core.Constants.SIGN_OUT
import com.fundox.fundbox.presentation.feature.profile.components.ProfileContent
import com.fundox.fundbox.presentation.feature.profile.components.ProfileTopBar
import com.fundox.fundbox.presentation.feature.profile.components.RevokeAccess
import com.fundox.fundbox.presentation.feature.profile.components.SignOut
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToAuthScreen: () -> Unit
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = { ProfileTopBar() },
        content = { padding ->
            ProfileContent(
                padding = padding,
                photoUrl = viewModel.photoUrl,
                displayName = viewModel.displayName,
                signOut = { viewModel.signOut() },
                revokeAccess = { viewModel.revokeAccess() }
            )
        },
        snackbarHost = { androidx.compose.material3.SnackbarHost(snackBarHostState) }
    )

    SignOut(
        navigateToAuthScreen = { signedOut ->
            if (signedOut) {
                navigateToAuthScreen()
            }
        }
    )

    fun showSnackBar() = coroutineScope.launch {
        val result = snackBarHostState.showSnackbar(
            message = REVOKE_ACCESS_MESSAGE,
            actionLabel = SIGN_OUT
        )
        if (result == SnackbarResult.ActionPerformed) {
            viewModel.signOut()
        }
    }

    RevokeAccess(
        navigateToAuthScreen = { accessRevoked ->
            if (accessRevoked) {
                navigateToAuthScreen()
            }
        },
        showSnackBar = {
            showSnackBar()
        }
    )
}