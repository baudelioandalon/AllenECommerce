package com.boreal.allen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.allen.R
import com.boreal.allen.theme.*

@Preview(showBackground = true)
@Composable
fun TestSearchs() {
    Column(
        Modifier
            .padding(start = 10.dp, top = 10.dp, end = 10.dp)
            .fillMaxSize()
            .background(Color.White)
    ) {
        SearchOutlinedTextField(
            value = "",
            placeHolder = "Buscar"
        )
        SearcherWithButton(
            value = "",
            placeHolder = "Buscar"
        )
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchOutlinedTextField(
    modifier: Modifier = Modifier,
    placeHolder: String = "",
    value: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.Words,
        keyboardType = KeyboardType.Text
    ),
    keyboardActions: KeyboardActions = KeyboardActions { },
    enabled: Boolean = false,
    singleLine: Boolean = false,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = GrayBackgroundSearch,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent, textColor = GrayLetterHint,
        disabledTextColor = GrayLetterHint,
    ),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    settingsClicked: (() -> Unit)? = null,
    itemClicked: (() -> Unit)? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(modifier = modifier) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                    color = GrayBorderSearch
                )
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = rememberRipple(
                        bounded = true,
                        color = GrayLetterHint.copy(alpha = 0.1f)
                    )
                ) { itemClicked?.invoke() },
            shape = RoundedCornerShape(corner = CornerSize(10.dp)),
            textStyle = TextStyle(
                color = Black,
                fontWeight = SemiBold,
                fontSize = 15.sp
            ),
            interactionSource = interactionSource,
            value = value,
            onValueChange = {}, placeholder = {
                Text(
                    text = placeHolder,
                    color = GrayLetterHint,
                    fontWeight = SemiBold,
                    fontSize = 16.sp
                )
            },
            colors = colors,
            isError = false,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            leadingIcon = {
                Card(
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp),
                    elevation = 0.dp,
                    shape = CircleShape, backgroundColor = GrayBackgroundSearch
                ) {
                    Image(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(id = R.drawable.ic_search_icon),
                        contentDescription = "settingsIcon"
                    )
                }
            },
            trailingIcon = {
                Card(
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp),
                    elevation = 0.dp,
                    shape = CircleShape,
                    backgroundColor = GrayBackgroundSearch,
                    onClick = { settingsClicked?.invoke() }) {
                    Icon(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(id = R.drawable.ic_settings_gray),
                        contentDescription = "settingsIcon"
                    )
                }
            },
            enabled = enabled,
            singleLine = singleLine,
            visualTransformation = visualTransformation
        )

    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearcherWithButton(
    modifier: Modifier = Modifier,
    placeHolder: String = "",
    value: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.Words,
        keyboardType = KeyboardType.Text
    ),
    keyboardActions: KeyboardActions = KeyboardActions { },
    enabled: Boolean = true,
    singleLine: Boolean = false,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = GrayBackgroundSearch,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent, textColor = GrayLetterHint,
        disabledTextColor = GrayLetterHint,
    ),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    settingsClicked: (() -> Unit)? = null,
    itemClicked: (() -> Unit)? = null
) {
    Row (modifier = modifier, verticalAlignment = Alignment.CenterVertically){
        val interactionSource = remember { MutableInteractionSource() }
        Column(modifier = Modifier.weight(1f)) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                textStyle = TextStyle(
                    color = Black,
                    fontWeight = SemiBold,
                    fontSize = 15.sp
                ),
                interactionSource = interactionSource,
                value = value,
                onValueChange = {}, placeholder = {
                    Text(
                        text = placeHolder,
                        color = GrayLetterHint,
                        fontWeight = SemiBold,
                        fontSize = 16.sp
                    )
                },
                colors = colors,
                isError = false,
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                leadingIcon = {
                    Card(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp),
                        elevation = 0.dp,
                        shape = CircleShape, backgroundColor = GrayBackgroundSearch
                    ) {
                        Icon(
                            modifier = Modifier.wrapContentSize(),
                            painter = painterResource(id = R.drawable.ic_search_icon),
                            contentDescription = "settingsIcon"
                        )
                    }
                },
                trailingIcon = {
                    Card(
                        modifier = Modifier
                            .width(35.dp)
                            .height(35.dp),
                        elevation = 0.dp,
                        shape = CircleShape,
                        backgroundColor = GrayBackgroundSearch,
                        onClick = { settingsClicked?.invoke() }) {
                        Icon(
                            modifier = Modifier.wrapContentSize(),
                            painter = painterResource(id = R.drawable.ic_settings_gray),
                            contentDescription = "settingsIcon",
                            tint = Black
                        )
                    }
                },
                enabled = enabled,
                singleLine = singleLine,
                visualTransformation = visualTransformation
            )

        }
        BoldText(modifier = Modifier.padding(start = 33.dp).clickable { itemClicked?.invoke() },
            text = "Buscar", size = 14.sp,
            color = PrimaryColor
        )
    }
}