package com.boreal.allen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.boreal.allen.R
import com.boreal.allen.theme.Bold
import com.boreal.allen.theme.Montserrat
import com.boreal.allen.theme.MontserratTypo
import com.boreal.allen.theme.SemiBold


@Preview
@Composable
fun TestPreviewTexts() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        MediumText(labelId = R.string.welcome_button_enter)
    }
}

@Composable
fun LargeText(
    text: String? = null,
    labelId: Int? = null,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    align: TextAlign? = null
) {
    Text(
        modifier = modifier
            .fillMaxWidth(),
        text = text ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = 30.sp,
        color = color,
        fontWeight = Bold,
        textAlign = align
    )
}

@Composable
fun MediumText(
    text: String? = null,
    labelId: Int? = null,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    align: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = 20.sp,
        color = color,
        fontWeight = SemiBold,
        textAlign = align,
        fontFamily = MaterialTheme.typography.caption.fontFamily
    )
}

@Composable
fun RegularText(
    text: String? = null,
    labelId: Int? = null,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
    align: TextAlign? = null
) {
    Text(
        modifier = modifier,
        text = text ?: stringResource(id = labelId ?: R.string.empty_string),
        fontSize = 15.sp,
        color = color,
        fontWeight = SemiBold,
        textAlign = align
    )
}