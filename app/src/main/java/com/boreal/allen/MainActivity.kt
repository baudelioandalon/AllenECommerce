package com.boreal.allen

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.boreal.allen.databinding.ActivityMainBinding
import com.boreal.commonutils.base.CUBaseActivity

class MainActivity : CUBaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        screenSplash.setKeepOnScreenCondition{false}
    }

    override fun getLayout() = R.layout.activity_main

    override fun initView() {
        binding.apply {
            configToolbarDefault()
        }
    }
}