package ac.ella.peerpop

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log

class PeerPopApp : Application() {
    override fun onCreate() {
        super.onCreate()
        PeerPopApp = this
        Log.d("YTApp", "YTApp onCreate")
    }

    companion object {
        private lateinit var PeerPopApp: PeerPopApp

        fun getApp(): PeerPopApp = PeerPopApp

        fun getAppContext(): Context = PeerPopApp.applicationContext

        fun forceRestart() {
            val intent = Intent(PeerPopApp, MainActivity::class.java)
            val mainIntent = Intent.makeRestartActivityTask(intent.component)
            PeerPopApp.startActivity(mainIntent)
            Runtime.getRuntime().exit(0)
        }
    }
}
