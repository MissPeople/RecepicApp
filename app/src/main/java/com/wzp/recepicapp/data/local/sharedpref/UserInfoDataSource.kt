package com.wzp.recepicapp.data.local.sharedpref

import com.wzp.recepicapp.common.functional.Result
import com.wzp.recepicapp.domain.model.UserInfoModule

interface UserInfoDataSource {
    fun getUserLoginStatus(): Boolean
    suspend fun getUserInfo(): UserInfoModule
    suspend fun saveUserInfo(info: UserInfoModule)
}