package com.wzp.recepicapp.common.di

import com.wzp.recepicapp.data.local.datastore.UserInfoDataStore
import com.wzp.recepicapp.data.local.datastore.UserInfoDataStoreImpl
import com.wzp.recepicapp.data.local.sharedpref.UserInfoDataSource
import com.wzp.recepicapp.data.local.sharedpref.UserInfoDataSourceImpl
import com.wzp.recepicapp.data.repositories.UserInfoRepository
import com.wzp.recepicapp.data.repositories.UserInfoRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UiModule {
    @Binds
    abstract fun provideUserInfoDataSource(userIndo: UserInfoDataSourceImpl): UserInfoDataSource

    @Binds
    abstract fun provideUserInfoDataStore(userInfoDataStore: UserInfoDataStoreImpl): UserInfoDataStore

    @Binds
    abstract fun provideUserInfoRepository(userInfoRepositoryImpl: UserInfoRepositoryImpl): UserInfoRepository
}