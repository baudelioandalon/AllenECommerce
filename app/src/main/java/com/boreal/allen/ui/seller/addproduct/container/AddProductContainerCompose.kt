package com.boreal.allen.ui.seller.addproduct.container

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
import com.boreal.allen.components.bottomnavigation.currentRoute
import com.boreal.allen.domain.AddProductScreen
import com.boreal.allen.ui.general.logingraph.welcome.*
import com.boreal.allen.ui.seller.addproduct.main.ViewAddProductMainCompose
import com.boreal.allen.ui.seller.businessinformation.ViewOtherCompose
import com.boreal.allen.ui.seller.businessinformation.promotion.ViewBussinessInformationPromotionCompose
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun ViewAddProductContainerCompose(
    navController: NavHostController? = null, closeApp: () -> Unit = {}
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
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val currentRoute = currentRoute(navController = innerBussinessNavController)

    currentRoute

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Scaffold(modifier = Modifier.fillMaxWidth(),
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
            scaffoldState = scaffoldState,
            drawerContent = {
                BussinessInformationDrawer {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                    when (it.option) {
                        DrawerOptions.Main -> {
                            innerBussinessNavController.navigate(AddProductScreen.MainScreen.route)
                        }
                        DrawerOptions.Details -> {
                            innerBussinessNavController.navigate(AddProductScreen.DetailScreen.route)
                        }
                        DrawerOptions.Price -> {
                            innerBussinessNavController.navigate(AddProductScreen.PriceScreen.route)
                        }
                        DrawerOptions.Tags -> {
                            innerBussinessNavController.navigate(AddProductScreen.TagsScreen.route)
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
                    startDestination = AddProductScreen.MainScreen.route,
                    route = "BUSSINESS"
                ) {
                    composable(route = AddProductScreen.MainScreen.route) {
                        ViewAddProductMainCompose(
                            navController = innerBussinessNavController
                        ) {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    }
                    composable(route = AddProductScreen.DetailScreen.route) {
                        ViewAddProductMainCompose(
                            navController = innerBussinessNavController
                        ) {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }

                    }
                    composable(route = AddProductScreen.PriceScreen.route) {
                        ViewOtherCompose {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    }
                    composable(route = AddProductScreen.TagsScreen.route) {
                        ViewBussinessInformationPromotionCompose(
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