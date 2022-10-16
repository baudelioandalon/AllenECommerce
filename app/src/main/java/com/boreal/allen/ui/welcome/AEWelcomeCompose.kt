package com.boreal.allen.ui.welcome

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.allen.R
import com.boreal.allen.components.BlueButton
import com.boreal.allen.components.CornerButton
import com.boreal.allen.theme.PrimaryColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview(showBackground = true)
@Composable
fun AEWelcomeCompose() {
    val systemUiController = rememberSystemUiController()
    if (isSystemInDarkTheme()) {
        systemUiController.setSystemBarsColor(
            color = Transparent
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = White
        )
    }
    val scrollRemember = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollRemember)
            .background(White)
    ) {
        Image(
            modifier = Modifier
                .padding(top = 100.dp, bottom = 49.dp)
                .width(300.dp)
                .height(200.dp),
            painter = painterResource(id = R.drawable.login_shopping),
            contentDescription = "shoppingImage"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Bienvenido a tu Tienda local",
                fontSize = 30.sp,
                color = Black,
                fontWeight = FontWeight.W700
            )
            Image(
                modifier = Modifier.padding(top = 7.dp),
                painter = painterResource(
                    id = R.drawable.allen_blue_logo
                ), contentDescription = "allenIcon"
            )
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "En linea",
                fontSize = 30.sp,
                color = Black,
                fontWeight = FontWeight.W700
            )
            val annotatedText = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append(stringResource(R.string.welcome_start_message) + " ")
                }
                // We attach this *termsClick* annotation to the following content
                // until `pop()` is called
                pushStringAnnotation(
                    tag = "termsClick",
                    annotation = "termsClick"
                )
                withStyle(
                    style = SpanStyle(
                        color = PrimaryColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append(stringResource(R.string.welcome_start_message_second_part))
                }
                pop()
            }
            ClickableText(
                text = annotatedText,
                modifier = Modifier.padding(top = 27.dp),
                onClick = { offset ->

                }
            )

            BlueButton(labelId = R.string.welcome_button_enter) {

            }
            CornerButton(labelId = R.string.welcome_i_want_to_be_seller) {

            }

            Image(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 50.dp)
                    .width(35.dp)
                    .height(11.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                painter = painterResource(
                    id = R.drawable.allen_blue_logo
                ), contentDescription = "allenIcon"
            )
        }
    }
}