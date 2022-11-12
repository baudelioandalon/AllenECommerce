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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.boreal.allen.R
import com.boreal.allen.domain.model.ItemCartModel
import com.boreal.allen.domain.model.ProductShoppingCart
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
            BoldText(text = "Vendedor", size = 18.sp)
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
fun SellersItem(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(top = 30.dp, bottom = 100.dp)
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
@Preview
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

@Preview(showBackground = true)
@Composable
fun ShoppingCartStoreItem(
    item: ItemCartModel = ItemCartModel(
        "Test",
        "3e23dc2", "dd", listOf()
    ), counter: Boolean = true,
    deleteOptions: Boolean = true,
    selector: Boolean = true
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp),
        elevation = 5.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 14.dp),
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
                    modifier = if (selector) Modifier
                        .size(30.dp) else Modifier
                        .padding(start = 30.dp)
                        .size(30.dp),
                    backgroundColor = GrayBackgroundDrawerDismiss,
                    elevation = 0.dp,
                    shape = RoundedCornerShape(10.dp)
                ) {

                }
                BoldText(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 6.dp),
                    text = item.nameStore,
                    size = 15.sp
                )
                SemiBoldText(
                    modifier = Modifier.padding(end = 23.dp),
                    text = "${item.listItems.size} articulos",
                    color = GrayMedium,
                    size = 13.sp
                )
                Icon(
                    modifier = Modifier
                        .padding(end = 30.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_down),
                    contentDescription = "arrow"
                )

            }
            Divider(
                thickness = 1.5.dp,
                color = GrayBorderLight
            )
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
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, top = 14.dp, bottom = 10.dp)
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