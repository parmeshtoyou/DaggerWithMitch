package com.example.daggerwithmitch.api.auth

import androidx.lifecycle.LiveData
import com.example.daggerwithmitch.util.GenericApiResponse
import com.example.daggerwithmitch.api.auth.network_responses.LoginResponse
import com.example.daggerwithmitch.api.auth.network_responses.RegistrationResponse
import com.example.daggerwithmitch.di.auth.AuthScope
import retrofit2.http.*

@AuthScope
interface OpenApiAuthService {

    @POST("account/login")
    @FormUrlEncoded
    fun login(
        @Field("username") email: String,
        @Field("password") password: String
    ): LiveData<GenericApiResponse<LoginResponse>>

    @POST("account/register")
    @FormUrlEncoded
    fun register(
        @Field("email") email: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("password2") password2: String
    ): LiveData<GenericApiResponse<RegistrationResponse>>

}
