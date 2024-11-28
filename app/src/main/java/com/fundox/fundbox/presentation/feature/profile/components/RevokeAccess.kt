package com.fundox.fundbox.presentation.feature.profile.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.fundox.fundbox.components.ProgressBar
import com.fundox.fundbox.domain.model.Response
import com.fundox.fundbox.presentation.feature.profile.ProfileViewModel

@Composable
fun RevokeAccess(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigateToAuthScreen: (accessRevoked: Boolean) -> Unit,
    showSnackBar: () -> Unit
) {
    when (val revokeAccessResponse = viewModel.revokeAccessResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> revokeAccessResponse.data?.let { accessRevoked ->
            LaunchedEffect(accessRevoked) {
                navigateToAuthScreen(accessRevoked)
            }
        }

        is Response.Failure -> LaunchedEffect(Unit) {
            print(revokeAccessResponse.e)
            showSnackBar()
        }
    }
}