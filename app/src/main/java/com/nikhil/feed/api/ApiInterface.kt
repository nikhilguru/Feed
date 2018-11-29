package com.nikhil.feed.api


import com.nikhil.feed.api.response.FeedRespose
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    /**
     * @return
     */
    @GET("facts.json")
    fun getFeeds(): Call<FeedRespose>

}