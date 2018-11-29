package com.nikhil.feed.presenter

import android.content.Context
import android.widget.Toast
import com.nikhil.feed.api.response.FeedRespose
import com.nikhil.feed.contract.HomeContract
import com.nikhil.feed.util.AndroidHelper
import retrofit2.Response

class HomePresenterImp(var context: Context?, var homeView : HomeContract.HomeView? ,var dataIntractor: HomeContract.DataIntractor ) : HomeContract.Presenter, HomeContract.DataIntractor.OnFinishedListener {


    override fun onDestroy() {
        homeView = null
        dataIntractor.cancelReq()
    }

    override fun onGetFeedData() {

        if(homeView!=null && context!=null) {
            if(AndroidHelper.isNetworkAvailable(context)) {
                homeView?.showProgress()
                dataIntractor.getFeedData(this)
            }else{
                Toast.makeText(context, "Connect to Internet", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onFinished(response: FeedRespose) {
        homeView?.hideProgress()
        homeView?.onResponseSuccess(response)
    }

    override fun onFailure(error: String) {
        homeView?.hideProgress()
        homeView?.onResponseFailure(error)
    }
}
