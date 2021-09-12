package com.example.officeproject.api.request


import com.google.gson.annotations.SerializedName

data class PatchUserRequest(
    @SerializedName("job")
    var job: String,
    @SerializedName("name")
    var name: String
)