package com.example.architecture

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): BoredApiService {
        return Retrofit.Builder()
            .baseUrl("https://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BoredApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(context: Context): ActivityDatabase {
        return Room.databaseBuilder(context, ActivityDatabase::class.java, "activities.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideActivityDao(db: ActivityDatabase) = db.activityDao()

    @Provides
    @Singleton
    fun provideUsefulActivitiesRepository(
        apiService: BoredApiService,
        activityDao: ActivityDao
    ): UsefulActivitiesRepository {
        return UsefulActivitiesRepositoryImpl(apiService, activityDao)
    }
}