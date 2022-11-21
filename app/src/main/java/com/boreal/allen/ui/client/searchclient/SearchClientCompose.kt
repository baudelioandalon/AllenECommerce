package com.boreal.allen.ui.client.searchclient

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.boreal.allen.R
import com.boreal.allen.components.RegularText
import com.boreal.allen.components.ToolbarSearch
import com.boreal.allen.domain.ClientScreen
import com.boreal.allen.domain.RESULT_CLIENT_GRAPH
import com.boreal.allen.theme.GrayBackgroundMain
import com.boreal.allen.theme.GrayLetterHint
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable
fun ViewSearchClientCompose(
    navController: NavHostController? = null,
    closeApp: () -> Unit = {}
) {
    val systemUiController = rememberSystemUiController()
    if (isSystemInDarkTheme()) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = White
        )
    }
    val scrollState = rememberScrollState()

    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(GrayBackgroundMain),
        constraintSet = ConstraintSet {
            val toolbarTitle = createRefFor("toolbarTitle")
            val content = createRefFor("content")
            val guideLine = createGuidelineFromTop(0.09f)

            constrain(toolbarTitle) {
                top.linkTo(parent.top)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }

            constrain(content) {
                top.linkTo(guideLine, 0.dp)
                bottom.linkTo(parent.bottom, margin = 30.dp)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
        }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GrayBackgroundMain)
                .layoutId("content")
        ) {

            item {
                Card(elevation = 10.dp) {
                    FlowRow(modifier = Modifier.padding(top = 10.dp)) {
                        listOf("Ropa de mujer", "Ropa de bebé", "Ropa de niño").forEach {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable(
                                        interactionSource = MutableInteractionSource(),
                                        indication = rememberRipple(
                                            bounded = true,
                                            color = GrayLetterHint.copy(alpha = 0.1f)
                                        )
                                    ) {
                                        navController?.navigate(
                                            route = RESULT_CLIENT_GRAPH,
                                            navOptions = NavOptions
                                                .Builder()
                                                .setPopUpTo(
                                                    route = ClientScreen.HomeClientLoginScreen.route,
                                                    inclusive = false
                                                )
                                                .build()
                                        )
                                    }
                                    .padding(
                                        start = 30.dp,
                                        end = 30.dp
                                    ),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_clock_gray),
                                    contentDescription = ""
                                )
                                RegularText(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(
                                            top = 10.dp,
                                            bottom = 10.dp
                                        )
                                        .padding(start = 10.dp),
                                    text = it,
                                    align = TextAlign.Start,
                                    size = 15.sp
                                )
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_search_icon),
                                    contentDescription = "",
                                    tint = GrayLetterHint
                                )
                            }

                        }
                    }
                }
            }
        }

    }
    ToolbarSearch(backClicked = {
        navController?.navigateUp()
    }, configClicked = {

    }, searchClicked = {

    })

}