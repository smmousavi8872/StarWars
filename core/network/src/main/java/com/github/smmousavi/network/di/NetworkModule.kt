package com.github.smmousavi.network.di

import android.content.Context
import androidx.tracing.trace
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.util.DebugLogger
import com.github.smmousavi.common.Constants.OK_HTTP_CLIENT
import com.github.smmousavi.common.Constants.OK_HTTP_FACTORY
import com.github.smmousavi.network.SearchQueryParamInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideQueryParamInterceptor(): SearchQueryParamInterceptor =
        SearchQueryParamInterceptor()

    @Provides
    @Singleton
    @Named(OK_HTTP_FACTORY)
    fun provideOkHttpFactory(httpLoggingInterceptor: HttpLoggingInterceptor): Call.Factory =
        trace(OK_HTTP_FACTORY) {
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
        }

    @Provides
    @Singleton
    @Named(OK_HTTP_CLIENT)
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) =
        trace(OK_HTTP_CLIENT) {
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()
        }

    @Provides
    @Singleton
    fun provideImageLoader(
        // request dagger.Lazy here, so that it's not instantiated from Dagger.
        @Named(OK_HTTP_FACTORY) okHttpCallFactory: dagger.Lazy<Call.Factory>,
        @ApplicationContext application: Context,
    ): ImageLoader = trace("ImageLoader") {
        ImageLoader.Builder(application)
            .callFactory { okHttpCallFactory.get() }
            .components { add(SvgDecoder.Factory()) }
            .respectCacheHeaders(false)
            .apply { logger(DebugLogger()) }
            .build()
    }
}