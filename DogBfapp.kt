package app.ejemplo.dogbf

import android.app.Application
import com.google.android.gms.ads.MobileAds

class DogBfapp:Application() {
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
    }
}


