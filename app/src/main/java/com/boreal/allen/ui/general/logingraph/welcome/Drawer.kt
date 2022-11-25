package com.boreal.allen.ui.general.logingraph.welcome

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.allen.R
import com.boreal.allen.components.BoldText
import com.boreal.allen.components.Selector
import com.boreal.allen.components.SemiBoldText
import com.boreal.allen.theme.*

data class MenuItem(
    val title: String,
    @DrawableRes val icon: Int,
    val contentDescription: String,
    val option: DrawerOptions,
    val close: Int = -1
)

sealed class DrawerOptions(val name: String) {
    //Client
    object Buys : DrawerOptions("BUYS")
    object Favorites : DrawerOptions("FAVORITES")
    object Stores : DrawerOptions("STORES")

    //Seller
    object MyProducts : DrawerOptions("MY_PRODUCTS")
    object Sales : DrawerOptions("SALES")
    object MyStores : DrawerOptions("MY_STORES")

    //General
    object Notifications : DrawerOptions("NOTIFICATIONS")
    object Exit : DrawerOptions("EXIT")
    object CloseSession : DrawerOptions("CLOSE_SESSION")

    //BussinessInformation
    object Main : DrawerOptions("MAIN")
    object Contact : DrawerOptions("CONTACT")
    object ShippingAndPayments : DrawerOptions("SHIPPING_AND_PAYMENTS")
    object Promotion : DrawerOptions("Promotion")
    object Save : DrawerOptions("Save")
}

@Composable
fun TestDrawer() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(GrayBackgroundMain)
    ) {
        DrawerHeader()
        DrawerBody(items = listOf(
            MenuItem(
                "Compras",
                icon = R.drawable.ic_cart_icon,
                contentDescription = "Cart",
                option = DrawerOptions.Buys
            ),
            MenuItem(
                "Favoritos",
                icon = R.drawable.ic_heart_icon,
                contentDescription = "Favorites",
                option = DrawerOptions.Favorites
            ),
            MenuItem(
                "Tiendas",
                icon = R.drawable.ic_stores_icon,
                contentDescription = "Stores",
                option = DrawerOptions.Stores
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
        ), onItemClick = {

        })
    }
}

@Preview(showBackground = true)
@Composable
fun TestDrawerBussinessInformation() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(GrayBackgroundMain)
    ) {
        BussinessInformationDrawerBody(items = listOf(
            MenuItem(
                "Compras",
                icon = R.drawable.ic_cart_icon,
                contentDescription = "Cart",
                option = DrawerOptions.Buys
            ),
            MenuItem(
                "Favoritos",
                icon = R.drawable.ic_heart_icon,
                contentDescription = "Favorites",
                option = DrawerOptions.Favorites
            ),
            MenuItem(
                "Tiendas",
                icon = R.drawable.ic_stores_icon,
                contentDescription = "Stores",
                option = DrawerOptions.Stores
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
        ), onItemClick = {

        })
    }
}

@Composable
fun BussinessInformationDrawer(onItemClicked: (MenuItem) -> Unit = {}) {
    Column(modifier = Modifier.fillMaxWidth()) {
        BussinessInformationDrawerBody(
            items = listOf(
                MenuItem(
                    "Principal",
                    icon = R.drawable.ic_menu_icon,
                    contentDescription = "main",
                    option = DrawerOptions.Main
                ),
                MenuItem(
                    "Contacto",
                    icon = R.drawable.ic_user,
                    contentDescription = "Contact",
                    option = DrawerOptions.Contact
                ),
                MenuItem(
                    "Envíos \n Y Pagos",
                    icon = R.drawable.ic_bell_icon,
                    contentDescription = "envios y pagos",
                    option = DrawerOptions.ShippingAndPayments
                ),
                MenuItem(
                    "Promo\nción",
                    icon = R.drawable.ic_arrow_right,
                    contentDescription = "promoción",
                    option = DrawerOptions.Promotion,
                    close = 0
                ),
                MenuItem(
                    "Guardar",
                    icon = R.drawable.ic_check_mark,
                    contentDescription = "guardar",
                    option = DrawerOptions.CloseSession
                ),
                MenuItem(
                    "Salir",
                    icon = R.drawable.ic_arrow_right,
                    contentDescription = "salir",
                    option = DrawerOptions.CloseSession
                )
            )
        ) {
            onItemClicked.invoke(it)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DrawerHeader(closeClicked: (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(GrayBackgroundMain)
    ) {
        Row(
            modifier = Modifier
                .background(White)
                .padding(top = 8.dp, start = 30.dp, end = 21.dp)
                .fillMaxWidth()
                .align(Alignment.End)
                .height(40.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Card(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp),
                backgroundColor = GrayBackgroundDrawerDismiss,
                elevation = 0.dp,
                shape = CircleShape, onClick = { closeClicked?.invoke() }) {
                Image(
                    modifier = Modifier
                        .padding(
                            top = 12.dp, bottom = 15.dp,
                            start = 8.dp, end = 8.dp
                        ),
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = ""
                )
            }
        }

        Row(
            modifier = Modifier
                .background(White)
                .height(110.dp)
                .padding(top = 13.dp, start = 30.dp)
        ) {
            Card(
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp),
                elevation = 0.dp,
                shape = CircleShape, onClick = { }) {
                Image(
                    modifier = Modifier.height(50.dp),
                    painter = painterResource(id = R.drawable.person_test),
                    contentDescription = ""
                )
            }
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(start = 15.dp)
            ) {
                BoldText(
                    text = "Hola, buen dia",
                    color = GrayLetterDrawer,
                    size = 15.sp
                )
                BoldText(text = "Luna")
                StarStatus()
            }
        }
    }
}

@Composable
fun StarStatus(
    modifier: Modifier = Modifier,
    text: String = "(12 Compras)",
    stars: String = "4.6"
) {
    Row(
        modifier = modifier
            .padding(top = 4.dp)
            .fillMaxSize(), verticalAlignment = CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_star_icon),
            contentDescription = "star User",
            tint = StarColor
        )
        BoldText(modifier = Modifier.padding(start = 5.dp), size = 15.sp, text = stars)
        BoldText(
            modifier = Modifier.padding(start = 10.dp),
            text = text,
            color = GrayLetterDrawer,
            size = 15.sp
        )
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxSize()
            .background(GrayBackgroundMain)
    ) {
        itemsIndexed(items) { index, item ->
            Row(
                modifier = Modifier
                    .padding(
                        top = if (index == 0) 5.dp else {
                            when (item.close) {
                                0 -> {
                                    60.dp
                                }
                                else -> {
                                    2.dp
                                }
                            }
                        }
                    )
                    .background(White)
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(item)
                    },
                verticalAlignment = CenterVertically
            ) {

                Text(
                    text = item.title,
                    style = TextStyle(
                        fontSize = 15.sp, letterSpacing = 0.sp,
                        fontFamily = MaterialTheme.typography.caption.fontFamily,
                        fontWeight = Medium
                    ),
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, start = 12.dp)
                        .weight(1f)
                )
            }
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BussinessInformationDrawerBody(
    items: List<MenuItem>,
    onItemClick: (MenuItem) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxSize()
            .background(GrayBackgroundMain)
    ) {
        item {
            SemiBoldText(
                modifier = Modifier.padding(start = 30.dp, top = 28.dp, bottom = 30.dp),
                text = "Menu"
            )
        }
        itemsIndexed(items) { index, item ->
            Row(
                modifier = Modifier
                    .padding(top = 20.dp, start = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .height(56.dp),
                    backgroundColor = GrayBackgroundMain,
                    elevation = 0.dp,
                    onClick = {
                        onItemClick.invoke(item)
                    }
                ) {
                    Selector(
                        roundDp = 15.dp,
                        backgroundColor = OrangeBackground,
                        text = item.title,
                        textColor = OrangeStrong,
                        onClicked = null
                    )
                }
            }
        }
    }

}