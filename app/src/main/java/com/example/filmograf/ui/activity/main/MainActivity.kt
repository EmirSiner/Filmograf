package com.example.filmograf.ui.activity.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.filmograf.R
import com.example.filmograf.network.MovieGet
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    lateinit var vPager:ViewPager2
    lateinit var category:TabLayout

    val movieViewModel: MovieGet by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vPager=findViewById(R.id.viewPager)
        category=findViewById(R.id.tlMovieCategory)
        createViewPager()
        vPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(category,vPager){ tab, index ->

        }.attach()
        createTab()
    }

    private fun createTab() {

    }

    fun createViewPager(){

    }

    internal class ViewPagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity){

        private val fragmentList = mutableListOf<Fragment>()

        override fun getItemCount(): Int = fragmentList.size

        override fun createFragment(position: Int): Fragment {
           return  fragmentList[position]
        }

        fun addNewFragment() {

        }
    }
}