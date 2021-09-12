package com.example.officeproject.api.response

data class LoginResponse(
    val non_field_errors: List<String>,
    val token: String
)