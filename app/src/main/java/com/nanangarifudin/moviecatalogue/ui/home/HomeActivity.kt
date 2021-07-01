package com.nanangarifudin.moviecatalogue.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.nanangarifudin.moviecatalogue.R
import com.nanangarifudin.moviecatalogue.databinding.ActivityHomeBinding
import com.nanangarifudin.moviecatalogue.ui.favorite.FavoriteActivity

import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(binding.viewPager)
        supportActionBar?.elevation = 0f

        setSupportActionBar(binding.toolbar)
        if (supportActionBar != null) supportActionBar?.setDisplayHomeAsUpEnabled(false)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_fav, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        if (id == R.id.editprofile) {

            val ii = Intent(this,  FavoriteActivity::class.java)
            startActivity(ii)
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}