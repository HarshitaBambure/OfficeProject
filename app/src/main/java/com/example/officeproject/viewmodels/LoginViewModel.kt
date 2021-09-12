package com.example.officeproject.viewmodels

import androidx.lifecycle.ViewModel
import com.example.officeproject.UserRepository
import com.example.officeproject.api.RetrofitClient
import com.example.officeproject.api.request.LoginRequest
import com.example.officeproject.api.request.PatchUserRequest
import com.example.officeproject.api.response.DriverListResponse
import com.example.officeproject.api.response.LoginResponse
import com.example.officeproject.api.response.PatchUserResponse

class LoginViewModel : ViewModel() {
    var userRepo: UserRepository

    init {
        var api = RetrofitClient.getUserRepo()
        userRepo = UserRepository(api)
    }

     suspend fun checkLogin(loginRequest: LoginRequest): LoginResponse {
      return  userRepo.checkLogin(loginRequest)
    }

    suspend fun getDriverList(): DriverListResponse {
        return userRepo.getDriverList()
    }

    suspend fun patchDriver(request: PatchUserRequest): PatchUserResponse {
        return userRepo.patchDriver(request)
    }

}