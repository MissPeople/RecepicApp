package com.wzp.recepicapp.data.repositories

import com.wzp.recepicapp.domain.model.UserInfoModule

interface UserInfoRepository {
    suspend fun getUserInfo() : UserInfoModule
    suspend fun saveUserInfo(user:UserInfoModule)
}