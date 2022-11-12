package app.ejemplo.dogbf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dogbf.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLoadAds()

        binding.btnSounds.setOnClickListener{
            val intent: Intent = Intent(this, SoundsActivity::class.java)
            startActivity(intent)
        }
        binding.btnTrain.setOnClickListener {
            val intent2: Intent = Intent(this, TrainActivity::class.java)
            startActivity(intent2)
        }
        binding.btnGopro.setOnClickListener {
            val intent3: Intent = Intent(this, GoproActivity::class.java)
            startActivity(intent3)
        }
        binding.btnDonations.setOnClickListener {
            val intent4: Intent = Intent(this, InfoActivity::class.java)
            startActivity(intent4)
        }
    }
    private fun initLoadAds() {
        val adRequest = AdRequest.Builder().build()
        binding.banner1.loadAd(adRequest)
    }

}