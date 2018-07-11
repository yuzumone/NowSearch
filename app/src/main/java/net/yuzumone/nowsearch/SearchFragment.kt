package net.yuzumone.nowsearch

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.ListFragment
import android.support.v4.content.ContextCompat
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter
import com.twitter.sdk.android.tweetui.SearchTimeline

class SearchFragment : ListFragment() {

    private val setting by lazy { Setting(activity) }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var style = R.style.tw__TweetLightStyle
        if (setting.darkMode) {
            style = R.style.tw__TweetDarkStyle
            listView.divider = ColorDrawable(ContextCompat.getColor(activity, R.color.darkDivider))
        }
        val timeline = SearchTimeline.Builder()
                .query(getQuery())
                .build()
        val adapter = TweetTimelineListAdapter.Builder(activity)
                .setTimeline(timeline)
                .setViewStyle(style)
                .build()
        listAdapter = adapter
    }

    private fun getQuery(): String {
        val mute = ArrayList<String>()
        mute.add("twittbot.net")
        mute.add("IFTTT")
        mute.add("tdr_dash")
        mute.add("myThings_App")
        mute.add("ＯｄａＹｕｋｉｏのツール")
        return "#tdr_now OR #tdr_md OR #tdr_food" +
                mute.joinToString(separator = "") { " -source:$it" }
    }
}