package app.ejemplo.dogbf

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.android.billingclient.api.*
import com.android.billingclient.api.BillingClient.SkuType.INAPP
import com.example.dogbf.databinding.ActivityInfoBinding
import com.google.android.gms.ads.AdRequest
import java.io.IOException

class InfoActivity : AppCompatActivity() {

    private lateinit var binding4: ActivityInfoBinding

    private var billingClient: BillingClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding4 = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding4.root)
        initLoadAds()
    }

    private fun initLoadAds() {
        val adRequest = AdRequest.Builder().build()
        binding4.banner4.loadAd(adRequest)
    }
}
