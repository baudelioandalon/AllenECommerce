package com.boreal.allen.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.boreal.allen.R
import com.boreal.allen.theme.GrayBorder
import com.boreal.allen.theme.GrayBorderLight


@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun BackButton(modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {
    Card(
        modifier = modifier
            .width(35.dp)
            .height(35.dp),
        elevation = 0.dp,
        shape = CircleShape, onClick = { onClick?.invoke() }) {
        Image(
            modifier = Modifier
                .wrapContentSize(),
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = ""
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBlueButton() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        BackButton()
        BlueButton(labelId = R.string.welcome_button_enter)
        CornerButton(labelId = R.string.welcome_button_enter)
        CornerImgButton(
            imgId = R.drawable.ic_google_logo,
            labelId = R.string.google_name,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun BlueButton(@StringRes labelId: Int, onClick: (() -> Unit)? = null) {
    Button(
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxWidth()
            .height(54.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 5.dp,
            disabledElevation = 0.dp
        ),
        shape = RoundedCornerShape(corner = CornerSize(5.dp)),
        onClick = { onClick?.invoke() }
    ) {
        Text(
            text = stringResource(id = labelId),
            fontSize = 15.sp,
            color = White,
            fontWeight = FontWeight.W600,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CornerButton(@StringRes labelId: Int, onClick: (() -> Unit)? = null) {
    Card(
        modifier = Modifier
            .padding(top = 26.dp)
            .fillMaxWidth(), elevation = 0.dp,
        border = BorderStroke(1.dp, GrayBorder)
    ) {
        Button(
            modifier = Modifier
                .background(color = White)
                .height(54.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 5.dp,
                disabledElevation = 0.dp
            ),
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            onClick = { onClick?.invoke() },
            colors = ButtonDefaults.buttonColors(backgroundColor = White)
        ) {
            Text(
                text = stringResource(id = labelId),
                fontSize = 15.sp,
                color = Black,
                fontWeight = FontWeight.W600,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun CornerImgButton(
    modifier: Modifier = Modifier,
    @DrawableRes imgId: Int,
    @StringRes labelId: Int,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .padding(top = 26.dp), elevation = 0.dp,
        border = BorderStroke(1.dp, GrayBorderLight)
    ) {
        Button(
            modifier = Modifier
                .background(color = White)
                .height(38.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 5.dp,
                disabledElevation = 0.dp
            ),
            shape = RoundedCornerShape(corner = CornerSize(5.dp)),
            onClick = { onClick?.invoke() },
            colors = ButtonDefaults.buttonColors(backgroundColor = White)
        ) {
            ConstraintLayout(
                modifier = Modifier.fillMaxWidth(),
                constraintSet = buildConstraintSet()
            ) {
                Image(
                    modifier = Modifier.layoutId("imgResource"),
                    painter = painterResource(id = imgId), contentDescription = ""
                )
                Text(
                    modifier = Modifier.layoutId("text"),
                    text = stringResource(id = labelId),
                    fontSize = 15.sp,
                    color = Black,
                    fontWeight = FontWeight.W500,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

fun buildConstraintSet(): ConstraintSet {
    return ConstraintSet {
        val img = createRefFor("imgResource")
        val text = createRefFor("text")
        val startGuideline = createGuidelineFromStart(0.25f)
        constrain(img) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            end.linkTo(startGuideline)
            bottom.linkTo(parent.bottom)
        }
        constrain(text) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }
    }
}
