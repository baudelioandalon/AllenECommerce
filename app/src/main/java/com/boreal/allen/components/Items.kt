package com.boreal.allen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.boreal.allen.R
import com.boreal.allen.theme.GrayBrandingBackground
import com.boreal.allen.theme.GrayCategoryBackground
import com.boreal.allen.theme.GrayLetterCategoryProduct
import com.boreal.allen.theme.SemiBold

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
fun HomeItem() {
    ConstraintLayout(
        modifier = Modifier
            .padding(start = 30.dp, end = 4.dp)
            .height(240.dp)
            .width(178.dp), constraintSet = ConstraintSet {
            val favSelector = createRefFor("favorite_selector")
            val item = createRefFor("item")
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
                .layoutId("item"), onClick = {},
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
                Image(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .height(130.dp),
                    painter = painterResource(id = R.drawable.tools_icon),
                    contentDescription = "item"
                )
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
        Card(
            modifier = Modifier
                .layoutId("favorite_selector")
                .width(30.dp)
                .height(30.dp),
            elevation = 0.dp,
            shape = CircleShape, onClick = { }) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.ic_favorite_unselected),
                contentDescription = ""
            )
        }

    }
}