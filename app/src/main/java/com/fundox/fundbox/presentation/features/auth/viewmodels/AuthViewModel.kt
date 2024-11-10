package com.fundox.fundbox.presentation.features.auth.viewmodels

import androidx.lifecycle.ViewModel
import com.fundox.fundbox.presentation.features.auth.viewmodels.events.AuthEvents
import com.fundox.fundbox.presentation.features.auth.viewmodels.events.AuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(

) : ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state = _state.asStateFlow()

    fun onSignInResult(result: AuthEvents){
        _state.update {
            it.copy(
                isSignInSuccessful = result.data != null,
                signInError = result.errorMessage
            )
        }
    }

    fun resetState(){
        _state.update { AuthState() }
    }
}