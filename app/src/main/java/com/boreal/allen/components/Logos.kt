package com.boreal.allen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.boreal.allen.R


@Composable
fun LogoBlue(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.fillMaxWidth(),
        painter = painterResource(
            id = R.drawable.allen_blue_logo
        ), contentDescription = "allenIcon"
    )
}