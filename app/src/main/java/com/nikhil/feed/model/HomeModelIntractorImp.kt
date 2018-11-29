package com.nikhil.feed.model

import com.nikhil.feed.api.ApiClient
import com.nikhil.feed.api.ApiInterface
import com.nikhil.feed.api.response.FeedRespose
import com.nikhil.feed.contract.HomeContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeModelIntractorImp : HomeContract.DataIntractor {

    private var call: Call<FeedRespose>? = null

    override fun getFeedData(onFinishedListener: HomeContract.DataIntractor.OnFinishedListener) {

        val apiService = ApiClient.client?.create(ApiInterface::class.java)
        call= apiService?.getFeeds()
        call?.enqueue(object : Callback<FeedRespose> {
            override fun onResponse(call: Call<FeedRespose>, response: Response<FeedRespose>) {
                if (response !=null && response.body()!=null) {
                    onFinishedListener.onFinished(response.body()!!)
                }else{
                    onFinishedListener.onFailure("Null response error")
                }
            }

            override fun onFailure(call: Call<FeedRespose>, t: Throwable) {
                t.printStackTrace()
                onFinishedListener.onFailure("Error :${t.localizedMessage}")

            }
        })
    }

    override fun cancelReq() {
        call?.cancel()
    }
}
