package com.boreal.allen.ui.start

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.boreal.allen.theme.AllenEcommerceTheme
import com.boreal.allen.ui.welcome.AEWelcomeCompose

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContent {
            AllenEcommerceTheme {
                MainCompose()
            }
        }
    }
}