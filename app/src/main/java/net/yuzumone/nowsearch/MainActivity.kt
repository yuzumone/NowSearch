package net.yuzumone.nowsearch

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig

class MainActivity : AppCompatActivity() {

    private val setting by lazy { Setting(this) }

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        menu.findItem(R.id.menu_dark).isChecked = setting.darkMode
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.menu_dark) {
            item.isChecked = !item.isChecked
            setting.darkMode = item.isChecked
            val intent = intent
            finish()
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
