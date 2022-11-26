package com.boreal.allen.ui.seller.businessinformation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavHostController
import com.boreal.allen.R
import com.boreal.allen.components.*
import com.boreal.allen.extensions.drawColoredShadow
import com.boreal.allen.theme.BlueTransparent
import com.boreal.allen.theme.GrayBackgroundMain
import com.boreal.allen.theme.GrayLetterShipping
import com.boreal.allen.ui.general.logingraph.welcome.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun ViewBussinessInformationMainCompose(
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
            val search = createRefFor("search")
            val bottomQuestion = createRefFor("bottomQuestion")
            val content = createRefFor("content")
            val guideLine = createGuidelineFromTop(0.09f)

            val guideLineSearch = createGuidelineFromTop(0.24f)

            constrain(toolbarTitle) {
                top.linkTo(parent.top)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(search) {
                top.linkTo(guideLine)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(guideLineSearch)
                width = Dimension.matchParent
                height = Dimension.wrapContent
            }
            constrain(content) {
                top.linkTo(guideLine, 0.dp)
                bottom.linkTo(bottomQuestion.top)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(bottomQuestion) {
                bottom.linkTo(parent.bottom)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
        }) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .layoutId("content")
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top
        ) {
            BussinessImageSelector(
                modifier = Modifier
                    .padding(
                        start = 30.dp,
                        end = 30.dp,
                        top = 30.dp
                    )
            )

            TextField(modifier = Modifier.padding(
                start = 10.dp,
                end = 10.dp,
                top = 10.dp
            ), value = "Nombre del negocio", onValueChange = {})

            SemiBoldText(
                modifier = Modifier.padding(start = 30.dp, end = 30.dp),
                text = "Mensaje de bienvenida al cliente",
                size = 15.sp
            )

            OutlinedTextField(
                modifier = Modifier.padding(start = 30.dp, end = 30.dp, bottom = 30.dp),
                value = "",
                onValueChange = {},
                placeHolder = "Escribe un mensaje corto"
            )

            BoldText(
                modifier = Modifier.padding(start = 30.dp),
                text = "Categoria",
                size = 20.sp
            )

            BrandingHorizontal(
                modifier = Modifier.padding(
                    end = 30.dp,
                    top = 35.dp
                )
            )

        }

        ToolbarTitle(
            modifier = Modifier.layoutId("toolbarTitle"),
            titleText = "Datos negocio", backClicked = {
                navController?.navigateUp()
            }, firstIcon = R.drawable.ic_menu_icon,
            endIcon = R.drawable.ic_bell_icon
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .layoutId("bottomQuestion"),
            elevation = 9.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(White),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 30.dp, end = 30.dp,
                        bottom = 18.dp
                    ),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    RegularText(
                        text = "1 de 4 completados",
                        color = GrayLetterShipping,
                        size = 18.sp
                    )
                    ShadowButton(
                        modifier = Modifier
                            .padding(bottom = 18.dp, top = 16.dp)
                            .fillMaxWidth()
                            .drawColoredShadow(
                                color = BlueTransparent, alpha = 1f, borderRadius = 10.dp,
                                offsetY = 6.dp, offsetX = 5.dp, blurRadius = 10.dp
                            ),
                        text = "Siguiente"
                    )
                }
            }
        }
    }
}
