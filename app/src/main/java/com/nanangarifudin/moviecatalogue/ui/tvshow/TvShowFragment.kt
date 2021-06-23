package com.nanangarifudin.moviecatalogue.ui.tvshow

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nanangarifudin.moviecatalogue.R
import com.nanangarifudin.moviecatalogue.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tv_show.*


class TvShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (activity != null){

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TVShowViewModel::class.java]
//            val tvAdapter = TvShowAdapter()
            progress_bar.visibility = View.VISIBLE


//            viewModel.getTvShow().observe(viewLifecycleOwner, { tvShow ->
//                progress_bar.visibility = View.INVISIBLE
//
//                Log.d("load tv", "onActivityCreated: $tvShow")
//                tvAdapter.setData(tvShow)
//
//                with(rv_tvshow) {
//                    layoutManager = LinearLayoutManager(context)
//                    setHasFixedSize(true)
//                    adapter = tvAdapter
//                }
//            })

        }
    }


}