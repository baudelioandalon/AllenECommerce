package com.boreal.allen

import com.boreal.allen.databinding.ActivityMainBinding
import com.boreal.commonutils.base.CUBaseActivity

class MainActivity : CUBaseActivity<ActivityMainBinding>() {

    override fun getLayout() = R.layout.activity_main

    override fun initView() {
        binding.apply {
            txtHello.text = "odkokd"
        }
    }
}