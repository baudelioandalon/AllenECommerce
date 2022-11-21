package com.boreal.allen.ui.addressclient

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavHostController
import com.boreal.allen.R
import com.boreal.allen.components.AddressSelector
import com.boreal.allen.components.MediumText
import com.boreal.allen.components.NewAddressSelector
import com.boreal.allen.components.ToolbarTitle
import com.boreal.allen.theme.GrayBackgroundMain
import com.boreal.allen.theme.GrayStrong
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable
fun ViewAddressClientCompose(navController: NavHostController? = null) {
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
            val listContent = createRefFor("listContent")
            val content = createRefFor("content")
            val guideLine = createGuidelineFromTop(0.09f)

            val guideLineSearch = createGuidelineFromTop(0.095f)

            constrain(content) {
                top.linkTo(guideLineSearch, 0.dp)
                bottom.linkTo(parent.top, margin = 0.dp)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(toolbarTitle) {
                top.linkTo(parent.top)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(listContent) {
                top.linkTo(guideLine)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }

        }) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(GrayBackgroundMain)
                .layoutId("listContent")
        ) {
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 30.dp),
                    elevation = 5.dp
                ) {
                    Column(
                        modifier = Modifier
                            .background(White)
                            .padding(horizontal = 30.dp)
                            .wrapContentHeight()
                            .fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp, bottom = 30.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            MediumText(
                                text = "Dirección",
                                size = 15.sp
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_arrow_down),
                                contentDescription = "hide address",
                                tint = GrayStrong
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 30.dp),
                        ) {
                            AddressSelector(
                                textTop = "Casa",
                                iconRes = R.drawable.ic_house,
                                selected = true
                            )
                            AddressSelector(
                                modifier = Modifier.padding(top = 20.dp),
                                textTop = "Trabajo",
                                iconRes = R.drawable.ic_briefcase
                            )
                            NewAddressSelector(
                                modifier = Modifier.padding(top = 20.dp)
                            )
                        }
                    }
                }
            }
        }
        ToolbarTitle(
            modifier = Modifier.layoutId("toolbarTitle"),
            titleText = "Mis direcciónes", backClicked = {
                navController?.navigateUp()
            }, showEndImage = false
        )

    }
}