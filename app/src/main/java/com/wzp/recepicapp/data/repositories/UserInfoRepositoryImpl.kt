package com.wzp.recepicapp.data.repositories

import com.wzp.recepicapp.data.local.sharedpref.UserInfoDataSource
import com.wzp.recepicapp.domain.model.UserInfoModule
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val userInfoDataSource: UserInfoDataSource
) : UserInfoRepository {
    override suspend fun getUserInfo(): UserInfoModule {
        return userInfoDataSource.getUserInfo()
    }

    override suspend fun saveUserInfo(user: UserInfoModule) {
        userInfoDataSource.saveUserInfo(user)
    }

}