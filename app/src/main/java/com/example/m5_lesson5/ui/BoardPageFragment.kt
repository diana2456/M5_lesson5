package com.example.m5_lesson5.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.m5_lesson5.databinding.FragmentBoardPageBinding




@Suppress("UNREACHABLE_CODE")
class BoardPageFragment  : Fragment() {

    private lateinit var binding: FragmentBoardPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentBoardPageBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = BoardAdapter(requireActivity())
        adapter.also { it.also { binding.vpBoard.adapter = it } }
        binding.dotsIndicator.attachTo(binding.vpBoard)
    }
}