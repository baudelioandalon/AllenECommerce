package com.boreal.allen.ui.shoppingcart

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.boreal.allen.R
import com.boreal.allen.components.*
import com.boreal.allen.domain.model.ItemCartModel
import com.boreal.allen.domain.model.ProductShoppingCart
import com.boreal.allen.extensions.drawColoredShadow
import com.boreal.allen.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview(showBackground = true)
@Composable
fun ViewRatingProductCompose() {
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
            val container = createRefFor("container")
            val bottomQuestion = createRefFor("bottomQuestion")
            val content = createRefFor("content")
            val guideLine = createGuidelineFromTop(0.09f)

            val guideLineSearch = createGuidelineFromTop(0.095f)

            constrain(toolbarTitle) {
                top.linkTo(parent.top)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(container) {
                top.linkTo(guideLine)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(guideLineSearch)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(content) {
                top.linkTo(guideLineSearch, 0.dp)
                bottom.linkTo(bottomQuestion.top, margin = 0.dp)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(bottomQuestion) {
                bottom.linkTo(parent.bottom)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
        }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GrayBackgroundMain)
                .layoutId("content")
        ) {

            itemsIndexed(
                listOf(
                    ItemCartModel(
                        nameStore = "Ferreteria La Hormiga",
                        idStore = "idmidjikjdokjdo",
                        imgStore = "didimd",
                        listItems = listOf(
                            ProductShoppingCart(
                                skuProduct = "d2d232",
                                nameProduct = "Camiseta",
                                imgProduct = "ccdcdomd",
                                categoryItem = "Ropa",
                                quantity = 1,
                                discountPercentage = 15.0,
                                fastOrder = true,
                                minimalFastOrder = 2,
                                price = 46.0
                            )
                        )
                    )
                )
            ) { index, item ->

            }
        }
        ToolbarTitle(
            modifier = Modifier.layoutId("toolbarTitle"),
            titleText = "Mi carrito", backClicked = {

            },
            iconIdRes = R.drawable.ic_coupon
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .layoutId("bottomQuestion"),
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
                        start = 30.dp, end = 30.dp,
                        bottom = 18.dp
                    ),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        RegularText(
                            modifier = Modifier.weight(1f),
                            text = "Pagar",
                            color = GrayLetterShipping,
                            size = 18.sp
                        )
                        BoldText(
                            modifier = Modifier
                                .wrapContentWidth()
                                .padding(bottom = 5.dp),
                            text = "$100",
                            color = OrangeTransparent,
                            size = 12.sp
                        )
                        BoldText(
                            modifier = Modifier
                                .wrapContentWidth()
                                .padding(start = 21.dp),
                            text = "$92",
                            color = GreenStrong,
                            size = 30.sp,
                            align = TextAlign.End
                        )
                    }
                    ShadowButton(
                        modifier = Modifier
                            .padding(bottom = 18.dp, top = 24.dp)
                            .fillMaxWidth()
                            .drawColoredShadow(
                                color = BlueTransparent, alpha = 1f, borderRadius = 10.dp,
                                offsetY = 6.dp, offsetX = 5.dp, blurRadius = 10.dp
                            ),
                        text = "Continuar"
                    )
                }
            }
        }
    }
}