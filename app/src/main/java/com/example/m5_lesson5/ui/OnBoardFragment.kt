
package com.example.m5_lesson5.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.m5_lesson5.R
import com.example.m5_lesson5.databinding.FragmentOnBoardBinding
import com.example.m5_lesson5.utils.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

   @Inject lateinit var preferences: Preferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentOnBoardBinding.inflate(LayoutInflater.from(context), container, false)
        initViews()
        return binding.root
    }
    @SuppressLint("UseRequireInsteadOfGet", "CommitTransaction")
    private fun initViews() {
        arguments.let {
            val data = it?.getSerializable("object") as Model
            binding.tvTitleBoard.text = data.title
            binding.tvDescBoard.text = data.description
            data.img?.let { it1 -> binding.imageBoard.setImageResource(it1) }
            binding.btnStart.isVisible = data.isLast==true

            if (data.isLast==false){
                data.bg?.let { it1 -> binding.bgConst.setBackgroundResource(it1) }
            }else{
                data.bg?.let { it1 -> binding.bgConst.setBackgroundResource(it1) }
            }
        }

        binding.btnStart.setOnClickListener {

            val newFragment: Fragment = InputFragment()
            val transaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            val fragmentManager =
                fragmentManager
            fragmentManager!!.beginTransaction().replace(R.id.container, newFragment).commit()
            preferences.setBoardingShowed(true)
         //   Mobile.providePrefs(requireContext()).setBoardingShowed(true)
        }
    }
}
