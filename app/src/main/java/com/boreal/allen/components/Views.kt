package com.boreal.allen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.boreal.allen.theme.GrayBorderLight

@Preview
@Composable
fun TestPreview() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        SeparatorHorizontal()
    }
}

@Composable
fun SeparatorHorizontal(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth(),
        constraintSet = buildConstraintSeparatorSet()
    ) {
        Divider(
            modifier = Modifier.layoutId("dividerLeft"),
            color = GrayBorderLight,
            thickness = 1.dp
        )
        Text(
            modifier = Modifier.layoutId("text"), text = "ó",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.W500
        )
        Divider(
            modifier = Modifier
                .layoutId("dividerRight"),
            color = GrayBorderLight,
            thickness = 1.dp
        )
    }
}

fun buildConstraintSeparatorSet(): ConstraintSet {
    return ConstraintSet {
        val left = createRefFor("dividerLeft")
        val text = createRefFor("text")
        val right = createRefFor("dividerRight")
        constrain(left) {
            start.linkTo(parent.start)
            end.linkTo(text.start, margin = 20.dp)
            bottom.linkTo(parent.bottom, margin = 5.dp)
            width = Dimension.fillToConstraints
        }
        constrain(text) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }
        constrain(right) {
            start.linkTo(text.end, margin = 20.dp)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom, margin = 5.dp)
            width = Dimension.fillToConstraints
        }
    }
}

@Composable
fun SeparatorGray(modifier: Modifier = Modifier) {
    Divider(
        modifier = modifier,
        color = GrayBorderLight,
        thickness = 1.dp
    )
}
