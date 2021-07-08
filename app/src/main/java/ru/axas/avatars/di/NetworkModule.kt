package ru.axas.avatars.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.axas.avatars.data.network_services.ServiceFactory
import ru.axas.avatars.data.network_services.TokenService
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideTokenService(): TokenService {
        return ServiceFactory.getService<TokenService>(true)
    }
}