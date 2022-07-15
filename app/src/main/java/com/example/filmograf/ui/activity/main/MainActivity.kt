package com.example.filmograf.ui.activity.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.filmograf.R
import com.example.filmograf.viewmodel.RMMovie
import com.example.filmograf.model.request.RmItemAdapter
import com.example.filmograf.model.request.RmItemListener
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() ,RmItemListener{
    lateinit var vPager: ViewPager2
    lateinit var category: TabLayout

    private val movieViewModel: RMMovie by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vPager = findViewById(R.id.viewPager)
        category = findViewById(R.id.tlMovieCategory)
        createViewPager()
        vPager.adapter =RmItemAdapter(this)
        TabLayoutMediator(category, vPager) { tab, index ->
            vPager.currentItem=index
        }.attach()
        createTab()
    }

    private fun createTab() {

    }

    fun createViewPager() {
        movieViewModel.movieLiveData.observe(this) { movieResultList ->
            (vPager.adapter as RmItemAdapter).submitList(movieResultList)

        }
    }



 override fun onItemClicked(itemId: Int) {
     val detailIntent = Intent(this,DetailScreenActivity::class.java)
     detailIntent.putExtra("movie_id",itemId)
     startActivity(detailIntent)




 }
}


/* internal class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
     FragmentStateAdapter(fragmentActivity) {

     private val fragmentList = mutableListOf<Fragment>()

     override fun getItemCount(): Int = fragmentList.size

     override fun createFragment(position: Int): Fragment {
         return fragmentList[position]
     }

     fun addNewFragment() {

     }
}   */