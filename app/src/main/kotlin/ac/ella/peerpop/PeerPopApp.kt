package ac.ella.peerpop

import android.app.Application
import android.content.Context
import android.content.Intent

class PeerPopApp : Application() {
    override fun onCreate() {
        super.onCreate()
        peerPopApp = this
    }

    companion object {
        private lateinit var peerPopApp: PeerPopApp

        fun getApp(): PeerPopApp = peerPopApp

        fun getAppContext(): Context = peerPopApp.applicationContext

        fun forceRestart() {
            val intent = Intent(peerPopApp, MainActivity::class.java)
            val mainIntent = Intent.makeRestartActivityTask(intent.component)
            peerPopApp.startActivity(mainIntent)
            Runtime.getRuntime().exit(0)
        }
    }
}
