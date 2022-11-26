package com.boreal.allen.ui.seller.businessinformation.container

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import com.boreal.allen.ui.general.logingraph.welcome.*
import com.boreal.allen.ui.seller.businessinformation.contact.ViewBussinessInformationContactCompose
import com.boreal.allen.ui.seller.businessinformation.main.ViewBussinessInformationMainCompose
import com.boreal.allen.ui.seller.businessinformation.shippingandpayments.ViewBussinessInformationShippingAndPaymentsCompose
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun ViewBussinessInformationContainerCompose(
    navController: NavHostController? = null,
    closeApp: () -> Unit = {}
) {
    val innerBussinessNavController = rememberNavController()
    val systemUiController = rememberSystemUiController()
    if (isSystemInDarkTheme()) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = White
        )
    }
    val scaffoldState =
        rememberScaffoldState(drawerState = DrawerState(initialValue = DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Scaffold(modifier = Modifier
            .fillMaxWidth(),
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
            drawerShape = MaterialTheme.shapes.small,
            scaffoldState = scaffoldState,
            drawerContent = {
                BussinessInformationDrawer {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                    when (it.option) {
                        DrawerOptions.Main -> {
                            innerBussinessNavController.navigate(BusinessInformationScreen.MainScreen.route)
                        }
                        DrawerOptions.Contact -> {
                            innerBussinessNavController.navigate(BusinessInformationScreen.ContactInformationScreen.route)
                        }
                        DrawerOptions.ShippingAndPayments -> {
                            innerBussinessNavController.navigate(BusinessInformationScreen.MainScreen.route)
                        }
                        DrawerOptions.Promotion -> {
                            innerBussinessNavController.navigate(BusinessInformationScreen.MainScreen.route)
                        }
                        DrawerOptions.Save -> {
                            //Save data
                        }
                        else -> {
                            //Exit
                            navController?.navigateUp()
                        }
                    }
                }
            },
            content = {

                NavHost(
                    navController = innerBussinessNavController,
                    startDestination = BusinessInformationScreen.ShippingAndPaymentsScreen.route
                ) {
                    composable(route = BusinessInformationScreen.MainScreen.route) {
                        ViewBussinessInformationMainCompose(
                            navController = innerBussinessNavController
                        ) {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    }
                    composable(route = BusinessInformationScreen.ContactInformationScreen.route) {
                        ViewBussinessInformationContactCompose(
                            navController = innerBussinessNavController
                        ) {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    }
                    composable(route = BusinessInformationScreen.ShippingAndPaymentsScreen.route) {
                        ViewBussinessInformationShippingAndPaymentsCompose(
                            navController = innerBussinessNavController
                        ) {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    }
                }
                it.calculateBottomPadding()
            })

    }
}
