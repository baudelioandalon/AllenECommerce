package com.boreal.allen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.allen.R
import com.boreal.allen.theme.GreenStrong
import com.boreal.allen.theme.GreenTransparent
import com.boreal.allen.theme.OrangeMedium
import com.boreal.allen.theme.OrangeTransparent

@Composable
fun FreeShipping(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(
                color = GreenStrong,
                shape = RoundedCornerShape(5.dp)
            )
            .wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BoldText(
            modifier = Modifier
                .padding(start = 10.dp, top = 5.dp, bottom = 5.dp)
                .wrapContentSize(),
            text = "Envio gratis",
            size = 10.sp,
            color = White
        )
        Icon(
            modifier = Modifier.padding(start = 4.dp, end = 6.dp),
            painter = painterResource(id = R.drawable.ic_thunder_icon),
            contentDescription = "free shipping",
            tint = White
        )
    }
}

@Composable
fun StatusStore(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(
                color = GreenStrong,
                shape = RoundedCornerShape(20.dp)
            )
            .wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        BoldText(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 5.dp)
                .wrapContentSize(),
            text = "Abierto",
            size = 10.sp,
            color = White
        )
    }
}

@Composable
fun Discount(modifier: Modifier = Modifier, discount: Int = 15) {
    BoldText(
        modifier = modifier
            .padding(top = 5.dp, bottom = 5.dp)
            .wrapContentSize()
            .background(
                color = GreenStrong,
                shape = RoundedCornerShape(corner = CornerSize(15.dp))
            ),
        text = "   $discount%   ",
        size = 12.sp,
        color = White
    )
}

@Preview
@Composable
fun PriceBeforeDiscount(
    modifier: Modifier = Modifier,
    firstModifier: Modifier = Modifier,
    price: Double = 50.0
) {

    Box(modifier = firstModifier) {
        BoldText(
            modifier = modifier
                .wrapContentWidth()
                .align(Alignment.Center),
            text = "$${price.toInt()}",
            color = OrangeTransparent,
            size = 15.sp
        )
        Canvas(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .align(Alignment.Center)
        ) {
            var yCord = 0f
            drawLine(
                OrangeMedium,
                Offset(0f, yCord),
                Offset(size.width, yCord),
                strokeWidth = 3f
            )
            yCord += 1.8f * 15.toDp().toPx()
        }


    }
}

@Preview
@Composable
fun Selector(
    modifier: Modifier = Modifier,
    text: String = "",
    backgroundColor: Color = GreenTransparent,
    textColor: Color = GreenStrong,
    roundDp: Dp = 10.dp,
    onClicked: (() -> Unit)? = {}
) {
    Row(
        modifier = if (onClicked != null) {
            modifier
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(roundDp)
                )
                .wrapContentSize()
                .clickable { onClicked() }
        } else {
            modifier
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(roundDp)
                )
                .wrapContentSize()
        },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        SemiBoldText(
            modifier = Modifier
                .padding(start = 17.dp, end = 17.dp, top = 5.dp, bottom = 5.dp)
                .wrapContentSize(),
            text = text,
            size = 13.sp,
            color = textColor
        )
    }
}

