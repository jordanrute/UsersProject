package com.jr.usersretrofit.data.remote.dto

import com.jr.usersretrofit.data.remote.dto.userInfo.Address
import com.jr.usersretrofit.data.remote.dto.userInfo.Company

data class UserDto(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)