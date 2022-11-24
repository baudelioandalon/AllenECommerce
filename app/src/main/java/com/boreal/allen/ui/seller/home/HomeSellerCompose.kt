package com.boreal.allen.ui.seller.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.boreal.allen.domain.enum.SellerOptions
import com.boreal.allen.theme.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Preview
@Composable
fun ViewHomeSellerCompose(
    scaffoldState: ScaffoldState? = null,
    scope: CoroutineScope? = null,
    navController: NavHostController? = null
) {
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(Color.White), constraintSet = ConstraintSet {
        val search = createRefFor("searchHome")
        val content = createRefFor("content")
        val guideLine = createGuidelineFromTop(0.09f)
        constrain(search) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }
        constrain(content) {
            top.linkTo(guideLine)
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
                Card(
                    modifier = Modifier
                        .fillMaxWidth(),
                    elevation = 5.dp
                ) {
                    TopInformationContainer()
                }
            }
            item {
                Card(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .fillMaxWidth(),
                    elevation = 5.dp
                ) {
                    OptionsContainer(navController)
                }
            }

        }

        Card(
            modifier = Modifier
                .layoutId("searchHome")
                .wrapContentSize(),
            elevation = 5.dp
        ) {

            ToolbarSellerStore(
                firstIcon = R.drawable.ic_menu_icon,
                endIcon = R.drawable.ic_dots_options,
                backClicked = {
                    scope?.launch {
                        scaffoldState?.drawerState?.open()
                    }
                }, optionClicked = {

                })
        }
    }
}

@Composable
fun TopInformationContainer(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(start = 30.dp, end = 30.dp, top = 35.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                SemiBoldText(
                    text = "Hola Martina,",
                    size = 30.sp
                )
                Row {
                    MediumText(
                        text = "Ferreteria",
                        color = Color.Black,
                        size = 22.sp
                    )
                    MediumText(
                        modifier = Modifier.padding(start = 10.dp),
                        text = "La Hormiga",
                        color = OrangeStrong,
                        size = 22.sp
                    )
                }
            }
            Card(
                modifier = Modifier
                    .size(68.dp),
                backgroundColor = GrayBackgroundDrawerDismiss,
                elevation = 0.dp,
                shape = RoundedCornerShape(10.dp)
            ) {

            }
        }

        Row(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .background(Color.White)
                .padding(top = 42.dp, bottom = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(3f)
                    .padding(end = 9.dp)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 15.dp),
                    elevation = 0.dp, shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(2.dp, color = GrayBorderLightSeller)
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        SemiBoldText(
                            text = "Mi tienda"
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            StatusStore()
                            Column {
                                BoldText(
                                    text = "$51",
                                    size = 15.sp
                                )
                                MediumText(
                                    text = "3 ventas",
                                    color = GrayStrong,
                                    size = 12.sp
                                )
                            }
                        }
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = GrayBorderLight,
                            thickness = 1.dp
                        )
                        ItemSold()
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = GrayBorderLight,
                            thickness = 1.dp
                        )
                        ItemSold()
                        GrayButton(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Mostrar detalles"
                        )
                    }
                }
            }
            Column(modifier = Modifier.weight(2f)) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f)
                        .padding(bottom = 15.dp),
                    elevation = 0.dp, shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(2.dp, color = GrayBorderLightSeller)
                ) {
                    Column() {
                        SemiBoldText(
                            modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                            text = "Direccion",
                            size = 15.sp
                        )
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(2f)
                                .padding(start = 10.dp, end = 10.dp, bottom = 11.dp, top = 15.dp),
                            backgroundColor = GrayBackgroundDrawerDismiss,
                            elevation = 0.dp,
                            shape = RoundedCornerShape(10.dp)
                        ) {

                        }
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f)
                        .padding(bottom = 15.dp),
                    elevation = 0.dp, shape = RoundedCornerShape(10.dp),
                    backgroundColor = Color.Black
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.padding(10.dp)
                    ) {
                        SemiBoldText(
                            text = "Tus ganancias",
                            color = Color.White,
                            size = 15.sp
                        )
                        Row(
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            MediumText(
                                modifier = Modifier.padding(top = 2.dp),
                                text = "$",
                                color = GrayHomeSellerLetter
                            )
                            MediumText(
                                text = "834.72",
                                color = Color.White,
                                size = 28.sp
                            )
                        }
                    }
                }
            }

        }

    }
}

@Preview
@Composable
fun OptionsContainer(navController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MediumTextBold(
                modifier = Modifier.padding(start = 30.dp, top = 20.dp),
                text = "Opciones"
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
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 30.dp,
                    bottom = 35.dp
                )
        ) {
            val list = SellerOptions.values()
            itemsIndexed(items = list) { index, item ->
                OptionItem(item, list.lastIndex == index)
            }
        }
    }
}

@Composable
fun OptionItem(item: SellerOptions, lastIndex: Boolean = false) {
    Card(
        modifier = Modifier
            .fillMaxWidth(0.4f)
            .height(130.dp)
            .padding(start = 30.dp, end = if (lastIndex) 30.dp else 0.dp),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                BoldText(
                    modifier = Modifier.padding(bottom = 10.dp, top = 20.dp),
                    text = item.title,
                    size = 12.sp
                )
                SemiBoldText(
                    modifier = Modifier.padding(bottom = 10.dp),
                    text = item.subtitle,
                    color = GrayStrong,
                    size = 11.sp
                )
                Selector(
                    modifier = Modifier.padding(bottom = 10.dp),
                    backgroundColor = GreenTransparent,
                    text = "Agregar",
                    textColor = GreenStrong
                )
            }
            Image(
                modifier = Modifier
                    .width(80.dp)
                    .fillMaxHeight(), contentScale = ContentScale.FillHeight,
                painter = painterResource(id = item.img),
                contentDescription = "new product"
            )
        }
    }
}