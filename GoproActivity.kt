package app.ejemplo.dogbf

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.billingclient.api.*
import com.example.dogbf.databinding.ActivityGoproBinding
import com.google.android.gms.ads.AdRequest


class GoproActivity : AppCompatActivity(){

    private lateinit var binding: ActivityGoproBinding
    private lateinit var billingClient: BillingClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoproBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLoadAds()

        billingClient = BillingClient.newBuilder(this)
            .setListener(purchasesUpdatedListener)
            .enablePendingPurchases().build()

        val skuList = ArrayList<String>()
        skuList.add("dons.dogs.03")
        binding.btnPremium.setOnClickListener {

            billingClient.startConnection(object : BillingClientStateListener {

                override fun onBillingSetupFinished(billingResult: BillingResult) {

                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {

                        val params = SkuDetailsParams.newBuilder()
                        params.setSkusList(skuList)
                            .setType(BillingClient.SkuType.INAPP)

                        billingClient.querySkuDetailsAsync(params.build()) { billingResult, skuDetailsList ->

                            for (skuDetails in skuDetailsList!!) {
                                val flowPurchase = BillingFlowParams.newBuilder()
                                    .setSkuDetails(skuDetails)
                                    .build()

                                val responseCode = billingClient.launchBillingFlow(
                                    this@GoproActivity,
                                    flowPurchase
                                ).responseCode
                            }
                        }
                    }
                }
                override fun onBillingServiceDisconnected() {}
            })
        }

        val skuList1 = ArrayList<String>()
        skuList1.add("dons.dogs.01")
        binding.btnDons01.setOnClickListener {

            billingClient.startConnection(object : BillingClientStateListener {

                override fun onBillingSetupFinished(billingResult: BillingResult) {

                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {

                        val params = SkuDetailsParams.newBuilder()
                        params.setSkusList(skuList1)
                            .setType(BillingClient.SkuType.INAPP)

                        billingClient.querySkuDetailsAsync(params.build()) { billingResult, skuDetailsList ->

                            for (skuDetails in skuDetailsList!!) {
                                val flowPurchase = BillingFlowParams.newBuilder()
                                    .setSkuDetails(skuDetails)
                                    .build()

                                val responseCode = billingClient.launchBillingFlow(
                                    this@GoproActivity,
                                    flowPurchase
                                ).responseCode
                            }
                        }
                    }
                }
                override fun onBillingServiceDisconnected() {}
            })

        }

        val skuList2 = ArrayList<String>()
        skuList2.add("dons.dogs.02")
        binding.btnDons02.setOnClickListener {

            billingClient.startConnection(object : BillingClientStateListener {

                override fun onBillingSetupFinished(billingResult: BillingResult) {

                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {

                        val params = SkuDetailsParams.newBuilder()
                        params.setSkusList(skuList2)
                            .setType(BillingClient.SkuType.INAPP)

                        billingClient.querySkuDetailsAsync(params.build()) { billingResult, skuDetailsList ->

                            for (skuDetails in skuDetailsList!!) {
                                val flowPurchase = BillingFlowParams.newBuilder()
                                    .setSkuDetails(skuDetails)
                                    .build()

                                val responseCode = billingClient.launchBillingFlow(
                                    this@GoproActivity,
                                    flowPurchase
                                ).responseCode
                            }
                        }
                    }
                }

                override fun onBillingServiceDisconnected() {}
            })
        }

        val skuList3 = ArrayList<String>()
        skuList3.add("dons.dogs.04")
        binding.btnDons03.setOnClickListener {

            billingClient.startConnection(object : BillingClientStateListener {

                override fun onBillingSetupFinished(billingResult: BillingResult) {

                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {

                        val params = SkuDetailsParams.newBuilder()
                        params.setSkusList(skuList3)
                            .setType(BillingClient.SkuType.INAPP)

                        billingClient.querySkuDetailsAsync(params.build()) { billingResult, skuDetailsList ->

                            for (skuDetails in skuDetailsList!!) {
                                val flowPurchase = BillingFlowParams.newBuilder()
                                    .setSkuDetails(skuDetails)
                                    .build()

                                val responseCode = billingClient.launchBillingFlow(
                                    this@GoproActivity,
                                    flowPurchase
                                ).responseCode
                            }
                        }
                    }
                }
                override fun onBillingServiceDisconnected() {}
            })
        }

    }

    private fun handlePurchase(purchase: Purchase) {
        if (purchase.purchaseState == Purchase.PurchaseState.PURCHASED) {
            if (!purchase.isAcknowledged) {
                val acknowledgePurchaseParams = AcknowledgePurchaseParams.newBuilder()
                    .setPurchaseToken(purchase.purchaseToken)

                billingClient.acknowledgePurchase(acknowledgePurchaseParams.build()) {
                    Toast.makeText(applicationContext, "Purchase completed", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private val purchasesUpdatedListener = PurchasesUpdatedListener { billingResult, purchases ->

        if (billingResult.responseCode == BillingClient.BillingResponseCode.OK && purchases != null) {
            for (purchase in purchases) {
                handlePurchase(purchase)
            }
        } else if (billingResult.responseCode == BillingClient.BillingResponseCode.USER_CANCELED) {

            Toast.makeText(applicationContext, "User canceled", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initLoadAds() {
        val adRequest = AdRequest.Builder().build()
        binding.banner2.loadAd(adRequest)
    }
}





