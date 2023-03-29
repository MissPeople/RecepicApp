package com.wzp.recepicapp.common.di

import com.wzp.recepicapp.data.local.sharedpref.UserInfoDataSource
import com.wzp.recepicapp.data.local.sharedpref.UserInfoDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UiModule {
    @Binds
    abstract fun provideUserInfoDataSource(userIndo: UserInfoDataSourceImpl): UserInfoDataSource
}