package com.boreal.allen.ui.shoppingcart.resume

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavHostController
import com.boreal.allen.R
import com.boreal.allen.components.*
import com.boreal.allen.domain.model.ItemCartModel
import com.boreal.allen.domain.model.ProductShoppingCart
import com.boreal.allen.extensions.DottedShape
import com.boreal.allen.extensions.drawColoredShadow
import com.boreal.allen.theme.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun ViewResumeCartCompose(navController: NavHostController? = null) {
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
                .background(White)
                .layoutId("listContent")
        ) {

            item {
                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(start = 30.dp, top = 40.dp, bottom = 30.dp),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(horizontalArrangement = Arrangement.Start) {
                        LocationIcon()
                        Column(modifier = Modifier.padding(start = 13.dp)) {
                            MediumText(
                                text = "Desde",
                                color = GraySinceTo,
                                size = 15.sp
                            )
                            MediumText(
                                modifier = Modifier
                                    .width(180.dp)
                                    .wrapContentHeight(),
                                text = "Ferreteria La hormiga",
                                align = TextAlign.Start,
                                color = GrayMedium,
                                size = 15.sp,
                                textOverflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }
                    }
                    Box(
                        Modifier
                            .padding(top = 20.dp)
                            .rotate(90f)
                            .width(50.dp)
                            .height(1.dp)
                            .background(GrayStrong, shape = DottedShape(step = 10.dp))
                    )
                    Row(horizontalArrangement = Arrangement.Start) {
                        GoalIcon()
                        Column(modifier = Modifier.padding(start = 18.dp)) {
                            MediumText(
                                text = "Para",
                                color = GraySinceTo,
                                size = 15.sp
                            )
                            MediumText(
                                modifier = Modifier
                                    .width(180.dp)
                                    .wrapContentHeight(),
                                text = "Calle Miramar #1195, San esteban, Puerto Vallarta, Jalisco",
                                align = TextAlign.Start,
                                color = GrayMedium,
                                size = 15.sp,
                                textOverflow = TextOverflow.Ellipsis,
                                maxLines = 1
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp, bottom = 30.dp)
                        .height(220.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = 0.dp,
                    backgroundColor = GrayBackgroundMain,
                    onClick = {}
                ) {

                }
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
            }
            itemsIndexed(
                listOf(
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
            ) { index, item ->
                ShoppingCartStoreItem(
                    modifier = Modifier.padding(start = 30.dp, end = 30.dp),
                    item = item,
                    counter = false,
                    deleteOptions = false,
                    selector = false
                )
            }
            item {
                Column(
                    modifier = Modifier.padding(
                        start = 30.dp, end = 30.dp,
                        bottom = 18.dp, top = 40.dp
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
                    ShadowButton(
                        modifier = Modifier
                            .padding(bottom = 18.dp, top = 24.dp)
                            .fillMaxWidth()
                            .drawColoredShadow(
                                color = BlueTransparent, alpha = 1f, borderRadius = 10.dp,
                                offsetY = 6.dp, offsetX = 5.dp, blurRadius = 10.dp
                            ),
                        text = "Confirmar mi compra"
                    ) {

                    }
                }
            }
        }
        ToolbarTitle(
            modifier = Modifier.layoutId("toolbarTitle"),
            titleText = "Resumen de compra",
            backClicked = {
                navController?.navigateUp()
            },
            showEndImage = false,
            iconIdRes = R.drawable.ic_coupon,
        )

    }
}