package com.boreal.allen.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.boreal.commonutils.R


val Montserrat = FontFamily(
    Font(R.font.montserrat_regular, FontWeight.W400),
    Font(R.font.montserrat_medium, FontWeight.W500),
    Font(R.font.montserrat_semibold, FontWeight.W600),
    Font(R.font.montserrat_bold, FontWeight.W700)
)

val Roboto = FontFamily(
    Font(R.font.roboto, FontWeight.W400),
    Font(R.font.roboto_light, FontWeight.W500),
    Font(R.font.roboto_bold, FontWeight.W600),
)

val Regular = FontWeight.W400
val Medium = FontWeight.W500
val SemiBold = FontWeight.W600
val Bold = FontWeight.W700

private val defaultTypography = Typography()

val MontserratTypo = Typography(
    defaultFontFamily = Montserrat,
    h1 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = Bold,
        fontSize = 30.sp,
        color = Color.Black
    ),
    h2 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = SemiBold,
        fontSize = 24.sp,
        color = Color.Black
    ),
    h3 = TextStyle(
        fontFamily = Montserrat,
        fontWeight = Medium,
        fontSize = 20.sp,
        color = Color.Black
    ),
    h4 = defaultTypography.h4.copy(fontFamily = Montserrat),
    h5 = defaultTypography.h5.copy(fontFamily = Montserrat),
    h6 = defaultTypography.h6.copy(fontFamily = Montserrat),
    body1 = defaultTypography.body1.copy(fontFamily = Montserrat),
    body2 = defaultTypography.body2.copy(fontFamily = Montserrat),
    caption = TextStyle(
        fontFamily = Montserrat,
        fontWeight = Regular,
        fontSize = 12.sp,
    ),
    subtitle1 = defaultTypography.subtitle1.copy(fontFamily = Montserrat),
    subtitle2 = defaultTypography.subtitle2.copy(fontFamily = Montserrat)
)

val RobotoTypo = Typography(
    defaultFontFamily = Roboto,
    h1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W400,
        fontSize = 30.sp,
        color = Color.Black
    ),
    h2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
        color = Color.Black
    ),
    h3 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp,
        color = Color.Black
    ),
    h4 = defaultTypography.h4.copy(fontFamily = Roboto),
    h5 = defaultTypography.h5.copy(fontFamily = Roboto),
    h6 = defaultTypography.h6.copy(fontFamily = Roboto),
    body1 = defaultTypography.body1.copy(fontFamily = Roboto),
    body2 = defaultTypography.body2.copy(fontFamily = Roboto),
    caption = TextStyle(
        color = Color.Black,
        fontWeight = SemiBold,
        fontSize = 15.sp,
        fontFamily = Roboto
    ),
    subtitle1 = defaultTypography.subtitle1.copy(fontFamily = Roboto),
    subtitle2 = defaultTypography.subtitle2.copy(fontFamily = Roboto)
)

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = PrimaryColor,
    primaryVariant = Purple700,
    secondary = Teal200,
    background = Color.White,
    /* Other default colors to override
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun AllenEcommerceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = MontserratTypo,
        shapes = Shapes,
        content = content
    )
}