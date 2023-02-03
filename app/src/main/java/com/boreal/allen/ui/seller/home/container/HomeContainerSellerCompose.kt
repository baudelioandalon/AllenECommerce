package com.boreal.allen.ui.seller.home.container

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
import com.boreal.allen.R
import com.boreal.allen.components.bottomnavigation.CustomBottomNavigation
import com.boreal.allen.domain.NOTIFICATION_CLIENT_GRAPH
import com.boreal.allen.domain.SALES_SELLER_GRAPH
import com.boreal.allen.domain.SellerScreen
import com.boreal.allen.ui.general.logingraph.welcome.DrawerBody
import com.boreal.allen.ui.general.logingraph.welcome.DrawerHeader
import com.boreal.allen.ui.general.logingraph.welcome.DrawerOptions
import com.boreal.allen.ui.general.logingraph.welcome.MenuItem
import com.boreal.allen.ui.seller.home.ViewHomeSellerCompose
import com.boreal.allen.ui.seller.products.ViewMyProductsSellerCompose
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun ViewHomeContainerSellerCompose(
    navController: NavHostController? = null,
    closeApp: () -> Unit = {}
) {
    val innerSellerNavController = rememberNavController()
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
    val currentScreen = remember { mutableStateOf<SellerScreen>(SellerScreen.HomeSellerScreen) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Scaffold(modifier = Modifier
            .fillMaxWidth(),
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
            scaffoldState = scaffoldState,
            bottomBar = {
                CustomBottomNavigation(currentScreenId = currentScreen.value.route) {
                    currentScreen.value = it
                    innerSellerNavController.navigate(it.route)
                }
            },
            drawerContent = {
                DrawerHeader {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
                DrawerBody(
                    items = listOf(
                        MenuItem(
                            "Ventas",
                            icon = R.drawable.ic_cart_icon,
                            contentDescription = "Cart",
                            option = DrawerOptions.Sales
                        ),
                        MenuItem(
                            "Sucursales",
                            icon = R.drawable.ic_stores_icon,
                            contentDescription = "My stores",
                            option = DrawerOptions.MyStores
                        ),
                        MenuItem(
                            "Notificaciónes",
                            icon = R.drawable.ic_bell_icon,
                            contentDescription = "Notifications",
                            option = DrawerOptions.Notifications
                        ),
                        MenuItem(
                            "Salir",
                            icon = R.drawable.ic_arrow_right,
                            contentDescription = "Exit",
                            option = DrawerOptions.Exit,
                            close = 0
                        ),
                        MenuItem(
                            "Cerrar sesión",
                            icon = R.drawable.ic_close_session_icon,
                            contentDescription = "Close session",
                            option = DrawerOptions.CloseSession
                        )
                    ),
                ) {
                    println("Clicked on ${it.option.name}")
                    when (it.option) {
                        DrawerOptions.Exit -> {
                            closeApp()
                        }
                        DrawerOptions.MyProducts -> {
//                            navController?.navigate(SHOPPING_CLIENT_GRAPH)
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                        DrawerOptions.Sales -> {
                            navController?.navigate(SALES_SELLER_GRAPH)
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                        DrawerOptions.MyStores -> {
//                            navController?.navigate(FAVORITES_GRAPH)
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                        DrawerOptions.Notifications -> {
                            navController?.navigate(NOTIFICATION_CLIENT_GRAPH)
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                        else -> {

                        }
                    }
                }
            },
            content = {

                NavHost(
                    navController = innerSellerNavController,
                    startDestination = SellerScreen.HomeSellerScreen.route
                ) {
                    composable(route = SellerScreen.HomeSellerScreen.route) {
                        ViewHomeSellerCompose(
                            scaffoldState = scaffoldState,
                            scope = scope,
                            navController = innerSellerNavController
                        )
                    }
                    composable(route = SellerScreen.ProductsSellerScreen.route) {
                        ViewMyProductsSellerCompose(
                            navController = innerSellerNavController,
                            scaffoldState = scaffoldState,
                            scope = scope,
                            closeApp = closeApp
                        )
                    }
                }
                it.calculateBottomPadding()
            })

    }
}
