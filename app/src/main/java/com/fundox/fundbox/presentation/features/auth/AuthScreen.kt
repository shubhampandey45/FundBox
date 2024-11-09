package com.fundox.fundbox.presentation.features.auth

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.fundox.fundbox.R
import com.fundox.fundbox.presentation.features.auth.viewmodels.AuthViewModel
import com.fundox.fundbox.presentation.navGraph.Routes
import com.fundox.fundbox.ui.theme.FundBoxTheme
import com.fundox.fundbox.ui.theme.spacing


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(
    authViewModel: AuthViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val authScreenState by authViewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.auth_screen_title))
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.extraLarge))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.mediumLarge),
                onClick = { navController.navigate(Routes.HomeScreen.route) }
            ) {
                Text(text = "Log In")
            }
        }
    }
}


@Composable
@Preview
@Preview(name = "Night Mode", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun AuthScreenPreview() {
    FundBoxTheme {
    }
}