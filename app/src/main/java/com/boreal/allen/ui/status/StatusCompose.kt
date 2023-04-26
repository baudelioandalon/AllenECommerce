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
import com.boreal.allen.theme.ErrorColor
import com.boreal.allen.theme.SuccessColor
import com.boreal.allen.theme.WarningColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview(showBackground = true)
@Composable
fun ViewStatusCompose(
    titleText: String = "",
    type: StatusEnum = StatusEnum.SUCCESS,
    subtitleText: String = "",
    bottomText: String = ""
) {
    val systemUiController = rememberSystemUiController()
    if (isSystemInDarkTheme()) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = when (type) {
                StatusEnum.SUCCESS -> SuccessColor
                StatusEnum.WARNING -> WarningColor
                else -> ErrorColor
            }
        )
    }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(
                when (type) {
                    StatusEnum.SUCCESS -> SuccessColor
                    StatusEnum.WARNING -> WarningColor
                    else -> ErrorColor
                }
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SemiBoldText(
            text = titleText,
            align = TextAlign.Center,
            color = White,
            size = 30.sp
        )
        Image(
            modifier = Modifier.padding(vertical = 150.dp),
            painter = painterResource(
                id = when (type) {
                    StatusEnum.SUCCESS -> R.drawable.ic_success_status
                    StatusEnum.WARNING -> R.drawable.ic_warning_status
                    else -> R.drawable.ic_error_status
                }
            ),
            contentDescription = "imgType"
        )
        SemiBoldText(
            text = subtitleText,
            align = TextAlign.Center,
            color = White,
            size = 25.sp
        )
        SemiBoldText(
            text = bottomText,
            align = TextAlign.Center,
            color = White,
            size = 14.sp
        )
    }

}