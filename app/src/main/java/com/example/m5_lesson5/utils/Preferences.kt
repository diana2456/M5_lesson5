package com.example.m5_lesson5.utils


import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class Preferences @Inject constructor(@ApplicationContext context: Context) {
    private val sharedPref: SharedPreferences = context.getSharedPreferences("presences",
        Context.MODE_PRIVATE
    )

    fun isBoardingShowed():Boolean{
        return sharedPref.getBoolean("board",false)
    }

    fun setBoardingShowed(isSnow:Boolean){
        sharedPref.edit().putBoolean("board",isSnow).apply()
    }

    fun isTextShowed():String{
        return sharedPref.getString("text","").toString()
    }

    fun setTextShowed(isSnow:String){
        sharedPref.edit().putString("text",isSnow).apply()
    }
}