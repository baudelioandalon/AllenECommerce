package com.boreal.allen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.boreal.allen.R
import com.boreal.allen.theme.*

@Preview
@Composable
fun TestItems() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        CategorySeller()
        SellerItemsItem()
        SellerItem()
        CategoryItem()
        CategorySelectorItem()
        BrandingItem()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryItem() {
    Column(
        modifier = Modifier
            .padding(start = 30.dp, end = 4.dp, bottom = 35.dp)
            .wrapContentSize()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .padding(top = 23.dp, bottom = 9.dp)
                .size(74.dp), onClick = {},
            elevation = 0.dp,
            shape = CircleShape,
            backgroundColor = GrayCategoryBackground
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.width(32.dp),
                    painter = painterResource(id = R.drawable.tools_icon),
                    contentDescription = "item"
                )
            }
        }

        Text(
            modifier = Modifier
                .padding(top = 9.dp)
                .fillMaxWidth(),
            text = "Ferreteria",
            fontSize = 13.sp,
            letterSpacing = 0.sp,
            fontWeight = SemiBold
        )
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BrandingItem() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 30.dp, end = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .size(60.dp), onClick = {},
            elevation = 0.dp,
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            backgroundColor = GrayBrandingBackground
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxSize(),
                    painter = painterResource(id = R.drawable.tools_icon),
                    contentDescription = "item"
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategorySelectorItem(
    maxBackground: Boolean = false,
    color: Color = CategoryBackgroundSelectorOne
) {
    ConstraintLayout(
        modifier = Modifier
            .padding(start = 30.dp, end = 4.dp)
            .height(144.dp)
            .width(134.dp), constraintSet = ConstraintSet {
            val background = createRefFor("background")
            val favSelector = createRefFor("favorite_selector")
            val item = createRefFor("item")
            constrain(background) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
            constrain(favSelector) {
                top.linkTo(parent.top, 10.dp)
                start.linkTo(parent.start, 14.dp)
                width = Dimension.wrapContent
                height = Dimension.wrapContent
            }
            constrain(item) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
        }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(if (maxBackground) 144.dp else 76.dp)
                .layoutId("background"),
            shape = RoundedCornerShape(15.dp),
            elevation = 0.dp,
            backgroundColor = color
        ) {

        }
        Card(
            modifier = Modifier
                .layoutId("item"), onClick = {},
            elevation = 0.dp,
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            backgroundColor = Color.Transparent
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .height(80.dp),
                    painter = painterResource(id = R.drawable.laptop_test),
                    contentDescription = "item"
                )
                BoldText(
                    modifier = Modifier
                        .fillMaxWidth(), text = "Laptops", align = TextAlign.Center,
                    size = 15.sp
                )
            }
        }
    }
}

@Composable
fun SellerItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 45.dp)
            .background(White),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 30.dp, end = 30.dp)
        ) {
            BoldText("Vendedor", size = 18.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 35.dp, top = 22.dp)
                    .wrapContentHeight()
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    modifier = Modifier
                        .size(53.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }
                Column(
                    modifier = Modifier
                        .padding(start = 19.dp)
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    BoldText(text = "Ferreteria La Hormiga", size = 15.sp)
                    MediumText(
                        text = "Para Casa y Hogar",
                        color = GrayLetterSeeAll,
                        size = 15.sp
                    )
                }
                RightRoundedButton()
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductItem(productClicked: (() -> Unit)? = null) {
    Card(
        modifier = Modifier
            .padding(start = 30.dp, end = 4.dp)
            .height(240.dp)
            .width(178.dp), onClick = { productClicked?.invoke() },
        elevation = 6.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        backgroundColor = White
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box {
                FavoriteButton()
                Image(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .height(130.dp),
                    painter = painterResource(id = R.drawable.tools_icon),
                    contentDescription = "item"
                )
            }

            NameProductText(
                modifier = Modifier
                    .padding(start = 14.dp)
                    .fillMaxWidth(), text = "Sensor Hc-sr04", align = TextAlign.Start
            )
            CategoryProductText(
                modifier = Modifier
                    .padding(start = 14.dp)
                    .fillMaxWidth(),
                text = "Electronica",
                color = GrayLetterCategoryProduct,
                align = TextAlign.Start
            )

            Row(
                modifier = Modifier
                    .padding(start = 14.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                BoldText(
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .wrapContentSize(),
                    text = "$54"
                )
                LittleAddButton()
            }
        }
    }
}

@Composable
fun SellerItemsItem(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
                .clickable { },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BoldText(
                size = 18.sp,
                modifier = Modifier.padding(top = 20.dp),
                align = TextAlign.Start, text = "Más productos del\nvendedor"
            )
            RightRoundedButton()
        }
        LazyRow(
            modifier = Modifier
                .padding(
                    top = 30.dp,
                    bottom = 35.dp
                )
        ) {
            items(10) {
                ProductItem()
            }
        }
    }

}

@Composable
fun CategorySeller() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 45.dp)
            .background(White),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 30.dp, end = 30.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 35.dp, top = 22.dp)
                    .wrapContentHeight()
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    modifier = Modifier
                        .size(53.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }
                Column(
                    modifier = Modifier
                        .padding(start = 19.dp)
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    MediumText(
                        text = "Para",
                        color = GrayLetterSeeAll,
                        size = 15.sp
                    )
                    BoldText(text = "Casa y Hogar", size = 15.sp)
                }
                RightRoundedButton()
            }
        }
    }
    LazyRow(
        modifier = Modifier
            .background(White)
            .padding(bottom = 35.dp)
    ) {
        items(10) {
            ProductItem()
        }
    }
}

@Composable
fun SellersItem() {
    Column(
        modifier = Modifier
            .padding(top = 30.dp, bottom = 30.dp)
            .fillMaxWidth()
            .background(White)
    ) {
        Row(
            modifier = Modifier
                .padding(end = 30.dp, start = 30.dp, top = 20.dp)
                .fillMaxWidth()
                .clickable { },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MediumTextBold(
                text = "Más vendedores"
            )
            RightRoundedButton()
        }
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