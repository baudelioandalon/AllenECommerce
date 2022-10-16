package com.boreal.allen.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.allen.R
import com.boreal.allen.theme.GrayBrandingBackground
import com.boreal.allen.theme.GrayCategoryBackground
import com.boreal.allen.theme.SemiBold

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryItem() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 30.dp, end = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
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
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 30.dp, end = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .height(300.dp)
                .width(200.dp), onClick = {},
            elevation = 5.dp,
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            backgroundColor = White
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