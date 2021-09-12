package com.example.officeproject

import com.example.officeproject.api.apis.UserApi
import com.example.officeproject.api.request.LoginRequest
import com.example.officeproject.api.request.PatchUserRequest
import com.example.officeproject.api.response.DriverListResponse
import com.example.officeproject.api.response.LoginResponse
import com.example.officeproject.api.response.PatchUserResponse

class UserRepository(var userApi:UserApi) {

    suspend fun checkLogin(loginRequest: LoginRequest): LoginResponse {
       return userApi.checkLogin(loginRequest)
    }
    suspend fun getDriverList(): DriverListResponse {
        return userApi.getDriverDetails()
    }
    suspend fun patchDriver(request:PatchUserRequest): PatchUserResponse {
        return userApi.patchUserDetails(request)
    }


}