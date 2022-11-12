package app.ejemplo.dogbf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import com.example.dogbf.R
import com.example.dogbf.databinding.ActivitySoundsBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class SoundsActivity : AppCompatActivity() {

    private lateinit var binding1: ActivitySoundsBinding

    private var inter: InterstitialAd? = null

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding1 = ActivitySoundsBinding.inflate(layoutInflater)
        setContentView(binding1.root)
        initLoadAds()
        initAds()
        initListeners()


        val mp: MediaPlayer = MediaPlayer.create(this, R.raw.whistle2)
        val mp1: MediaPlayer = MediaPlayer.create(this, R.raw.perrouno)
        val mp2: MediaPlayer = MediaPlayer.create(this, R.raw.clicker)
        val mp3: MediaPlayer = MediaPlayer.create(this, R.raw.perrodos)
        val mp4: MediaPlayer = MediaPlayer.create(this, R.raw.catuno)
        val mp5: MediaPlayer = MediaPlayer.create(this, R.raw.catdos)
        val mp6: MediaPlayer = MediaPlayer.create(this, R.raw.birduno)
        val mp7: MediaPlayer = MediaPlayer.create(this, R.raw.birddos)
        val mp8: MediaPlayer = MediaPlayer.create(this, R.raw.cristal)
        val mp9: MediaPlayer = MediaPlayer.create(this, R.raw.fireworks2)
        val mp10: MediaPlayer = MediaPlayer.create(this, R.raw.highpitch)
        val mp11: MediaPlayer = MediaPlayer.create(this, R.raw.doorbell)



        binding1.btnWhistle.setOnClickListener{
            count += 1
            checkCounter()
            mp.start()
        }
        binding1.btnDog1.setOnClickListener{
            count += 1
            checkCounter()
            mp1.start()
        }
        binding1.btnClicker.setOnClickListener{
            count += 1
            checkCounter()
            mp2.start()
        }
        binding1.btnDog2.setOnClickListener{
            count += 1
            checkCounter()
            mp3.start()
        }
        binding1.btnCat.setOnClickListener{
            count += 1
            checkCounter()
            mp4.start()
        }
        binding1.btnCat2.setOnClickListener{
            count += 1
            checkCounter()
            mp5.start()
        }
        binding1.btnBird.setOnClickListener{
            count += 1
            checkCounter()
            mp6.start()
        }
        binding1.btnBird2.setOnClickListener{
            count += 1
            checkCounter()
            mp7.start()
        }
        binding1.btnCristal.setOnClickListener{
            count += 1
            checkCounter()
            mp8.start()
        }
        binding1.btnFirew.setOnClickListener{
            count += 1
            checkCounter()
            mp9.start()
        }
        binding1.btnHigh.setOnClickListener{
            count += 1
            checkCounter()
            mp10.start()
        }
        binding1.btnDoorbell.setOnClickListener{
            count += 1
            checkCounter()
            mp11.start()
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

        InterstitialAd.load(this,"ca-app-pub-4967910143423086/6445870103", adRequest1, object : InterstitialAdLoadCallback() {
            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                inter = interstitialAd
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                inter = null
            }
        })
    }
    private fun checkCounter() {
        if(count == 10){
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
        binding1.banner2.loadAd(adRequest)
    }
}