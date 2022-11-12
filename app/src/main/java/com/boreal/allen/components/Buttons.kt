package com.boreal.allen.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.boreal.allen.R
import com.boreal.allen.extensions.drawColoredShadow
import com.boreal.allen.theme.*

@Preview(showBackground = true)
@Composable
fun PreviewBottons() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        BackButton()
        BlueButton(labelId = R.string.welcome_button_enter)
        ShadowButton(labelId = R.string.welcome_button_enter)
        CornerButton(labelId = R.string.welcome_button_enter)
        CornerImgButton(
            imgId = R.drawable.ic_google_logo,
            labelId = R.string.google_name,
            modifier = Modifier.fillMaxWidth()
        )
        LittleAddButton()
        FavoriteButton()
        FavoriteCounterButton()
        ShareButton()
        RightRoundedButton()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteButton(modifier: Modifier = Modifier, clicked: (() -> Unit)? = null) {
    Card(
        modifier = modifier
            .layoutId("favorite_selector")
            .size(35.dp),
        elevation = 0.dp,
        shape = CircleShape, onClick = { clicked?.invoke() }) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_favorite_unselected),
            contentDescription = ""
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteCounterButton(
    modifier: Modifier = Modifier,
    amount: Int = 0, clicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .layoutId("favorite_selector")
            .height(35.dp)
            .wrapContentWidth(),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = FavoriteUnselectedColor,
        onClick = { clicked?.invoke() }) {
        Row(
            modifier = Modifier.wrapContentWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                modifier = Modifier.size(35.dp),
                painter = painterResource(id = R.drawable.ic_favorite_unselected),
                contentDescription = ""
            )
            BoldText(
                modifier = Modifier
                    .padding(end = 13.dp)
                    .wrapContentWidth(),
                text = "$amount",
                color = FavoriteSelectedColor,
                size = 12.sp,
                align = TextAlign.Start
            )
        }

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShareButton(modifier: Modifier = Modifier, clicked: (() -> Unit)? = null) {
    Card(
        modifier = modifier
            .layoutId("share_selector")
            .size(35.dp),
        elevation = 0.dp,
        shape = CircleShape, onClick = { clicked?.invoke() }) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_share_icon),
            contentDescription = ""
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RightRoundedButton(modifier: Modifier = Modifier, clicked: (() -> Unit)? = null) {
    Card(
        modifier = modifier
            .layoutId("rounded_selector")
            .size(35.dp),
        elevation = 0.dp,
        shape = CircleShape, onClick = { clicked?.invoke() }) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_rounded_arrow_right),
            contentDescription = ""
        )
    }
}

@Composable
fun RightRoundedButton(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .layoutId("rounded_selector")
            .size(35.dp),
        elevation = 0.dp,
        shape = CircleShape
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_rounded_arrow_right),
            contentDescription = ""
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun LittleAddButton(onClick: (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .size(52.dp)
            .background(
                alpha = 0.7f,
                brush = Brush.radialGradient(
                    colors = listOf(
                        GreenStrong,
                        GreenTransparent
                    )
                ), shape = RoundedCornerShape(20.dp)
            )
            .padding(bottom = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .size(40.dp)
                .background(Color.Transparent),
            backgroundColor = GreenStrong, elevation = 0.dp,
            onClick = { onClick?.invoke() }
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    modifier = Modifier.size(15.dp),
                    imageVector = ImageVector.Companion.vectorResource(id = R.drawable.ic_more_icon),
                    contentDescription = "moreIcon",
                    tint = White
                )
            }
        }
    }
}

@Preview
@Composable
fun ShadowButton(
    modifier: Modifier = Modifier,
    text: String? = "Agregar al carrito",
    @StringRes labelId: Int? = null,
    size: TextUnit = 20.sp,
    onClick: (() -> Unit)? = null
) {
    BlueButton(
        modifier = modifier
            .drawColoredShadow(
                color = BlueTransparent, alpha = 1f, borderRadius = 10.dp,
                offsetY = 6.dp, offsetX = 5.dp, blurRadius = 10.dp
            ),
        size = size,
        text = text ?: stringResource(id = labelId ?: R.string.empty_string),
        borderRadius = 10.dp
    ){
        onClick?.invoke()
    }
}

@Composable
fun StarRatingSelector(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .clickable { }
                .size(30.dp),
            painter = painterResource(id = R.drawable.ic_star_icon),
            contentDescription = "star one",
            tint = StarColor
        )
        Icon(
            modifier = Modifier
                .padding(horizontal = 2.dp)
                .clickable { }
                .size(30.dp),
            painter = painterResource(id = R.drawable.ic_star_icon),
            contentDescription = "star two",
            tint = StarColor
        )
        Icon(
            modifier = Modifier
                .padding(horizontal = 2.dp)
                .clickable { }
                .size(30.dp),
            painter = painterResource(id = R.drawable.ic_star_icon),
            contentDescription = "star three",
            tint = StarColor
        )
        Icon(
            modifier = Modifier
                .padding(horizontal = 2.dp)
                .clickable { }
                .size(30.dp),
            painter = painterResource(id = R.drawable.ic_star_icon),
            contentDescription = "star four",
            tint = StarColor
        )
        Icon(
            modifier = Modifier
                .padding(start = 2.dp)
                .clickable { }
                .size(30.dp),
            painter = painterResource(id = R.drawable.ic_star_icon),
            contentDescription = "star five",
            tint = StarColor
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .width(35.dp)
            .height(35.dp),
        elevation = 0.dp,
        shape = CircleShape, onClick = { onClick?.invoke() }) {
        Image(
            modifier = Modifier.wrapContentSize(),
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = ""
        )
    }
}

@Composable
fun BlueButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    @StringRes labelId: Int? = null,
    borderRadius: Dp = 5.dp,
    size: TextUnit = 15.sp,
    onClick: (() -> Unit)? = null
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 5.dp,
            disabledElevation = 0.dp
        ),
        shape = RoundedCornerShape(corner = CornerSize(borderRadius)),
        onClick = { onClick?.invoke() }
    ) {
        Text(
            text = text ?: stringResource(id = labelId ?: R.string.empty_string),
            fontSize = size,
            color = White,
            fontWeight = SemiBold,
            letterSpacing = 0.sp,
            fontFamily = MaterialTheme.typography.caption.fontFamily,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun CornerButton(
    @StringRes labelId: Int,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
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
                fontWeight = SemiBold,
                letterSpacing = 0.sp,
                textAlign = TextAlign.Center,
                fontFamily = MaterialTheme.typography.caption.fontFamily
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
        modifier = modifier, elevation = 0.dp,
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
                    letterSpacing = 0.sp,
                    color = Black,
                    fontWeight = SemiBold,
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
