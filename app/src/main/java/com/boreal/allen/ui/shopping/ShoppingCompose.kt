package com.boreal.allen.ui.shopping

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavHostController
import com.boreal.allen.R
import com.boreal.allen.components.BoldText
import com.boreal.allen.components.SemiBoldText
import com.boreal.allen.components.ShoppingCartStoreItem
import com.boreal.allen.components.ToolbarTitle
import com.boreal.allen.domain.model.ItemCartModel
import com.boreal.allen.domain.model.ProductShoppingCart
import com.boreal.allen.theme.GrayBackgroundMain
import com.boreal.allen.theme.PrimaryColor
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview(showBackground = true)
@Composable
fun ViewShoppingCompose(navController: NavHostController? = null) {
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
            val listContent = createRefFor("listContent")
            val bottomQuestion = createRefFor("bottomQuestion")
            val content = createRefFor("content")
            val guideLine = createGuidelineFromTop(0.09f)

            val guideLineSearch = createGuidelineFromTop(0.095f)

            constrain(content) {
                top.linkTo(guideLineSearch, 0.dp)
                bottom.linkTo(bottomQuestion.top, margin = 0.dp)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(toolbarTitle) {
                top.linkTo(parent.top)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(listContent) {
                top.linkTo(guideLine)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(bottomQuestion.top)
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
                .fillMaxSize()
                .background(GrayBackgroundMain)
                .layoutId("listContent")
        ) {

            item {
                Card(
                    modifier = Modifier.padding(bottom = 30.dp),
                    elevation = 3.dp,
                    backgroundColor = White
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 30.dp, end = 30.dp, top = 15.dp, bottom = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            BoldText(
                                text = "En curso",
                                size = 18.sp
                            )
                            Card(
                                modifier = Modifier.size(25.dp),
                                shape = CircleShape,
                                backgroundColor = PrimaryColor
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    SemiBoldText(
                                        text = "1",
                                        color = White
                                    )
                                }
                            }
                        }
                        FlowRow(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            val list = listOf(
                                ItemCartModel(
                                    nameStore = "Ferreteria La Hormiga",
                                    idStore = "idmidjikjdokjdo",
                                    imgStore = "didimd",
                                    listItems = listOf(
                                        ProductShoppingCart(
                                            skuProduct = "d2d232",
                                            nameProduct = "1KG Clavo 1/2 pulgada",
                                            imgProduct = "ccdcdomd",
                                            categoryItem = "Ropa",
                                            quantity = 1,
                                            discountPercentage = 0.0,
                                            fastOrder = true,
                                            minimalFastOrder = 2,
                                            price = 46.0
                                        ),
                                        ProductShoppingCart(
                                            skuProduct = "d2d232",
                                            nameProduct = "Martillo",
                                            imgProduct = "ccdcdomd",
                                            categoryItem = "Ropa",
                                            quantity = 1,
                                            discountPercentage = 15.0,
                                            fastOrder = true,
                                            minimalFastOrder = 2,
                                            price = 46.0
                                        )
                                    )
                                ),
                                ItemCartModel(
                                    nameStore = "Nike Store",
                                    idStore = "idmidjikjdokjdo",
                                    imgStore = "didimd",
                                    listItems = listOf(
                                        ProductShoppingCart(
                                            skuProduct = "d2d232",
                                            nameProduct = "Balon Basketball num 6edcwedwedwedcedwcef",
                                            imgProduct = "ccdcdomd",
                                            categoryItem = "Deportes",
                                            quantity = 2,
                                            discountPercentage = 10.0,
                                            fastOrder = true,
                                            minimalFastOrder = 2,
                                            price = 50.0
                                        )
                                    )
                                )
                            )

                            list.forEachIndexed { index, item ->
                                ShoppingCartStoreItem(
                                    modifier = Modifier.padding(
                                        horizontal = 30.dp
                                    ),
                                    item = item,
                                    counter = false,
                                    deleteOptions = false,
                                    selector = false,
                                    hideTopLine = index != list.lastIndex
                                )
                            }

                        }
                    }

                }
            }
            item {
                Card(
                    elevation = 3.dp,
                    backgroundColor = White
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp, horizontal = 30.dp)
                        ) {
                            BoldText(
                                text = "Anteriores",
                                size = 18.sp
                            )
                        }
                        FlowRow(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            val list = listOf(
                                ItemCartModel(
                                    nameStore = "Ferreteria La Hormiga",
                                    idStore = "idmidjikjdokjdo",
                                    imgStore = "didimd",
                                    listItems = listOf(
                                        ProductShoppingCart(
                                            skuProduct = "d2d232",
                                            nameProduct = "1KG Clavo 1/2 pulgada",
                                            imgProduct = "ccdcdomd",
                                            categoryItem = "Ropa",
                                            quantity = 1,
                                            discountPercentage = 0.0,
                                            fastOrder = true,
                                            minimalFastOrder = 2,
                                            price = 46.0
                                        ),
                                        ProductShoppingCart(
                                            skuProduct = "d2d232",
                                            nameProduct = "Martillo",
                                            imgProduct = "ccdcdomd",
                                            categoryItem = "Ropa",
                                            quantity = 1,
                                            discountPercentage = 15.0,
                                            fastOrder = true,
                                            minimalFastOrder = 2,
                                            price = 46.0
                                        )
                                    )
                                ),
                                ItemCartModel(
                                    nameStore = "Nike Store",
                                    idStore = "idmidjikjdokjdo",
                                    imgStore = "didimd",
                                    listItems = listOf(
                                        ProductShoppingCart(
                                            skuProduct = "d2d232",
                                            nameProduct = "Balon Basketball num 6edcwedwedwedcedwcef",
                                            imgProduct = "ccdcdomd",
                                            categoryItem = "Deportes",
                                            quantity = 2,
                                            discountPercentage = 10.0,
                                            fastOrder = true,
                                            minimalFastOrder = 2,
                                            price = 50.0
                                        )
                                    )
                                )
                            )
                            list.forEachIndexed { index, item ->
                                ShoppingCartStoreItem(
                                    modifier = Modifier.padding(
                                        start = 30.dp,
                                        end = 30.dp
                                    ),
                                    item = item,
                                    counter = false,
                                    deleteOptions = false,
                                    selector = false,
                                    hideTopLine = index != list.lastIndex
                                )
                            }

                        }
                    }
                }
            }
        }
        ToolbarTitle(
            modifier = Modifier.layoutId("toolbarTitle"),
            titleText = "Mis compras",
            backClicked = {
                navController?.navigateUp()
            },
            showEndImage = false,
            iconIdRes = R.drawable.ic_coupon,
        )

    }
}