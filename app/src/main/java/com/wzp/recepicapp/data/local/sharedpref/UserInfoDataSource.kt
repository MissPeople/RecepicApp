package com.wzp.recepicapp.data.local.sharedpref

import com.wzp.recepicapp.common.functional.Result

interface UserInfoDataSource {
    suspend fun getUserLoginStatus(): Boolean
}