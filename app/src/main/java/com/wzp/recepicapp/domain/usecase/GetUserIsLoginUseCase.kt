package com.wzp.recepicapp.domain.usecase

import com.wzp.recepicapp.common.functional.Result
import com.wzp.recepicapp.data.local.sharedpref.UserInfoDataSource
import javax.inject.Inject

class GetUserIsLoginUseCase @Inject constructor(
    private val userInfoDataSource: UserInfoDataSource
) {
    suspend operator fun invoke(): Boolean {
        return userInfoDataSource.getUserLoginStatus()
    }
}