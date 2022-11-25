package com.boreal.allen.ui.seller.businessinformation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boreal.allen.domain.BusinessInformationScreen
import com.boreal.allen.domain.NOTIFICATION_CLIENT_GRAPH
import com.boreal.allen.domain.SALES_SELLER_GRAPH
import com.boreal.allen.domain.SellerScreen
import com.boreal.allen.ui.general.logingraph.welcome.*
import com.boreal.allen.ui.seller.home.ViewHomeSellerCompose
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun ViewBussinessInformationMainCompose(
    navController: NavHostController? = null,
    closeApp: () -> Unit = {}
) {

}
