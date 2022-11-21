package com.boreal.allen.components

import androidx.annotation.IdRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.boreal.allen.R

@Preview
@Composable
fun TestToolbars() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ToolbarSearchHome()
        ToolbarSearch()
        TopTitle(titleText = "Socio vendedor") {

        }
        ToolbarTitle(titleText = "Articulo")
        ToolbarSellerStore()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ToolbarSearchHome(
    modifier: Modifier = Modifier,
    textPlaceHolder: String = "Buscar",
    leftIcon: Int = R.drawable.ic_menu_icon,
    menuClicked: (() -> Unit)? = null,
    searchClicked: (() -> Unit)? = null,
    cartClicked: (() -> Unit)? = null
) {
    Row(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .layoutId("imageMenu"),
            elevation = 5.dp
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize(),
                constraintSet = ConstraintSet {
                    val imageMenu = createRefFor("imageMenu")
                    val imageCart = createRefFor("imageCart")
                    constrain(imageMenu) {
                        start.linkTo(parent.start, margin = 28.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    constrain(createRefFor("search")) {
                        start.linkTo(imageMenu.end, margin = 20.dp)
                        top.linkTo(parent.top)
                        end.linkTo(imageCart.start, margin = 20.dp)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    }
                    constrain(imageCart) {
                        end.linkTo(parent.end, margin = 28.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                }) {
                Card(
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp)
                        .layoutId("imageMenu"),
                    elevation = 0.dp,
                    shape = CircleShape, onClick = { menuClicked?.invoke() }) {
                    Image(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(id = leftIcon),
                        contentDescription = ""
                    )
                }
                SearchOutlinedTextField(
                    modifier = Modifier.layoutId("search"),
                    value = "",
                    placeHolder = textPlaceHolder,
                    itemClicked = { searchClicked?.invoke() }
                )
                Card(
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp)
                        .layoutId("imageCart"),
                    elevation = 0.dp,
                    shape = CircleShape, onClick = { cartClicked?.invoke() }) {
                    Image(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(id = R.drawable.ic_cart_icon),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@Composable
fun ToolbarSearch(
    modifier: Modifier = Modifier,
    backClicked: (() -> Unit)? = null,
    configClicked: (() -> Unit)? = null,
    searchClicked: (() -> Unit)? = null
) {
    Row(modifier = modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .layoutId("imageMenu"),
            elevation = 5.dp
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize(),
                constraintSet = ConstraintSet {
                    val backButton = createRefFor("backButton")
                    constrain(backButton) {
                        start.linkTo(parent.start, margin = 10.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    constrain(createRefFor("search")) {
                        start.linkTo(backButton.end, margin = 10.dp)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    }
                }) {
                BackButton(
                    Modifier
                        .layoutId("backButton")
                        .width(35.dp)
                        .height(35.dp)
                ) {
                    backClicked?.invoke()
                }
                SearcherWithSettings(
                    modifier = Modifier.layoutId("search"),
                    value = "",
                    placeHolder = "Escribe el producto o marca...",
                    itemClicked = { searchClicked?.invoke() },
                    settingsClicked = {
                        configClicked?.invoke()
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ToolbarTitle(
    modifier: Modifier = Modifier,
    titleText: String? = null,
    @IdRes labelId: Int? = null,
    backClicked: (() -> Unit)? = null,
    cartClicked: (() -> Unit)? = null,
    showEndImage: Boolean = true,
    iconIdRes: Int = R.drawable.ic_cart_icon
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .layoutId("imageMenu"),
        elevation = 5.dp
    ) {
        Row(modifier = modifier) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize(),
                constraintSet = ConstraintSet {
                    val imageBack = createRefFor("imageBack")
                    val title = createRefFor("title")
                    val imageCart = createRefFor("imageCart")
                    constrain(imageBack) {
                        start.linkTo(parent.start, margin = 28.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    constrain(title) {
                        start.linkTo(imageBack.end)
                        top.linkTo(parent.top)
                        end.linkTo(imageCart.start)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                        height = Dimension.wrapContent
                    }
                    constrain(imageCart) {
                        end.linkTo(parent.end, margin = 28.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                }) {
                Card(
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp)
                        .layoutId("imageBack"),
                    elevation = 0.dp,
                    shape = CircleShape, onClick = { backClicked?.invoke() }) {
                    Image(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(id = R.drawable.ic_back_arrow),
                        contentDescription = ""
                    )
                }
                SemiBoldText(
                    modifier = Modifier
                        .layoutId("title"),
                    text = titleText ?: stringResource(id = labelId ?: R.string.empty_string),
                    align = TextAlign.Center
                )
                if (showEndImage) {
                    Card(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp)
                            .layoutId("imageCart"),
                        elevation = 0.dp,
                        shape = CircleShape, onClick = { cartClicked?.invoke() }) {
                        Image(
                            modifier = Modifier.wrapContentSize(),
                            painter = painterResource(id = iconIdRes),
                            contentDescription = ""
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun TopTitle(
    titleText: String? = null,
    @IdRes labelId: Int? = null,
    backClicked: (() -> Unit)? = null
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp), constraintSet = ConstraintSet {
            val backButton = createRefFor("backButton")
            val title = createRefFor("title")
            constrain(title) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.fillToConstraints
                height = Dimension.wrapContent
            }
            constrain(backButton) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                height = Dimension.wrapContent
            }
        }
    ) {
        BackButton(
            Modifier
                .layoutId("backButton")
                .padding(start = 30.dp)
                .width(35.dp)
                .height(35.dp)
        ) {
            backClicked?.invoke()
        }
        SemiBoldText(
            modifier = Modifier
                .layoutId("title"),
            text = titleText ?: stringResource(id = labelId ?: R.string.empty_string),
            align = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun ToolbarSellerStore(
    modifier: Modifier = Modifier,
    backClicked: (() -> Unit)? = null,
    optionClicked: (() -> Unit)? = null,
    iconIdRes: Int = R.drawable.ic_cart_icon
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .layoutId("imageMenu"),
        elevation = 5.dp
    ) {
        Row(modifier = modifier) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize(),
                constraintSet = ConstraintSet {
                    val imageBack = createRefFor("imageBack")
                    val selector = createRefFor("selector")
                    val imageCart = createRefFor("imageCart")
                    constrain(imageBack) {
                        start.linkTo(parent.start, margin = 28.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    constrain(selector) {
                        start.linkTo(imageBack.end, 55.dp)
                        top.linkTo(parent.top)
                        end.linkTo(imageCart.start, 35.dp)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                        height = Dimension.value(46.dp)
                    }
                    constrain(imageCart) {
                        end.linkTo(parent.end, margin = 28.dp)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                }) {
                Card(
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp)
                        .layoutId("imageBack"),
                    elevation = 0.dp,
                    shape = CircleShape, onClick = { backClicked?.invoke() }) {
                    Image(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(id = R.drawable.ic_back_arrow),
                        contentDescription = ""
                    )
                }
                SelectorStoreSpinner(
                    modifier = Modifier
                        .size(35.dp)
                        .layoutId("selector")
                )
                Card(
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp)
                        .layoutId("imageCart"),
                    elevation = 0.dp,
                    shape = CircleShape, onClick = { optionClicked?.invoke() }) {
                    Image(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(id = R.drawable.ic_dots_options),
                        contentDescription = ""
                    )
                }
            }

        }
    }
}
