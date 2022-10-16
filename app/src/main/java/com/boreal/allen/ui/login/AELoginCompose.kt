package com.boreal.allen.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.boreal.allen.R
import com.boreal.allen.components.*
import com.boreal.allen.domain.Screen
import com.boreal.allen.theme.SemiBold
import com.boreal.allen.ui.homeclient.AEHomeClientComposable

@Composable
fun AELoginCompose(navController: NavHostController) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopTitle {
            navController.navigateUp()
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .verticalScroll(scrollState)
        ) {

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 45.dp),
                text = "Soy cliente / Quiero ser cliente",
                fontSize = 20.sp,
                color = Color.Black,
                fontWeight = SemiBold
            )
            Row(
                modifier = Modifier
                    .padding(top = 34.dp)
                    .fillMaxWidth()
            ) {
                CornerImgButton(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .fillMaxWidth(0.5f),
                    imgId = R.drawable.ic_google_logo,
                    labelId = R.string.google_name
                )
                CornerImgButton(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    imgId = R.drawable.ic_facebook_logo,
                    labelId = R.string.facebook_name
                )
            }

            SeparatorHorizontal(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 39.dp)
            )

            MediumText(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                text = "Soy socio vendedor"
            )

            OutlinedTextField(
                modifier = Modifier.padding(top = 31.dp),
                helperText = "Correo",
                value = "",
                onValueChange = {},
                placeHolder = "nombre@dominio.com",
            )
            OutlinedTextField(
                modifier = Modifier.padding(top = 16.dp),
                helperText = "Contraseña",
                value = "",
                onValueChange = {},
                placeHolder = "Ingrese contraseña",
            )

            BlueButton(
                modifier = Modifier.padding(top = 25.dp),
                labelId = R.string.welcome_button_enter
            ){
                navController.navigate(Screen.HomeClientScreen.route)
            }

            RegularText(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                labelId = R.string.login_forget_p, align = TextAlign.Center
            )

            SeparatorHorizontal(
                modifier = Modifier
                    .padding(vertical = 22.dp)
            )

            CornerButton(labelId = R.string.welcome_i_want_to_be_seller) {
                navController.navigate(Screen.RegisterScreen.route)
            }
            LogoBlue(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 50.dp)
                    .width(35.dp)
                    .height(11.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
    }

}