package com.fundox.fundbox.navigation

import com.fundox.fundbox.core.Constants.AUTH_SCREEN
import com.fundox.fundbox.core.Constants.PROFILE_SCREEN

sealed class Screen(val route: String) {
    object AuthScreen: Screen(AUTH_SCREEN)
    object ProfileScreen: Screen(PROFILE_SCREEN)
}