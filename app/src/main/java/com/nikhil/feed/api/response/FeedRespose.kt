package com.nikhil.feed.api.response

import com.nikhil.feed.entity.Row
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class FeedRespose {

    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("rows")
    @Expose
    var rows: List<Row>? = null

}
