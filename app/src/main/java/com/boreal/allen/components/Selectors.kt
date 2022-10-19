package com.boreal.allen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.allen.R
import com.boreal.allen.theme.GrayLetterArrow
import com.boreal.allen.theme.GreenStrong

@Preview(showBackground = true)
@Composable
fun TestSelectors() {
    Column(modifier = Modifier.fillMaxSize()) {
        SelectorCounter()
        SelectorDetail(
            text = "Detalles del producto",
            iconRes = R.drawable.ic_detail_icon
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectorCounter(
    lessClicked: (() -> Unit)? = null,
    moreClicked: (() -> Unit)? = null
) {
    Row(modifier = Modifier.wrapContentSize()) {
        Surface(
            modifier = Modifier
                .size(35.dp),
            color = Color.White,
            border = BorderStroke(
                width = 1.dp,
                color = GreenStrong
            ),
            shape = RoundedCornerShape(5.dp),
            onClick = { lessClicked?.invoke() }
        ) {
            Icon(
                modifier = Modifier.padding(13.dp),
                painter = painterResource(id = R.drawable.ic_less_icon),
                contentDescription = "less_icon",
                tint = GreenStrong
            )
        }
        SemiBoldText(
            modifier = Modifier.padding(horizontal = 22.dp),
            text = "1", size = 25.sp
        )
        Surface(
            modifier = Modifier
                .size(35.dp),
            color = GreenStrong,
            shape = RoundedCornerShape(5.dp),
            onClick = { moreClicked?.invoke() }
        ) {
            Icon(
                modifier = Modifier.padding(12.dp),
                painter = painterResource(id = R.drawable.ic_more_icon),
                contentDescription = "more_icon",
                tint = Color.White
            )
        }
    }
}

@Composable
fun SelectorDetail(
    modifier: Modifier = Modifier, text: String = "",
    @DrawableRes iconRes: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.White)
            .padding(horizontal = 30.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "comment icon"
        )
        BoldText(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            text = text, size = 13.sp
        )
        Icon(
            modifier = Modifier
                .rotate(180f)
                .width(21.dp)
                .height(12.dp),
            tint = GrayLetterArrow,
            painter = painterResource(id = R.drawable.ic_right_arrow_simbol),
            contentDescription = "comment icon"
        )
    }
}