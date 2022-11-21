package com.boreal.allen.ui.shoppingdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.*
import androidx.navigation.NavHostController
import com.boreal.allen.R
import com.boreal.allen.components.*
import com.boreal.allen.domain.model.ItemCartModel
import com.boreal.allen.domain.model.ProductShoppingCart
import com.boreal.allen.extensions.DottedShape
import com.boreal.allen.theme.*
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview(showBackground = true)
@Composable
fun ViewShoppingDetailCompose(navController: NavHostController? = null) {
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(bottom = 30.dp),
                    elevation = 5.dp
                ) {
                    ConstraintLayout(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .background(White),
                        constraintSet = ConstraintSet {
                            val map = createRefFor("map")
                            val shoppingStatus = createRefFor("shoppingStatus")

                            constrain(map) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                width = Dimension.fillToConstraints
                                height = Dimension.value(300.dp)
                            }
                            constrain(shoppingStatus) {
                                top.linkTo(map.bottom, (-40).dp)
                                width = Dimension.matchParent
                                height = Dimension.preferredWrapContent.atLeastWrapContent
                            }
                        }) {

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .layoutId("map"),
                            backgroundColor = GrayBackgroundDrawerDismiss,
                            elevation = 0.dp
                        ) {

                        }
                        Card(
                            modifier = Modifier
                                .padding(bottom = 30.dp, start = 30.dp, end = 30.dp)
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .layoutId("shoppingStatus"),
                            backgroundColor = Transparent,
                            elevation = 0.dp,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Column {
                                StatusPackageItem(
                                    default = false
                                )
                                FlowRow(
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    val list = listOf(false, false, false, false, false, true)
                                    list.forEach {
                                        StatusPreviouPackageItem(lastItem = it)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = 10.dp
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentWidth(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.Start
                    ) {
                        ResumeSelector(
                            modifier = Modifier.padding(horizontal = 30.dp),
                            textTop = "Forma de pago",
                            textBottom = "Contra entrega en efectivo"
                        )
                        ResumeSelector(
                            modifier = Modifier.padding(horizontal = 30.dp),
                            textTop = "Recibe",
                            textBottom = "Luna Lovegood"
                        )
                        ResumeSelector(
                            modifier = Modifier.padding(horizontal = 30.dp),
                            textTop = "Telefono de contacto",
                            textBottom = "332 846 1020"
                        )
                        ResumeSelector(
                            modifier = Modifier.padding(horizontal = 30.dp),
                            textTop = "Articulos",
                            textBottom = "3 articulos", lineBottom = false
                        )

                        FlowRow {
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
                                    modifier = Modifier.padding(start = 30.dp, end = 30.dp),
                                    item = item,
                                    counter = false,
                                    deleteOptions = false,
                                    selector = false
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .background(White)
                                .padding(
                                    start = 30.dp, end = 30.dp
                                ),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 15.dp, bottom = 15.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                MediumText(
                                    text = "Descuento de tienda",
                                    color = GrayLetterSeeAll,
                                    size = 13.sp
                                )
                                SemiBoldText(
                                    text = "8%",
                                    color = GrayLetterShipping,
                                    size = 15.sp
                                )
                            }

                            Box(
                                Modifier
                                    .height(1.dp)
                                    .fillMaxWidth()
                                    .background(Color.Gray, shape = DottedShape(step = 20.dp))
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 20.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.Bottom
                            ) {
                                RegularText(
                                    modifier = Modifier.weight(1f),
                                    text = "No pagado",
                                    color = GrayLetterShipping,
                                    size = 18.sp
                                )
                                PriceBeforeDiscount(
                                    modifier = Modifier.width(50.dp),
                                    firstModifier = Modifier.weight(0.5f),
                                    price = 100.0
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

                        }
                    }
                }
            }

        }
        ToolbarTitle(
            modifier = Modifier.layoutId("toolbarTitle"),
            titleText = "Detalles del pedido",
            backClicked = {
                navController?.navigateUp()
            },
            showEndImage = false,
            iconIdRes = R.drawable.ic_coupon,
        )

    }
}