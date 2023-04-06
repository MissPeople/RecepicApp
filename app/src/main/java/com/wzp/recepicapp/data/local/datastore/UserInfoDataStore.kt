package com.wzp.recepicapp.data.local.datastore

import com.wzp.recepicapp.domain.model.UserInfoModule

interface UserInfoDataStore {
    suspend fun saveUserInfo(info:UserInfoModule)
}