package com.example.m5_lesson5.ui

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.m5_lesson5.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class BoardAdapter @Inject constructor(@ApplicationContext fragment: FragmentActivity):FragmentStateAdapter(fragment) {

    private val listBoarding = arrayOf(
        Model(R.drawable.bro,
            "What is AGT Rota?",
            "AGT Rota is an application developed for you to see your queue number.",
            false,
            R.color.red
        ),
      Model(
            R.drawable.www,
            "Get Sequence Number",
            "In order to receive a vehicle evacuation order, you must be within 40 km of the AGT factory site.",
          false,
          R.color.green
        ),
        Model(
            R.drawable.rafiki,
            "Track Your Queue Number Edin",
            "If you do not log in when it is your turn, your queue will be moved back 20 places. If you do not come to your new queue, your queue will be canceled.",
            false,
            R.color.yellow
        ),
        Model(
            R.drawable.uuu,
            "Wait to get a new queue number",
            "You can queue 3 hours after you exit the weighbridge.",
            true,
            R.color.pink
        )
    )

    override fun getItemCount(): Int = listBoarding.size


    override fun createFragment(position: Int): Fragment {
        val data = bundleOf("object" to listBoarding[position])
        val fragment = OnBoardFragment()
        fragment.arguments = data
        return fragment
    }
}