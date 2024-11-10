package com.fundox.fundbox.presentation.features.auth.viewmodels.events

data class AuthEvents(
    val loading: Boolean = false,
    val data: UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId: String,
    val username: String?,
    val profilePictureUrl: String?
)