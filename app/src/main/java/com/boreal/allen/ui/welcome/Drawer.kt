package com.boreal.allen.ui.welcome

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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.allen.BuildConfig
import com.boreal.allen.R
import com.boreal.allen.components.BoldText
import com.boreal.allen.components.LogoBlue
import com.boreal.allen.components.MediumText
import com.boreal.allen.theme.*

data class MenuItem(
    val title: String,
    @DrawableRes val icon: Int,
    val contentDescription: String,
    val option: DrawerOptions,
    val close: Int = -1
)

sealed class DrawerOptions(val name: String) {
    object Buys : DrawerOptions("BUYS")
    object Favorites : DrawerOptions("FAVORITES")
    object Stores : DrawerOptions("STORES")
    object Notifications : DrawerOptions("NOTIFICATIONS")
    object Exit : DrawerOptions("EXIT")
    object CloseSession : DrawerOptions("CLOSE_SESSION")
}

@Preview(showBackground = true)
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
                .height(100.dp)
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
                BoldText("Luna")
                UserStarStatus()
            }
        }
    }
}

@Composable
fun UserStarStatus() {
    Row(
        modifier = Modifier
            .padding(top = 4.dp)
            .fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_start_icon),
            contentDescription = "star User",
            tint = StarColor
        )
        BoldText(modifier = Modifier.padding(start = 5.dp), size = 15.sp, text = "4.6")
        BoldText(
            modifier = Modifier.padding(start = 10.dp),
            text = "(12 Compras)",
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
                Icon(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, start = 15.dp)
                        .width(25.dp)
                        .height(25.dp),
                    painter = painterResource(id = item.icon),
                    tint = GrayLetterDrawer,
                    contentDescription = item.contentDescription
                )
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
                Card(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
                        .width(40.dp)
                        .height(40.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = CircleShape
                ) {
                    Image(
                        modifier = Modifier
                            .padding(13.dp)
                            .height(50.dp)
                            .rotate(180f),
                        painter = painterResource(id = R.drawable.ic_right_arrow_simbol),
                        contentDescription = ""
                    )
                }
            }
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                verticalAlignment = CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                LogoBlue(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .align(CenterVertically)
                        .width(38.dp)
                        .fillMaxHeight()
                )
                MediumText(
                    text = "v. ${BuildConfig.VERSION_NAME}",
                    color = GrayLetterDrawer,
                    size = 13.sp
                )
            }
        }
    }

}