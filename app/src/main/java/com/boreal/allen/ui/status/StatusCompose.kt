package com.boreal.allen.ui.status

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavHostController
import com.boreal.allen.R
import com.boreal.allen.components.SemiBoldText
import com.boreal.allen.domain.enum.StatusEnum
import com.boreal.allen.theme.SuccessColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview(showBackground = true)
@Composable
fun ViewStatusCompose(
    navController: NavHostController? = null,
    titleText: String = "",
    type: StatusEnum = StatusEnum.SUCCESS,
    subtitleText: String = "", bottomText: String = ""
) {
    val systemUiController = rememberSystemUiController()
    if (isSystemInDarkTheme()) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = SuccessColor
        )
    }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(SuccessColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SemiBoldText(
            text = "Pagarás\n $148",
            align = TextAlign.Center,
            color = White,
            size = 30.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 150.dp),
            painter = painterResource(id = R.drawable.ic_success_status),
            contentDescription = "success"
        )
        SemiBoldText(
            text = "Compra exitosa",
            align = TextAlign.Center,
            color = White,
            size = 25.sp
        )
        SemiBoldText(
            text = "Disfruta de tu compra",
            align = TextAlign.Center,
            color = White,
            size = 14.sp
        )
    }

}