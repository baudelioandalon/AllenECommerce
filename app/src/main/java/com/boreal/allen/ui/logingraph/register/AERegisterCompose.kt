package com.boreal.allen.ui.logingraph.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boreal.allen.R
import com.boreal.allen.components.BlueButton
import com.boreal.allen.components.LogoBlue
import com.boreal.allen.components.OutlinedTextField
import com.boreal.allen.components.TopTitle

@Preview
@Composable
fun TestRegisterCompose() {
}

@Composable
fun AERegisterCompose(navController: NavController) {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopTitle(titleText = "Nuevo socio") {
            navController.navigateUp()
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp)
                .verticalScroll(scrollState)
        ) {
            OutlinedTextField(
                modifier = Modifier.padding(top = 31.dp),
                helperText = "Nombre",
                value = "",
                onValueChange = {},
                placeHolder = "Nombre completo",
            )

            OutlinedTextField(
                modifier = Modifier.padding(top = 16.dp),
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
            OutlinedTextField(
                modifier = Modifier.padding(top = 16.dp),
                helperText = "Confirmar contraseña",
                value = "",
                onValueChange = {},
                placeHolder = "Ingrese contraseña",
            )

            BlueButton(
                modifier = Modifier.padding(top = 25.dp),
                labelId = R.string.register_button_enter
            )

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