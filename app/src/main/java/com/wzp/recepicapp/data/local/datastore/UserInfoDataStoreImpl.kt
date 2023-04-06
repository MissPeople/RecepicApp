package com.wzp.recepicapp.data.local.datastore

import android.content.Context
import com.wzp.recepicapp.domain.model.UserInfoModule
import javax.inject.Inject

class UserInfoDataStoreImpl @Inject constructor(
    private val context: Context
): UserInfoDataStore {

    override suspend fun saveUserInfo(info: UserInfoModule) {

    }
}