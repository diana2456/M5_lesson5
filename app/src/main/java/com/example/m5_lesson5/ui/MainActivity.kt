package com.example.m5_lesson5.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.m5_lesson5.R
import com.example.m5_lesson5.databinding.ActivityMainBinding
import com.example.m5_lesson5.utils.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity  : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @Inject lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

     if (!preferences.isBoardingShowed()){
           supportFragmentManager.beginTransaction().add(R.id.container, BoardPageFragment()).commit()
        }else{
         supportFragmentManager.beginTransaction().add(R.id.container, InputFragment()).commit()
       }

        setContentView(binding.root)
    }
}
