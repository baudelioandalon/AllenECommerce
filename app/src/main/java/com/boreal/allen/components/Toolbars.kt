package com.boreal.allen.components

import androidx.annotation.IdRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        TopTitle(titleText = "Socio vendedor") {

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