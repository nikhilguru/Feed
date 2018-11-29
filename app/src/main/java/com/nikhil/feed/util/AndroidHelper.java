package com.nikhil.feed.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class AndroidHelper {

    /**
     * Function to check network is available or not
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() /*&& internetConnectionAvailable(1000)*/;
    }


}
