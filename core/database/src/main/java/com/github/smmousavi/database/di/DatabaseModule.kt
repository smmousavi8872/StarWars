package com.github.smmousavi.database.di

import android.content.Context
import androidx.room.Room
import com.github.smmousavi.database.StarsWarDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {
    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context,
    ): StarsWarDatabase = Room.databaseBuilder(
        context,
        StarsWarDatabase::class.java,
        "starswar-database",
    )
        .fallbackToDestructiveMigration()
        .build()
}