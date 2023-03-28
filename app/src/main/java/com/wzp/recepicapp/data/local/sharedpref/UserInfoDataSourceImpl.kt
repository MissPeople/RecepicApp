package com.wzp.recepicapp.data.local.sharedpref

import android.app.Application
import android.content.Context
import com.wzp.recepicapp.common.functional.Result
import com.wzp.recepicapp.common.Constants.MAIN_PREFERENCES
import javax.inject.Inject

private const val SP_KEY_USER_INFO = "userInfo"

class UserInfoDataSourceImpl @Inject constructor(
    private val context: Application
) : UserInfoDataSource {

    data class NoUserInfoFailure(val errorMessage: String = "") :
        Result.Exception.Failure

    override suspend fun getUserLoginStatus(): Boolean {
        val sharedPref = context.getSharedPreferences(MAIN_PREFERENCES, Context.MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean(SP_KEY_USER_INFO, false)
        return isLogin
    }
}