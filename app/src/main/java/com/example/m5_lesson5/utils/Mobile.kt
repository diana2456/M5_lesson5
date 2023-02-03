package com.example.m5_lesson5.utils

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Mobile {


    @Provides
 fun providePrefs(@ApplicationContext context: Context):Preferences{
       return Preferences(context)
  }


}