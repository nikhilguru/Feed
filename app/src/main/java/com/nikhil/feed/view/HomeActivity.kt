package com.nikhil.feed.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.nikhil.feed.R
import com.nikhil.feed.adapter.FeedAdapter
import com.nikhil.feed.api.response.FeedRespose
import com.nikhil.feed.contract.HomeContract
import com.nikhil.feed.model.HomeModelIntractorImp
import com.nikhil.feed.presenter.HomePresenterImp
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeContract.HomeView {

    private lateinit var homePresenterImp: HomePresenterImp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        homePresenterImp = HomePresenterImp(this, this, HomeModelIntractorImp())
        swipeLy.setOnRefreshListener {
            homePresenterImp.onGetFeedData()
        }

        showProgress()
        homePresenterImp.onGetFeedData()

    }

    override fun showProgress() {
        swipeLy.isRefreshing = true

    }

    override fun hideProgress() {
        swipeLy.isRefreshing = false
    }

    override fun onResponseSuccess(feedRespose: FeedRespose) {
        setAdapter(feedRespose)
    }


    override fun onResponseFailure(error: String) {
        Toast.makeText(applicationContext, error, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        homePresenterImp.onDestroy()
    }

    private fun setAdapter(feedRespose: FeedRespose?) {


        val linearLayoutManager = LinearLayoutManager(this)
        rvFeed.layoutManager = linearLayoutManager
        rvFeed.adapter = feedRespose?.rows?.let { FeedAdapter(this, it) }

    }

}
