package com.example.officeproject.api.response

data class DriverListResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)

data class Result(
    val id: Int,
    val last_seen_on: Any,
    val license_expiry: String,
    val license_image: Any,
    val license_number: String,
    val national_id_expiry: String,
    val national_id_image: Any,
    val nationality: String,
    val project: Int,
    val service_type: String,
    val shift_end: String,
    val shift_start: String,
    val status: String,
    val user: User,
    val vehicle_assigned: Int,
    val visa_expiry: Any,
    val visa_image: Any,
    val visa_number: Any
)

data class User(
    val contact_number: String,
    val email: String,
    val profile_image: Any,
    val username: String
)