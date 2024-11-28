package com.fundox.fundbox.presentation.feature.profile.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.fundox.fundbox.core.Constants.PROFILE_SCREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopBar() {
    TopAppBar(
        title = {
            Text(
                text = PROFILE_SCREEN
            )
        }
    )
}
