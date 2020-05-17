package com.example.daggerwithmitch.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.daggerwithmitch.models.AuthToken
import com.example.daggerwithmitch.repository.auth.AuthRepository
import com.example.daggerwithmitch.BaseViewModel
import com.example.daggerwithmitch.ui.DataState
import com.example.daggerwithmitch.ui.Loading
import com.example.daggerwithmitch.ui.auth.state.AuthStateEvent
import com.example.daggerwithmitch.ui.auth.state.AuthViewState
import com.example.daggerwithmitch.ui.auth.state.LoginFields
import com.example.daggerwithmitch.ui.auth.state.RegistrationFields
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    val authRepository: AuthRepository
) : BaseViewModel<AuthStateEvent, AuthViewState>()
{

    override fun handleStateEvent(stateEvent: AuthStateEvent): LiveData<DataState<AuthViewState>> {
        when(stateEvent){

            is AuthStateEvent.LoginAttemptEvent -> {
                return authRepository.attemptLogin(
                    stateEvent.email,
                    stateEvent.password
                )
            }

            is AuthStateEvent.RegisterAttemptEvent -> {
                return authRepository.attemptRegistration(
                    stateEvent.email,
                    stateEvent.username,
                    stateEvent.password,
                    stateEvent.confirm_password
                )
            }

            is AuthStateEvent.CheckPreviousAuthEvent -> {
                return authRepository.checkPreviousAuthUser()
            }


            is AuthStateEvent.None ->{
                return liveData {
                    emit(
                        DataState(
                            null,
                            Loading(false),
                            null
                        )
                    )
                }
            }
        }
    }

    override fun initNewViewState(): AuthViewState {
        return AuthViewState()
    }

    fun setRegistrationFields(registrationFields: RegistrationFields){
        val update = getCurrentViewStateOrNew()
        if(update.registrationFields == registrationFields){
            return
        }
        update.registrationFields = registrationFields
        setViewState(update)
    }

    fun setLoginFields(loginFields: LoginFields){
        val update = getCurrentViewStateOrNew()
        if(update.loginFields == loginFields){
            return
        }
        update.loginFields = loginFields
        setViewState(update)
    }

    fun setAuthToken(authToken: AuthToken){
        val update = getCurrentViewStateOrNew()
        if(update.authToken == authToken){
            return
        }
        update.authToken = authToken
        setViewState(update)
    }

    fun cancelActiveJobs(){
        handlePendingData()
        authRepository.cancelActiveJobs()
    }

    fun handlePendingData(){
        setStateEvent(AuthStateEvent.None())
    }

    override fun onCleared() {
        super.onCleared()
        cancelActiveJobs()
    }
}