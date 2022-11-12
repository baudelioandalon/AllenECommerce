package com.boreal.allen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.boreal.allen.R
import com.boreal.allen.theme.GrayBackgroundDrawerDismiss
import com.boreal.allen.theme.GrayStrong
import com.boreal.allen.theme.OrangeStrong
import com.boreal.allen.theme.OrangeTransparentLow

@Preview(showBackground = true)
@Composable
fun PreviewIcons() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        LocationIcon()
        GoalIcon()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun LocationIcon(onClick: (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .size(52.dp)
            .background(
                alpha = 0.5f,
                brush = Brush.radialGradient(
                    colors = listOf(
                        OrangeStrong,
                        OrangeTransparentLow
                    )
                ), shape = RoundedCornerShape(30.dp)
            )
            .padding(bottom = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier
                .size(40.dp)
                .background(Color.Transparent),
            backgroundColor = OrangeStrong, elevation = 0.dp,
            onClick = { onClick?.invoke() }
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    modifier = Modifier.size(15.dp),
                    imageVector = ImageVector.Companion.vectorResource(id = R.drawable.ic_location),
                    contentDescription = "moreIcon",
                    tint = White
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun GoalIcon(onClick: (() -> Unit)? = null) {
    Card(
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier.padding(start = 5.dp)
            .size(40.dp)
            .background(Color.Transparent),
        backgroundColor = GrayBackgroundDrawerDismiss, elevation = 0.dp,
        onClick = { onClick?.invoke() }
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                modifier = Modifier.size(15.dp),
                imageVector = ImageVector.Companion.vectorResource(id = R.drawable.ic_goal),
                contentDescription = "moreIcon",
                tint = GrayStrong
            )
        }
    }
}