package net.yuzumone.nowsearch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val key = BuildConfig.TWITTER_API_KEY
        val secret = BuildConfig.TWITTER_API_SECRET
        val config = TwitterConfig.Builder(this)
                .twitterAuthConfig(TwitterAuthConfig(key, secret))
                .build()
        Twitter.initialize(config)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(android.R.id.content, SearchFragment()).commit()
        }
    }
}
