package com.github.smmousavi.network.retrofit.di

import com.github.smmousavi.common.Constants.OK_HTTP_FACTORY
import com.github.smmousavi.common.Constants.REST_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitModule {

    @Provides
    fun provideStarsWarRetrofit(
        @Named(OK_HTTP_FACTORY) okhttpCallFactory: dagger.Lazy<Call.Factory>,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(REST_BASE_URL)
        // We use callFactory lambda here with dagger.Lazy<Call.Factory>
        // to prevent initializing OkHttp on the main thread.
        .callFactory { okhttpCallFactory.get().newCall(it) }
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}