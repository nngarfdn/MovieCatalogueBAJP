package com.nanangarifudin.moviecatalogue.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nanangarifudin.moviecatalogue.R
import com.nanangarifudin.moviecatalogue.databinding.ActivityFavoriteBinding
import com.nanangarifudin.moviecatalogue.ui.home.SectionPagerAdapter
import kotlinx.android.synthetic.main.activity_home.*

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = FavoritePagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(binding.viewPager)
        supportActionBar?.elevation = 0f

    }
}