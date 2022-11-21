package com.boreal.allen.ui.client.result.seller

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavHostController
import com.boreal.allen.components.*
import com.boreal.allen.theme.GrayBackgroundMain
import com.boreal.allen.theme.GrayBorder
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable
fun ViewResultBySellerClientCompose(
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

        val numberOfItemsByRow =
            LocalConfiguration.current.screenWidthDp / 200 // you can replace 200 by the minimum size you want your cells to have.

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .layoutId("content"),
            columns = GridCells.Adaptive(minSize = 200.dp)
        ) {
            item(span = { GridItemSpan(numberOfItemsByRow) }) {
                SearcherWithButton(
                    modifier = Modifier.padding(start = 30.dp, top = 30.dp, end = 30.dp),
                    value = "",
                    placeHolder = "Buscar en tienda..."
                )
            }

            item(span = { GridItemSpan(numberOfItemsByRow) }) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 30.dp,
                            top = 30.dp,
                            bottom = 25.dp
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight(align = Alignment.Top),
                        horizontalAlignment = Alignment.Start
                    ) {
                        SemiBoldText(
                            text = "Todos",
                            size = 25.sp
                        )
                        BoldText(
                            text = "14 articulos",
                            size = 12.sp,
                            color = GrayBorder
                        )
                    }
                    ShowSellerItem(modifier = Modifier.padding(start = 50.dp))
                }

            }
            itemsIndexed(
                items = listOf(
                    "", "", "", "",
                    "", "", "", "", ""
                )
            ) { index, item ->
                ProductResultItem(
                    modifier = Modifier.padding(
                        start = if (index % 2 == 0) 30.dp else 10.dp,
                        end = if (index % 2 == 0) 10.dp else 30.dp,
                        top = if (index % 2 != 0) 20.dp else 0.dp
                    )
                )
            }
        }

    }
    ToolbarSellerStore(
        backClicked = {
            navController?.navigateUp()
        }, optionClicked = {

        })

}