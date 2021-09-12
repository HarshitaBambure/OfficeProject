package com.example.officeproject.api.apis

import com.example.officeproject.api.request.LoginRequest
import com.example.officeproject.api.request.PatchUserRequest
import com.example.officeproject.api.response.DriverListResponse
import com.example.officeproject.api.response.LoginResponse
import com.example.officeproject.api.response.PatchUserResponse
import retrofit2.Response
import retrofit2.http.*

interface UserApi {

    @POST("/login/") //example post
    suspend fun checkLogin(@Body request:LoginRequest):LoginResponse

    @GET("/api/driver/driver-api/") //example login
    suspend fun getDriverDetails():DriverListResponse

    @PATCH("/api/users/2") //example login
    suspend fun patchUserDetails(@Body body:PatchUserRequest):PatchUserResponse


/*
    @PATCH("/api/users/2") //example login
    suspend fun patchUserDetails(@Header("Authorization") auth:String, @Body body:PatchUserRequest):PatchUserResponse
*/

    /*
     @GET("/{api}/driver/driver-api/") //example login
  suspend fun getDDriverDetails(@Path("api") api:String):DriverListResponse
*/

}