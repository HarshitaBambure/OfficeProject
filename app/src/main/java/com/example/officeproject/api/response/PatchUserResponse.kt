package com.example.officeproject.api.response


import com.google.gson.annotations.SerializedName

data class PatchUserResponse(
    @SerializedName("job")
    var job: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("updatedAt")
    var updatedAt: String
)