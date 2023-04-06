package com.wzp.recepicapp.data.local.sharedpref

import android.app.Application
import android.content.Context
import com.wzp.recepicapp.common.functional.Result
import com.wzp.recepicapp.common.Constants.MAIN_PREFERENCES
import com.wzp.recepicapp.domain.model.UserInfoModule
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

private const val SP_KEY_USER_INFO = "userInfo"

class UserInfoDataSourceImpl @Inject constructor(
    @ApplicationContext val context: Context
) : UserInfoDataSource {

    private val sharedPref = context.getSharedPreferences(MAIN_PREFERENCES, Context.MODE_PRIVATE)
    data class NoUserInfoFailure(val errorMessage: String = "") :
        Result.Exception.Failure

    override fun getUserLoginStatus(): Boolean {
        val isLogin = sharedPref.getBoolean(SP_KEY_USER_INFO, false)
        return isLogin
    }

    override suspend fun getUserInfo(): UserInfoModule {
        TODO("Not yet implemented")
    }

    override suspend fun saveUserInfo(info: UserInfoModule) {
        val edit = sharedPref.edit()
        edit.putString("userName", info.name)
        edit.putString("userPassword", info.password)
        edit.apply()
    }
}