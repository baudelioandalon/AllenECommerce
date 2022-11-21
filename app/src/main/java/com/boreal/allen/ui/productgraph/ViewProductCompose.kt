package com.boreal.allen.ui.productgraph

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavController
import com.boreal.allen.R
import com.boreal.allen.components.*
import com.boreal.allen.domain.RESULT_BY_SELLER_CLIENT_GRAPH
import com.boreal.allen.domain.SHOPPING_CART_GRAPH
import com.boreal.allen.extensions.drawColoredShadow
import com.boreal.allen.theme.*
import com.boreal.allen.ui.logingraph.welcome.StarStatus
import com.boreal.allen.ui.productgraph.question.QUESTION_GRAPH
import com.boreal.allen.ui.productgraph.ratinggraph.RATING_PRODUCT_GRAPH
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ViewProductCompose(navController: NavController) {
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

    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(GrayBackgroundMain),
        constraintSet = ConstraintSet {
            val toolbarTitle = createRefFor("toolbarTitle")
            val bottomPrice = createRefFor("bottomPrice")
            val content = createRefFor("content")
            val guideLine = createGuidelineFromTop(0.09f)
            constrain(toolbarTitle) {
                top.linkTo(parent.top)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(content) {
                top.linkTo(guideLine)
                bottom.linkTo(parent.bottom)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(bottomPrice) {
                bottom.linkTo(parent.bottom)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
        }) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(GrayBackgroundMain)
                .layoutId("content")
        ) {
            item {
                Row(
                    modifier = Modifier
                        .background(White)
                        .padding(end = 30.dp, start = 30.dp)
                        .fillMaxSize()
                ) {
                    Card(
                        modifier = Modifier
                            .padding(
                                top = 49.dp,
                                bottom = 32.dp
                            )
                            .fillMaxWidth(0.75f)
                            .height(240.dp),
                        backgroundColor = GrayBackgroundDrawerDismiss,
                        elevation = 0.dp,
                        shape = RoundedCornerShape(20.dp)
                    ) {

                    }
                    LazyColumn(
                        modifier = Modifier
                            .width(100.dp)
                            .height(289.dp)
                    ) {
                        items(5) {
                            Card(
                                modifier = Modifier
                                    .padding(start = 30.dp, top = 20.dp)
                                    .size(53.dp),
                                backgroundColor = GrayBackgroundDrawerDismiss,
                                elevation = 0.dp,
                                shape = RoundedCornerShape(10.dp)
                            ) {

                            }
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White)
                        .padding(end = 30.dp, start = 30.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    FreeShipping(modifier = Modifier.padding())
                    MediumText(
                        text = "Comprando 4 articulos",
                        size = 10.sp,
                        color = GrayLetterShipping
                    )
                    FavoriteButton(
                        modifier = Modifier.padding(start = 20.dp)
                    )
                    ShareButton()
                }
                Row(
                    modifier = Modifier
                        .background(White)
                        .padding(top = 21.dp, end = 30.dp, start = 30.dp)
                        .fillMaxWidth()
                ) {
                    BoldText(text = "Miniesmeriladora Angular")
                }
                StarStatus(
                    modifier = Modifier
                        .background(White)
                        .fillMaxWidth()
                        .padding(end = 30.dp, start = 30.dp)
                )
                SemiBoldText(
                    modifier = Modifier
                        .background(White)
                        .fillMaxWidth()
                        .padding(end = 30.dp, top = 38.dp, start = 30.dp),
                    text = "Información del articulo",
                    size = 13.sp
                )
                SemiBoldText(
                    modifier = Modifier
                        .background(White)
                        .fillMaxWidth()
                        .padding(end = 30.dp, start = 30.dp),
                    color = GrayLetterShipping,
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                            "Integer tempus consectetur augue, ac pretium ipsum faucibus sit amet.",
                    size = 13.sp,
                    align = TextAlign.Justify
                )
                SemiBoldText(
                    modifier = Modifier
                        .background(White)
                        .fillMaxWidth()
                        .padding(
                            end = 30.dp, start = 30.dp, top = 23.dp
                        ), text = "Seleccione version"
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White)
                        .padding(end = 30.dp, bottom = 45.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    LazyRow(
                        modifier = Modifier
                            .padding(
                                end = 30.dp,
                                start = 30.dp,
                                top = 23.dp
                            ),
                    ) {
                        itemsIndexed(listOf("", "")) { index, item ->
                            Column(
                                modifier = Modifier
                                    .padding(end = 30.dp)
                                    .width(43.dp)
                                    .wrapContentHeight()
                            ) {
                                Surface(
                                    modifier = Modifier
                                        .size(43.dp),
                                    color = if (index % 2 != 0) {
                                        Purple700
                                    } else White,
                                    border = if (index % 2 == 0) {
                                        BorderStroke(
                                            width = 1.dp,
                                            color = StarColor
                                        )
                                    } else null,
                                    shape = RoundedCornerShape(10.dp),
                                    onClick = {}
                                ) {
                                }
                                BoldText(
                                    modifier = Modifier.padding(top = 5.dp),
                                    size = 10.sp,
                                    text = "115v Amarillo"
                                )
                            }
                        }
                    }
                    SelectorCounter()
                }
                SelectorDetail(
                    text = "Detalles del producto",
                    iconRes = R.drawable.ic_detail_icon
                ) {

                }
                SeparatorGray(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White)
                        .padding(start = 30.dp, end = 30.dp)
                )
                SelectorDetail(
                    text = "Calificaciones",
                    iconRes = R.drawable.ic_comment_icon
                ) {
                    navController.navigate(RATING_PRODUCT_GRAPH)
                }
                SeparatorGray(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White)
                        .padding(start = 30.dp, end = 30.dp)
                )
                SelectorDetail(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White)
                        .padding(bottom = 17.dp),
                    text = "Preguntas",
                    iconRes = R.drawable.ic_questions_icon
                ) {
                    navController.navigate(QUESTION_GRAPH)
                }
            }
            item {
                SellerItem {
                    navController.navigate(RESULT_BY_SELLER_CLIENT_GRAPH)
                }
            }
            item {
                SellerItemsItem()
            }
            item {
                CategorySeller()
            }
            item {
                SellersItem()
            }
        }
        ToolbarTitle(
            modifier = Modifier.layoutId("toolbarTitle"),
            titleText = "Articulo", backClicked = {
                navController.navigateUp()
            }, cartClicked = {
                navController.navigate(SHOPPING_CART_GRAPH)
            }
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .layoutId("bottomPrice"),
            elevation = 9.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(White),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 30.dp,
                        bottom = 18.dp
                    ),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Discount()
                    Row(verticalAlignment = Alignment.Bottom) {
                        BoldText(
                            text = "$435.00"
                        )
                        SmallText(
                            modifier = Modifier.padding(
                                start = 10.dp,
                            ), text = "$490.00"
                        )
                    }
                }

                ShadowButton(
                    modifier = Modifier
                        .padding(bottom = 18.dp, end = 30.dp)
                        .width(117.dp)
                        .height(52.dp)
                        .drawColoredShadow(
                            color = BlueTransparent, alpha = 1f, borderRadius = 10.dp,
                            offsetY = 6.dp, offsetX = 5.dp, blurRadius = 10.dp
                        ),
                    text = "Agregar al carrito",
                    size = 15.sp
                )

            }
        }

    }
}