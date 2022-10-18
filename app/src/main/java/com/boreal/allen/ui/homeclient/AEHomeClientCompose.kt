package com.boreal.allen.ui.homeclient

import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavHostController
import com.boreal.allen.R
import com.boreal.allen.components.*
import com.boreal.allen.domain.model.PromotionItem
import com.boreal.allen.theme.GrayBackgroundMain
import com.boreal.allen.theme.GrayInactiveIndicator
import com.boreal.allen.theme.PrimaryColor
import com.boreal.allen.theme.categorySelectorColors
import com.boreal.allen.ui.welcome.DrawerBody
import com.boreal.allen.ui.welcome.DrawerHeader
import com.boreal.allen.ui.welcome.DrawerOptions
import com.boreal.allen.ui.welcome.MenuItem
import com.google.accompanist.pager.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

@Composable
fun AEHomeClientComposable(navController: NavHostController, closeApp: () -> Unit) {
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
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Scaffold(modifier = Modifier
            .fillMaxWidth(),
            drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
            scaffoldState = scaffoldState,
            drawerContent = {
                DrawerHeader {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
                DrawerBody(
                    items = listOf(
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
                    ),
                ) {
                    println("Clicked on ${it.option.name}")
                    if (it.option == DrawerOptions.Exit) {
                        closeApp()
                    }
                }
            },
            content = {
                ConstraintLayout(modifier = Modifier
                    .fillMaxSize()
                    .background(White), constraintSet = ConstraintSet {
                    val search = createRefFor("searchHome")
                    val content = createRefFor("content")
                    constrain(search) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    }
                    constrain(content) {
                        top.linkTo(search.bottom, margin = 5.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }
                }) {

                    Card(
                        modifier = Modifier
                            .layoutId("searchHome")
                            .wrapContentSize(),
                        elevation = 5.dp
                    ) {
                        ToolbarSearchHome(menuClicked = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        })
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .layoutId("content")
                            .background(GrayBackgroundMain)
                            .verticalScroll(scrollState)
                    ) {
                        TopContainer()
                        BrandingContainer()
                        LastItemsContainer()
                        CategoryListContainer()
                        OffersItemsContainer()
                    }
                }
                it.calculateBottomPadding()
            })

    }
}

@Composable
fun TopContainer() {
    AutoSliding()
    LazyRow(
        modifier = Modifier.background(White)
    ) {
        items(4) {
            CategoryItem()
        }
    }
}

@Composable
fun BrandingContainer() {
    Column(
        modifier = Modifier
            .padding(top = 30.dp)
            .background(White)
    ) {
        MediumTextBold(modifier = Modifier.padding(start = 30.dp, top = 20.dp), text = "Marcas")
        LazyRow(
            modifier = Modifier
                .padding(
                    top = 30.dp,
                    bottom = 35.dp
                )
        ) {
            items(10) {
                BrandingItem()
            }
        }
    }
}

@Composable
fun LastItemsContainer() {
    Column(
        modifier = Modifier
            .padding(top = 30.dp)
            .background(White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MediumTextBold(
                modifier = Modifier.padding(start = 30.dp, top = 20.dp),
                text = "Ultimos articulos"
            )
            SeeAll(
                modifier = Modifier.padding(top = 20.dp, end = 9.dp),
                text = "Ver todos"
            )
        }
        LazyRow(
            modifier = Modifier
                .padding(
                    top = 30.dp,
                    bottom = 35.dp
                )
        ) {
            items(10) {
                HomeItem()
            }
        }
    }
}

@Composable
fun CategoryListContainer() {
    Column(
        modifier = Modifier
            .padding(top = 30.dp)
            .background(White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MediumTextBold(
                modifier = Modifier.padding(start = 30.dp, top = 20.dp),
                text = "Tecnologia"
            )
        }
        LazyRow(
            modifier = Modifier
                .padding(
                    top = 30.dp,
                    bottom = 35.dp
                )
        ) {

            items(10) { index ->
                CategorySelectorItem(
                    index % 2 != 0,
                    categorySelectorColors[index % categorySelectorColors.size]
                )
            }
        }
    }
}

@Composable
fun OffersItemsContainer() {
    Column(
        modifier = Modifier
            .padding(top = 30.dp, bottom = 100.dp)
            .background(White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MediumTextBold(
                modifier = Modifier.padding(start = 30.dp, top = 20.dp),
                text = "Ofertas"
            )
            SeeAll(
                modifier = Modifier.padding(top = 20.dp, end = 9.dp),
                text = "Ver todos"
            )
        }
        LazyRow(
            modifier = Modifier
                .padding(
                    top = 30.dp,
                    bottom = 35.dp
                )
        ) {
            items(10) {
                HomeItem()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AutoSliding() {
    val promotion = listOf(
        PromotionItem("Title one", R.drawable.pager_one),
        PromotionItem("Title two", R.drawable.pager_two)
    )
    val pagerState = rememberPagerState(pageCount = promotion.size)
    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(5000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )
        }
    }
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(start = 30.dp, top = 10.dp)
                .fillMaxSize()
        ) { page ->
            Image(
                painter = painterResource(id = promotion[page].imgUrl),
                contentDescription = promotion[page].title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        val pagerOffset = calculateCurrentOffsetForPage(page).absoluteValue
                        lerp(
                            start = 1.1f,
                            stop = 1f,
                            fraction = 1f - pagerOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                    }
            )
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .background(White)
                .align(Alignment.CenterHorizontally),
            inactiveColor = GrayInactiveIndicator,
            activeColor = PrimaryColor
        )
    }
}