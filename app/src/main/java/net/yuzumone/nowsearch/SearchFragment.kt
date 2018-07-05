package net.yuzumone.nowsearch

import android.os.Bundle
import android.support.v4.app.ListFragment
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter
import com.twitter.sdk.android.tweetui.SearchTimeline

class SearchFragment : ListFragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val timeline = SearchTimeline.Builder()
                .query(getQuery())
                .build()
        val adapter = TweetTimelineListAdapter.Builder(activity)
                .setTimeline(timeline)
                .build()
        listAdapter = adapter
    }

    private fun getQuery(): String {
        val mute = ArrayList<String>()
        mute.add("twittbot.net")
        mute.add("IFTTT")
        mute.add("tdr_dash")
        return "#tdr_now OR #tdr_md OR #tdr_food" +
                mute.joinToString(separator = "") { " -source:$it" }
    }
}