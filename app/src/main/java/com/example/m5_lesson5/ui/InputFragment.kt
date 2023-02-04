package com.example.m5_lesson5.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.m5_lesson5.databinding.FragmentInputBinding
import com.example.m5_lesson5.utils.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class InputFragment : Fragment() {

    @Inject lateinit var preferences: Preferences

    private lateinit var binding: FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentInputBinding.inflate(LayoutInflater.from(context), container, false)

        wel()
        binding.tv.text = preferences.isTextShowed()
        return binding.root
    }
    fun wel(){
        preferences.setTextShowed(binding.tv.text.toString())
    }
}