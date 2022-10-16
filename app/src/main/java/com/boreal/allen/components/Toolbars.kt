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
import androidx.compose.ui.graphics.Color.Companion.Red
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
        TopTitle(titleText = "Socio vendedor") {

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ToolbarSearchHome(
    menuClicked: (() -> Unit)? = null,
    searchClicked: (() -> Unit)? = null,
    cartClicked: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .layoutId("imageMenu"), elevation = 5.dp
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
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
                    painter = painterResource(id = R.drawable.ic_menu_icon),
                    contentDescription = ""
                )
            }
            SearchOutlinedTextField(
                modifier = Modifier.layoutId("search"),
                value = "",
                placeHolder = "Buscar", itemClicked = { searchClicked?.invoke() }
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
        MediumText(
            modifier = Modifier
                .layoutId("title"),
            text = titleText ?: stringResource(id = labelId ?: R.string.empty_string),
            align = TextAlign.Center
        )
    }
}