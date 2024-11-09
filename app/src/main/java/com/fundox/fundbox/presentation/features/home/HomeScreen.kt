package com.fundox.fundbox.presentation.features.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.fundox.fundbox.presentation.features.home.components.ProfileBanner
import com.fundox.fundbox.presentation.features.home.components.TotalDonationBanner
import com.fundox.fundbox.presentation.features.home.viewmodels.HomeViewModel
import com.fundox.fundbox.presentation.navGraph.BottomNavigationBar
import com.fundox.fundbox.presentation.navGraph.Routes
import com.fundox.fundbox.ui.theme.FundBoxTheme
import com.fundox.fundbox.ui.theme.spacing


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeScreenViewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val homeScreenState by homeScreenViewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier,
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer)
            ) {
                ProfileBanner(
                    url = "https://img.freepik.com/free-photo/androgynous-avatar-non-binary-queer-person_23-2151100221.jpg?t=st=1731180955~exp=1731184555~hmac=80b678d6032dfd07811db781736c21730af7752d301af20014f5334035356978&w=740",
                    onClick = { },
                    title = "Faraz"
                )
               // Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
                TotalDonationBanner()
            }
        },
        bottomBar = {
            BottomNavigationBar(navController)
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
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.mediumLarge),
                onClick = { navController.navigate(Routes.AuthScreen.route) }
            ) {
                Text(text = "Log Out")
            }
        }
    }
}

@Composable
@Preview
@Preview(name = "Night Mode", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun HomeScreenPreview() {
    FundBoxTheme {

    }
}