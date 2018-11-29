package com.nikhil.feed.contract


import com.nikhil.feed.api.response.FeedRespose
import retrofit2.Response


interface HomeContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     */
    interface Presenter {

        fun onDestroy()

        fun onGetFeedData()

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the HomeModelIntractorImp class
     */
    interface HomeView {

        fun showProgress()

        fun hideProgress()

        fun onResponseSuccess(feedRespose: FeedRespose)

        fun onResponseFailure(error: String)

    }


    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     */
    interface DataIntractor {

        interface OnFinishedListener {

            fun onFailure(error: String)

            fun onFinished(response: FeedRespose)
        }

        fun getFeedData(onFinishedListener: OnFinishedListener)

        fun cancelReq()

    }


}
