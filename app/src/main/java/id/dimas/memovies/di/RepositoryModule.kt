package id.dimas.memovies.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.dimas.memovies.data.model.service.TMDBApiService
import id.dimas.memovies.data.repository.HomeRepository
import id.dimas.memovies.data.repositoryImpl.HomeRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideHomeRepository(apiService: TMDBApiService): HomeRepository {
        return HomeRepositoryImpl(apiService)
    }

}