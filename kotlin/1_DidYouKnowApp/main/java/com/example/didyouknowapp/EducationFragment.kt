package com.example.didyouknowapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.didyouknowapp.adapters.ViewPagerEducationAdapter
import com.example.didyouknowapp.adapters.ViewPagerMoneyAdapter
import com.example.didyouknowapp.education.FirstEducation
import com.example.didyouknowapp.education.FourthEducation
import com.example.didyouknowapp.education.SecondEducation
import com.example.didyouknowapp.education.ThirdEducation
import com.example.didyouknowapp.money.FirstMoney
import com.example.didyouknowapp.money.SecondMoney
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator






class EducationFragment : Fragment(R.layout.fragment_money) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager2)
        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout2)

        val fragmentList = listOf(
            FirstEducation(),
            SecondEducation(),
            ThirdEducation(),
            FourthEducation(),

            )

        val adapter = ViewPagerEducationAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Page ${position + 1}"
        }.attach()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_education, container, false)
    }
}

