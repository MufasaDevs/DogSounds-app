package app.ejemplo.dogbf

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogbf.R
import com.example.dogbf.databinding.ActivityTrainBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class TrainActivity : AppCompatActivity() {

    private lateinit var binding3: ActivityTrainBinding

    private var inter: InterstitialAd? = null

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding3 = ActivityTrainBinding.inflate(layoutInflater)
        setContentView(binding3.root)
        initLoadAds()
        initAds()
        initListeners()

        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.whistle2)
        val mp2: MediaPlayer = MediaPlayer.create(this, R.raw.clicker2)

        binding3.btnWhistle2.setOnClickListener{
            count += 1
            checkCounter()
            mp.start()
        }
        binding3.btnClicker2.setOnClickListener{
            count += 1
            checkCounter()
            mp2.start()
        }
    }

    private fun initListeners() {
        inter?.fullScreenContentCallback = object: FullScreenContentCallback() {
            override fun onAdDismissedFullScreenContent() {
            }
            override fun onAdFailedToShowFullScreenContent(adError: AdError) {
            }
            override fun onAdShowedFullScreenContent() {
                inter = null
            }
        }
    }

    private fun initAds() {
        val adRequest1 = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-XXXXXXXXXXXX/XXXXXXXXXXX", adRequest1, object : InterstitialAdLoadCallback() {
            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                inter = interstitialAd
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                inter = null
            }
        })
    }

    private fun checkCounter() {
        if(count == 6){
            showAds()
            count = 0
            initAds()
        }
    }

    private fun showAds() {
        inter?.show(this)
    }

    private fun initLoadAds() {
        val adRequest = AdRequest.Builder().build()
        binding3.banner3.loadAd(adRequest)
    }
}
