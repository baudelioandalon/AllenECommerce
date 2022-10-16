package com.boreal.allen.ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.allen.R
import com.boreal.allen.components.BackButton
import com.boreal.allen.components.CornerImgButton

@Preview(showBackground = true)
@Composable
fun AELoginCompose() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 30.dp)
    ) {
        BackButton(
            Modifier.padding(top = 34.dp)
        ) {

        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 45.dp),
            text = "Soy cliente / Quiero ser cliente",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.W500
        )
        Row(
            modifier = Modifier
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

    }
}