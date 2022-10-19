package com.boreal.allen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.allen.R
import com.boreal.allen.theme.GreenStrong

@Composable
fun FreeShipping(modifier: Modifier) {
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