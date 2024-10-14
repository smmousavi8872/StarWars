package com.github.smmousavi.datasource.characters.di

import com.github.smmousavi.datasource.film.local.DefaultFilmLocalDataSource
import com.github.smmousavi.datasource.film.local.FilmLocalDataSource
import com.github.smmousavi.datasource.film.remote.DefaultFilmRemoteDataSource
import com.github.smmousavi.datasource.film.remote.FilmRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class FilmsDataSourceModule {

    @Binds
    abstract fun bindsLocalDataSource(localDataSource: DefaultFilmLocalDataSource): FilmLocalDataSource

    @Binds
    abstract fun bindsRemoteDataSource(remoteDataSource: DefaultFilmRemoteDataSource): FilmRemoteDataSource
}