package net.yuzumone.nowsearch

import android.os.Bundle
import android.support.v4.app.ListFragment
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter
import com.twitter.sdk.android.tweetui.SearchTimeline

class SearchFragment : ListFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val timeline = SearchTimeline.Builder()
                .query("#TDR_now")
                .build()
        val adapter = TweetTimelineListAdapter.Builder(activity)
                .setTimeline(timeline)
                .build()
        listAdapter = adapter
    }
}