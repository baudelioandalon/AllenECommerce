package com.boreal.allen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.boreal.allen.R
import com.boreal.allen.domain.model.ItemCartModel
import com.boreal.allen.domain.model.ItemShoppingModel
import com.boreal.allen.domain.model.ProductShoppingCart
import com.boreal.allen.extensions.mirror
import com.boreal.allen.theme.*
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowRow

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
//        QuestionItem()
        ProductResultItem()
        BrandingHorizontal()
        AnswerItem()
        ShoppingCategoryHistoryItem()
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
fun BrandingItem(itemSize: Dp = 60.dp) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 30.dp, end = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .size(itemSize), onClick = {},
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
fun SellerItem(
    onClicked: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp, start = 30.dp, end = 30.dp)
        ) {
            BoldText(text = "Vendedor", size = 18.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 35.dp, top = 22.dp)
                    .wrapContentHeight()
                    .clickable { onClicked?.invoke() },
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductResultItem(
    modifier: Modifier = Modifier,
    productClicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        onClick = { productClicked?.invoke() },
        elevation = 0.dp,
        shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp),
        backgroundColor = White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = GrayBackgroundDrawerDismiss,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .height(200.dp)
            ) {
                FavoriteButton(modifier = Modifier.padding(start = 7.dp, top = 7.dp))
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = painterResource(id = R.drawable.tools_icon),
                    contentDescription = "item"
                )
            }

            Row {
                SemiBoldText(
                    modifier = Modifier
                        .weight(1f),
                    text = "Sensor Hc-sr04", align = TextAlign.Start,
                    size = 13.sp
                )
                BoldText(
                    modifier = Modifier
                        .wrapContentSize(),
                    text = "$54",
                    size = 14.sp
                )
            }

            CategoryProductText(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Electronica",
                color = GrayLetterCategoryProduct,
                align = TextAlign.Start
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Icon(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.ic_thunder_icon),
                    contentDescription = "free shipping",
                    tint = StarColor
                )
                MinimumAddButton(modifier = Modifier.padding(bottom = 10.dp))
            }
        }
    }
}

@Composable
fun BrandingHorizontal(
    modifier: Modifier = Modifier,
    itemSize: Dp = 60.dp
) {
    LazyRow(
        modifier = modifier
    ) {
        items(10) {
            BrandingItem(itemSize)
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
fun ShowSellerItem(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
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
                .fillMaxWidth()
        ) {
            MediumText(
                text = "Para",
                color = GrayLetterSeeAll,
                size = 15.sp
            )
            BoldText(text = "Casa y Hogar", size = 15.sp)
        }
    }
}

@Composable
fun CategorySeller(
    modifier: Modifier = Modifier,
    innerModifier: Modifier = Modifier,
    onClicked: (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(White)
            .clickable {
                onClicked?.invoke()
            },
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = innerModifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 30.dp
                    )
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
            LazyRow(
                modifier = Modifier
                    .background(White)
                    .fillMaxWidth()
                    .padding(top = 36.dp)
            ) {
                items(10) {
                    ProductItem()
                }
            }
        }
    }

}

@Composable
fun SellersItem(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
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

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QuestionItem(
    text: String = "", answerList: List<String> = emptyList(),
    likesList: List<String> = emptyList()
) {
    Row(
        modifier = Modifier
            .background(White)
            .padding(start = 30.dp, end = 30.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 9.dp)
                .size(41.dp), onClick = {},
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
                    painter = painterResource(id = R.drawable.tools_icon),
                    contentDescription = "item"
                )
            }
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SemiBoldText(
                    modifier = Modifier.padding(start = 28.dp, bottom = 30.dp),
                    text = text,
                    size = 17.sp
                )
                FavoriteCounterButton(amount = likesList.size)
            }
            FlowColumn {
                answerList.forEach {
                    AnswerItem(text = it)
                }
            }
        }


    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RatingByUserItem(
    text: String = "",
    likesList: List<String> = emptyList()
) {
    Row(
        modifier = Modifier
            .background(White)
            .padding(start = 30.dp, end = 30.dp, bottom = 25.dp)
            .fillMaxSize(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 9.dp)
                .size(41.dp), onClick = {},
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
                    painter = painterResource(id = R.drawable.tools_icon),
                    contentDescription = "item"
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                SemiBoldText(
                    modifier = Modifier.padding(start = 28.dp, bottom = 20.dp),
                    text = text,
                    size = 17.sp
                )
                StarRatingSelector(
                    modifier = Modifier.padding(start = 28.dp)
                )
            }
            FavoriteCounterButton(amount = likesList.size)
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnswerItem(text: String = "") {
    Row(
        modifier = Modifier
            .padding(start = 30.dp, end = 4.dp, bottom = 35.dp)
            .sizeIn(maxWidth = 200.dp)
            .background(White),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        Card(
            modifier = Modifier
                .padding(bottom = 9.dp)
                .size(30.dp), onClick = {},
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
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.tools_icon),
                    contentDescription = "item"
                )
            }
        }

        SemiBoldText(
            modifier = Modifier
                .padding(start = 28.dp),
            text = text,
            align = TextAlign.Justify,
            size = 17.sp, color = PrimaryColor
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun ShoppingCartStoreItem(
    modifier: Modifier = Modifier,
    item: ItemCartModel = ItemCartModel(
        "Test",
        "3e23dc2",
        "dd", listOf()
    ),
    counter: Boolean = true,
    deleteOptions: Boolean = true,
    selector: Boolean = true,
    elevation: Dp = 0.dp,
    hideTopLine: Boolean = false,
    bottomSeparator: Boolean = false
) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = elevation
    ) {

        val showItems = rememberSaveable { mutableStateOf(true) }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(White)
        ) {
            if (!hideTopLine) {
                Divider(
                    thickness = 1.5.dp,
                    color = GrayBorderLight
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 14.dp, end = if (deleteOptions) 30.dp else 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                if (selector) {
                    RadioButton(
                        selected = false,
                        onClick = { },
                        colors = RadioButtonDefaults.colors(
                            unselectedColor = GrayLetterHint,
                            selectedColor = PrimaryColor
                        )
                    )
                }

                Card(
                    modifier = Modifier
                        .size(30.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }
                BoldText(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(start = 6.dp, end = 10.dp),
                    text = item.nameStore,
                    size = 15.sp,
                    textOverflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                SemiBoldText(
                    modifier = Modifier.padding(end = 23.dp),
                    text = "${item.listItems.size} articulos",
                    color = GrayMedium,
                    size = 13.sp
                )
                Card(
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp),
                    elevation = 0.dp,
                    shape = CircleShape, onClick = { showItems.value = !showItems.value }) {
                    Image(
                        modifier = Modifier
                            .wrapContentSize()
                            .rotate(if (showItems.value) 0f else 180f),
                        painter = painterResource(id = R.drawable.ic_arrow_down),
                        contentDescription = "arrow"
                    )
                }

            }
            if (showItems.value) {
                Divider(
                    thickness = 1.5.dp,
                    color = GrayBorderLight
                )
            }
            if (showItems.value) {
                FlowRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    item.listItems.forEach {
                        ShoppingCartItem(
                            productShoppingCart = it,
                            counter = counter,
                            deleteOptions = deleteOptions
                        )
                    }
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun ShoppingCartItem(
    productShoppingCart: ProductShoppingCart = ProductShoppingCart(
        skuProduct = "d2d232",
        nameProduct = "Balon Basketball num 6edcwedwedwedcedwcef",
        imgProduct = "ccdcdomd",
        categoryItem = "Deportes",
        quantity = 2,
        discountPercentage = 10.0,
        fastOrder = true,
        minimalFastOrder = 2,
        price = 588880.0
    ),
    counter: Boolean = true,
    deleteOptions: Boolean = true
) {
    Column(
        modifier = if (deleteOptions)
            Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 14.dp, bottom = 20.dp)
        else Modifier
            .fillMaxWidth()
            .padding(top = 14.dp, bottom = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                Card(
                    modifier = Modifier
                        .size(81.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }

            }
            Column(
                modifier = Modifier
                    .height(81.dp)
                    .padding(start = 27.dp)
                    .weight(0.3f),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                SemiBoldText(
                    text = productShoppingCart.nameProduct,
                    size = 13.sp,
                    maxLines = 3,
                    textOverflow = TextOverflow.Ellipsis
                )
                SemiBoldText(
                    modifier = Modifier.wrapContentHeight(),
                    text = productShoppingCart.categoryItem,
                    color = GrayLetterCategoryProduct,
                    size = 10.sp
                )
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.End
                ) {
                    if (productShoppingCart.discountPercentage > 0) {
                        PriceBeforeDiscount(
                            modifier = Modifier.weight(0.3f),
                            price = productShoppingCart.price
                        )
                    }
                    BoldText(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        text = "$${productShoppingCart.getProductWithDiscount().toInt()}",
                        size = 15.sp, align = TextAlign.End
                    )
                }
            }
            Column(
                modifier = Modifier
                    .height(81.dp)
                    .weight(0.3f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    if (productShoppingCart.discountPercentage > 0) {
                        Discount(
                            modifier = Modifier.padding(start = 10.dp),
                            discount = productShoppingCart.discountPercentage.toInt()
                        )
                    } else {
                        Spacer(modifier = Modifier.padding(start = 10.dp))
                    }
                    if (productShoppingCart.fastOrder) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_thunder_icon),
                            contentDescription = "free shipping",
                            tint = StarColor
                        )
                    }
                }
                if (counter) {
                    SelectorCounter(
                        quantity = productShoppingCart.quantity
                    )
                } else {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ) {
                        SemiBoldText(
                            modifier = Modifier.padding(end = 34.dp, bottom = 5.dp),
                            text = "Cantidad", size = 15.sp
                        )
                        SemiBoldText(
                            text = "${productShoppingCart.quantity}",
                            size = 25.sp
                        )
                    }
                }
            }
        }
        if (deleteOptions) {
            Row(modifier = Modifier.padding(top = 12.dp)) {
                BoldText(
                    text = "Remover",
                    size = 12.sp,
                    color = OrangeStrong
                ) {

                }
                BoldText(
                    modifier = Modifier.padding(start = 38.dp),
                    text = "Guardar para después",
                    size = 12.sp,
                    color = OrangeStrong
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteItem(
    productShoppingCart: ProductShoppingCart = ProductShoppingCart(
        skuProduct = "d2d232",
        nameProduct = "Balon Basketball num 6edcwedwedwedcedwcef",
        imgProduct = "ccdcdomd",
        categoryItem = "Deportes",
        quantity = 1,
        discountPercentage = 10.0,
        fastOrder = true,
        minimalFastOrder = 2,
        price = 588880.0
    )
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 10.dp
    ) {
        Column(
            modifier =
            Modifier
                .fillMaxWidth()
                .background(White)
                .padding(start = 30.dp, end = 30.dp, top = 14.dp, bottom = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    modifier = Modifier.wrapContentWidth()
                ) {
                    Card(
                        modifier = Modifier
                            .size(81.dp),
                        backgroundColor = GrayBackgroundDrawerDismiss,
                        elevation = 0.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {

                    }

                }
                Column(
                    modifier = Modifier
                        .height(81.dp)
                        .padding(start = 27.dp)
                        .weight(0.3f),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    SemiBoldText(
                        text = productShoppingCart.nameProduct,
                        size = 13.sp,
                        maxLines = 3,
                        textOverflow = TextOverflow.Ellipsis
                    )
                    SemiBoldText(
                        modifier = Modifier.wrapContentHeight(),
                        text = productShoppingCart.categoryItem,
                        color = GrayLetterCategoryProduct,
                        size = 10.sp
                    )
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.End
                    ) {
                        if (productShoppingCart.discountPercentage > 0) {
                            PriceBeforeDiscount(
                                modifier = Modifier.weight(0.3f),
                                price = productShoppingCart.price
                            )
                        }
                        BoldText(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            text = "$${productShoppingCart.getProductWithDiscount().toInt()}",
                            size = 15.sp, align = TextAlign.End
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .height(81.dp)
                        .weight(0.3f),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        if (productShoppingCart.discountPercentage > 0) {
                            Discount(
                                modifier = Modifier.padding(start = 10.dp),
                                discount = productShoppingCart.discountPercentage.toInt()
                            )
                        } else {
                            Spacer(modifier = Modifier.padding(start = 10.dp))
                        }
                        if (productShoppingCart.fastOrder) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_thunder_icon),
                                contentDescription = "free shipping",
                                tint = StarColor
                            )
                        }
                    }
                }
            }
            Row(modifier = Modifier.padding(top = 12.dp)) {
                BoldText(
                    text = "Remover",
                    size = 12.sp,
                    color = OrangeStrong
                ) {

                }
                BoldText(
                    modifier = Modifier.padding(start = 38.dp),
                    text = "Guardar para después",
                    size = 12.sp,
                    color = OrangeStrong
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationItem(
    step: Int = 0,
    default: Boolean = true,
    shippingType: String = "SHIPPING",
    shippingStatus: String = "OK"
) {
    Column(
        modifier =
        Modifier
            .fillMaxWidth()
            .background(White)
            .padding(start = 30.dp, end = 30.dp, top = 14.dp, bottom = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                Card(
                    modifier = Modifier
                        .size(81.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }

            }
            if (default) {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(start = 22.dp)
                        .fillMaxWidth()
                        .background(White),
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SemiBoldText(
                            text = "Recibido el 1 de septiembre",
                            size = 15.sp,
                            maxLines = 3,
                            textOverflow = TextOverflow.Ellipsis
                        )
                        Image(
                            modifier = Modifier.mirror(),
                            painter = painterResource(id = R.drawable.ic_on_way_traffic_circle),
                            contentDescription = "on way"
                        )
                    }
                    SemiBoldText(
                        modifier = Modifier.wrapContentHeight(),
                        text = "Camiseta",
                        color = GrayLetterCategoryProduct,
                        size = 10.sp
                    )

                    StepIndicatorNotification(
                        modifier = Modifier.padding(top = 20.dp),
                        step = step
                    )
                    BoldText(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "Calificar",
                        size = 12.sp,
                        color = OrangeStrong
                    ) {

                    }
                }
            } else {
                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(start = 22.dp)
                        .fillMaxWidth()
                        .background(White),
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SemiBoldText(
                            text = if (shippingType == "SHIPPING" && shippingStatus == "OK") "Preparando pedido" else if (
                                shippingType == "PICKUP" && shippingStatus == "OK"
                            ) "Pedido listo" else if (shippingStatus == "CANCELLED_BY_SELLER") "Cancelado por el vendedor" else "Cancelado por el cliente",
                            size = 15.sp,
                            maxLines = 3,
                            textOverflow = TextOverflow.Ellipsis
                        )
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 7.dp)
                            .background(
                                brush = Brush.horizontalGradient(
                                    colors = if (shippingStatus == "OK") listOf(
                                        PrimaryColor,
                                        PrimaryEndColor
                                    ) else listOf(
                                        RedStartColor,
                                        RedEndColor
                                    )
                                ),
                                shape = RoundedCornerShape(10.dp)
                            )
                    ) {
                        Row(
                            modifier = Modifier.padding(vertical = 9.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .padding(horizontal = 16.dp),
                                painter = painterResource(id = if (shippingType == "PICKUP") R.drawable.ic_on_way_walking else R.drawable.ic_on_way_traffic),
                                contentDescription = "on way",
                                tint = White
                            )
                            Column(modifier = Modifier.wrapContentWidth()) {
                                MediumText(
                                    text = if (shippingType == "SHIPPING" && shippingStatus == "OK") "Preparando pedido" else if (
                                        shippingType == "PICKUP" && shippingStatus == "OK"
                                    ) "Pedido listo" else "Pedido cancelado",
                                    color = White,
                                    size = 15.sp
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    MediumText(
                                        text = if (shippingType == "SHIPPING") "Enviar" else "Recolectar",
                                        color = White,
                                        size = 12.sp
                                    )
                                    MediumText(
                                        modifier = Modifier.padding(end = 20.dp),
                                        text = "Ene 8, 9:30 am",
                                        color = White,
                                        size = 12.sp
                                    )
                                }
                            }
                        }
                    }
                    BoldText(
                        modifier = Modifier.padding(top = 10.dp),
                        text = "Contactar",
                        size = 12.sp,
                        color = OrangeStrong
                    ) {

                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StatusPackageItem(
    step: Int = 0,
    default: Boolean = true,
    shippingType: String = "SHIPPING",
    shippingStatus: String = "OK"
) {
    if (default) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(start = 22.dp)
                .fillMaxWidth()
                .background(White),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SemiBoldText(
                    text = "Recibido el 1 de septiembre",
                    size = 15.sp,
                    maxLines = 3,
                    textOverflow = TextOverflow.Ellipsis
                )
                Image(
                    modifier = Modifier.mirror(),
                    painter = painterResource(id = R.drawable.ic_on_way_traffic_circle),
                    contentDescription = "on way"
                )
            }
            SemiBoldText(
                modifier = Modifier.wrapContentHeight(),
                text = "Camiseta",
                color = GrayLetterCategoryProduct,
                size = 10.sp
            )

            StepIndicatorNotification(
                modifier = Modifier.padding(top = 20.dp),
                step = step
            )
            BoldText(
                modifier = Modifier.padding(top = 10.dp),
                text = "Calificar",
                size = 12.sp,
                color = OrangeStrong
            ) {

            }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = if (shippingStatus == "OK") listOf(
                            PrimaryColor,
                            PrimaryEndColor
                        ) else listOf(
                            RedStartColor,
                            RedEndColor
                        )
                    ),
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Row(
                modifier = Modifier.padding(vertical = 9.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(horizontal = 16.dp),
                    painter = painterResource(id = if (shippingType == "PICKUP") R.drawable.ic_on_way_walking else R.drawable.ic_on_way_traffic),
                    contentDescription = "on way",
                    tint = White
                )
                Column(modifier = Modifier.wrapContentWidth()) {
                    MediumText(
                        text = if (shippingType == "SHIPPING" && shippingStatus == "OK") "Preparando pedido" else if (
                            shippingType == "PICKUP" && shippingStatus == "OK"
                        ) "Pedido listo" else "Pedido cancelado",
                        color = White,
                        size = 15.sp
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        MediumText(
                            text = if (shippingType == "SHIPPING") "Enviar" else "Recolectar",
                            color = White,
                            size = 12.sp
                        )
                        MediumText(
                            modifier = Modifier.padding(end = 20.dp),
                            text = "Ene 8, 9:30 am",
                            color = White,
                            size = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StepIndicatorNotification(
    modifier: Modifier = Modifier,
    step: Int = 0,
    messageOne: String = "19/11/23",
    messageTwo: String = "20/11/23",
    messageThree: String = "21/11/23"
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BoldText(
                text = messageOne,
                size = 12.sp
            )
            BoldText(
                text = messageTwo,
                size = 12.sp
            )
            BoldText(
                text = messageThree,
                size = 12.sp
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Divider(
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .weight(0.5f),
                    color = if (step > 0) PrimaryColor else GrayBackgroundDrawerDismiss,
                    thickness = 7.dp
                )
                Divider(
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .weight(0.5f),
                    color = if (step > 3) PrimaryColor else GrayBackgroundDrawerDismiss,
                    thickness = 7.dp
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_circle),
                    contentDescription = "on way",
                    tint = if (step >= 0) PrimaryColor else GrayBackgroundDrawerDismiss
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_circle),
                    contentDescription = "on way",
                    tint = if (step > 2) PrimaryColor else GrayBackgroundDrawerDismiss
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_circle),
                    contentDescription = "on way",
                    tint = if (step > 4) PrimaryColor else GrayBackgroundDrawerDismiss
                )
            }
        }
    }

}

@Composable
fun ShoppingCategoryHistoryItem(
    modifier: Modifier = Modifier,
    item: ItemShoppingModel = ItemShoppingModel(
        nameStore = "Ferreteria La hormiga",
        idStore = "d2d232",
        imgStore = "dddd",
        idSale = "dwed342",
        price = 46.0,
        status = "RECEIVED",
        giftStatus = "AVAILABLE",
        apologyStatus = "NONE",
        canceledBy = "NONE",
        numberProducts = 1
    ),
    counter: Boolean = true,
    deleteOptions: Boolean = true,
    selector: Boolean = true,
    elevation: Dp = 0.dp,
    hideTopLine: Boolean = false,
    onClicked: (() -> Unit)? = null
) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = elevation
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(White)
        ) {
            if (!hideTopLine) {
                Divider(
                    thickness = 1.5.dp,
                    color = GrayBorderLight
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 14.dp, end = if (deleteOptions) 30.dp else 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                if (selector) {
                    RadioButton(
                        selected = false,
                        onClick = { },
                        colors = RadioButtonDefaults.colors(
                            unselectedColor = GrayLetterHint,
                            selectedColor = PrimaryColor
                        )
                    )
                }

                Card(
                    modifier = Modifier
                        .size(30.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }
                BoldText(
                    modifier = Modifier
                        .weight(0.5f)
                        .padding(start = 6.dp, end = 10.dp),
                    text = item.nameStore,
                    size = 15.sp,
                    textOverflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
                SemiBoldText(
                    modifier = Modifier.padding(end = 23.dp),
                    text = "${item.numberProducts} articulos",
                    color = GrayMedium,
                    size = 13.sp
                )

            }
            Divider(
                thickness = 1.5.dp,
                color = GrayBorderLight
            )
            ShoppingHistoryItem(
                counter = counter,
                deleteOptions = deleteOptions,
                historyModel = item
            ) {
                onClicked?.invoke()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingHistoryItem(
    historyModel: ItemShoppingModel = ItemShoppingModel(
        nameStore = "Ferreteria La hormiga",
        idStore = "d2d232",
        imgStore = "dddd",
        idSale = "dwed342",
        price = 46.0,
        status = "RECEIVED",
        giftStatus = "AVAILABLE",
        apologyStatus = "NONE",
        canceledBy = "NONE",
        numberProducts = 1
    ),
    counter: Boolean = true,
    deleteOptions: Boolean = true,
    onClicked: (() -> Unit)? = null
) {
    Column(
        modifier = if (deleteOptions)
            Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 14.dp, bottom = 20.dp)
        else Modifier
            .fillMaxWidth()
            .padding(top = 14.dp, bottom = 20.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .clickable { onClicked?.invoke() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.wrapContentWidth()
            ) {
                Card(
                    modifier = Modifier
                        .size(81.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }

            }
            Column(
                modifier = Modifier
                    .height(100.dp)
                    .padding(start = 27.dp)
                    .weight(0.3f),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                SemiBoldText(
                    text = if (historyModel.status == "WAITING_CLIENT") "Esperando" else "Orden",
                    size = 15.sp,
                    maxLines = 2,
                    textOverflow = TextOverflow.Ellipsis
                )
                SemiBoldText(
                    text = when (historyModel.status) {
                        "CANCELED" -> {
                            "cancelada"
                        }
                        "RUNNING" -> {
                            "en camino"
                        }
                        "WAITING_CLIENT" -> {
                            "al cliente"
                        }
                        "WAITING_SELLER" -> {
                            "en proceso"
                        }
                        else -> {
                            "confirmada"
                        }
                    },
                    size = 15.sp,
                    maxLines = 2,
                    color = when (historyModel.status) {
                        "CANCELED" -> {
                            Red
                        }
                        else -> {
                            Black
                        }
                    },
                    textOverflow = TextOverflow.Ellipsis
                )
                SemiBoldText(
                    modifier = Modifier.wrapContentHeight(),
                    text = "$${historyModel.price}",
                    color = Black,
                    size = 15.sp
                )

                SemiBoldText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    text = "12/08/2023 a las 09:41 am",
                    color = GrayLetterCategoryProduct,
                    size = 12.sp,
                    maxLines = 2,
                    textOverflow = TextOverflow.Ellipsis,
                    align = TextAlign.Start
                )

            }
            Column(
                modifier = Modifier
                    .height(81.dp)
                    .weight(0.3f),
                verticalArrangement = if (historyModel.giftStatus != "NONE") Arrangement.Center else Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                if (historyModel.status == "RUNNING" || historyModel.status == "WAITING_SELLER" ||
                    historyModel.status == "WAITING_CLIENT"
                ) {
                    Card(
                        modifier = Modifier
                            .size(81.dp),
                        backgroundColor = GrayBackgroundDrawerDismiss,
                        elevation = 0.dp,
                        shape = RoundedCornerShape(10.dp)
                    ) {

                    }
                } else {
                    if (historyModel.canceledBy != "NONE") {
                        GrayButton(
                            text = when (historyModel.canceledBy) {
                                "CLIENT" -> {
                                    "Disculpas"
                                }
                                else -> {
                                    "Calificar"
                                }
                            }
                        )
                    }

                    when (historyModel.giftStatus) {
                        "NONE" -> {

                        }
                        "TAKEN" -> {
                            Row(
                                modifier = Modifier.wrapContentWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.Bottom
                            ) {
                                SemiBoldText(
                                    modifier = Modifier
                                        .padding(end = 10.dp)
                                        .alpha(0.39f),
                                    text = "Recolectado",
                                    color = GrayMedium,
                                    size = 12.sp
                                )
                                Image(
                                    modifier = Modifier
                                        .size(25.dp)
                                        .alpha(0.39f),
                                    painter = painterResource(id = R.drawable.ic_gift),
                                    contentDescription = "gift"
                                )
                            }
                        }
                        else -> {
                            Row(
                                modifier = Modifier.wrapContentWidth(),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.Bottom
                            ) {
                                SemiBoldText(
                                    modifier = Modifier.padding(end = 10.dp),
                                    text = "Recolectar regalo",
                                    color = PrimaryColor,
                                    size = 12.sp
                                )
                                Image(
                                    modifier = Modifier.size(25.dp),
                                    painter = painterResource(id = R.drawable.ic_gift),
                                    contentDescription = "gift"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}