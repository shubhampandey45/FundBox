package com.fundox.fundbox.presentation.features.auth.viewmodels.events

data class AuthState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)