package com.boreal.allen.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.allen.R
import com.boreal.allen.theme.*

@Preview(showBackground = true)
@Composable
fun TestSelectors() {
    Column(modifier = Modifier.fillMaxSize()) {
        SelectorCounter()
        SelectorDetail(
            text = "Detalles del producto",
            iconRes = R.drawable.ic_detail_icon
        )
        ShippingSelector()
        AddressSelector()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SelectorCounter(
    quantity: Int = 1,
    lessClicked: (() -> Unit)? = null,
    moreClicked: (() -> Unit)? = null
) {
    Row(modifier = Modifier.wrapContentSize()) {
        Surface(
            modifier = Modifier
                .size(35.dp),
            color = Color.White,
            border = BorderStroke(
                width = 1.dp,
                color = GreenStrong
            ),
            shape = RoundedCornerShape(5.dp),
            onClick = { lessClicked?.invoke() }
        ) {
            Icon(
                modifier = Modifier.padding(13.dp),
                painter = painterResource(id = R.drawable.ic_less_icon),
                contentDescription = "less_icon",
                tint = GreenStrong
            )
        }
        SemiBoldText(
            modifier = Modifier.padding(horizontal = 22.dp),
            text = "$quantity", size = 25.sp
        )
        Surface(
            modifier = Modifier
                .size(35.dp),
            color = GreenStrong,
            shape = RoundedCornerShape(5.dp),
            onClick = { moreClicked?.invoke() }
        ) {
            Icon(
                modifier = Modifier.padding(12.dp),
                painter = painterResource(id = R.drawable.ic_more_icon),
                contentDescription = "more_icon",
                tint = Color.White
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShippingSelector(
    modifier: Modifier = Modifier, shipping: Boolean = false,
    onClicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        border = if (shipping) BorderStroke(1.dp, PrimaryColor) else null,
        backgroundColor = if (shipping) White else GraySelector,
        onClick = {
            onClicked?.invoke()
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(end = 13.dp),
                painter = painterResource(id = if (shipping) R.drawable.ic_house else R.drawable.ic_walking),
                contentDescription = "hide shipping options",
                tint = if (shipping) PrimaryColor else GrayMedium
            )
            MediumText(
                text = if (shipping) "Enviar a \ndomicilio" else "Recolectar",
                align = TextAlign.Center,
                color = if (shipping) PrimaryColor else GrayMedium,
                size = 15.sp
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun AddressSelector(
    modifier: Modifier = Modifier,
    textTop: String = "Recibe",
    textBottom: String = "Calle #22, Colonia Test, Ciudad, Estado 000ddd00",
    iconRes: Int = R.drawable.ic_location,
    selected: Boolean = false,
    onClicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, if (selected) PrimaryColor else GrayBorderThin),
            backgroundColor = White,
            onClick = {
                onClicked?.invoke()
            }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.padding(end = 13.dp, start = 16.dp),
                    painter = painterResource(id = iconRes),
                    contentDescription = "hide shipping options",
                    tint = if (selected) PrimaryColor else GraySinceTo
                )
                Column {
                    MediumText(
                        text = textTop,
                        color = GraySinceTo,
                        size = 15.sp
                    )
                    MediumText(
                        modifier = Modifier
                            .width(180.dp)
                            .wrapContentHeight(),
                        text = textBottom,
                        align = TextAlign.Center,
                        color = GrayMedium,
                        size = 15.sp,
                        textOverflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(end = 15.dp),
                    painter = painterResource(id = R.drawable.ic_selector_right),
                    contentDescription = "right selector"
                )
            }
        }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun UserSelector(
    modifier: Modifier = Modifier,
    text: String = "Yo",
    onClicked: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, GrayBorderThin),
        backgroundColor = White,
        onClick = {
            onClicked?.invoke()
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.padding(end = 13.dp, start = 16.dp),
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "hide shipping options",
                tint = GraySinceTo
            )
            Column {
                MediumText(
                    text = "Quien recibe",
                    color = GraySinceTo,
                    size = 15.sp
                )
                MediumText(
                    text = text,
                    align = TextAlign.Center,
                    color = GrayMedium,
                    size = 15.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(end = 15.dp),
                painter = painterResource(id = R.drawable.ic_selector_right),
                contentDescription = "right selector"
            )
        }
    }
}

@Composable
fun <T> Spinner(
    modifier: Modifier = Modifier,
    dropDownModifier: Modifier = Modifier,
    items: List<T>,
    selectedItem: T,
    onItemSelected: (T) -> Unit,
    selectedItemFactory: @Composable (Modifier, T) -> Unit,
    dropdownItemFactory: @Composable (T, Int) -> Unit,
) {
    val expanded = remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxWidth()) {
        selectedItemFactory(
            Modifier
                .clickable { expanded.value = true },
            selectedItem
        )

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = dropDownModifier.fillMaxWidth()
        ) {
            items.forEachIndexed { index, element ->
                DropdownMenuItem(onClick = {
                    onItemSelected(items[index])
                    expanded.value = false
                }) {
                    dropdownItemFactory(element, index)
                }
            }
        }
    }
}

@Preview
@Composable
fun SelectorSpinner(
    modifier: Modifier = Modifier,
    list: List<String> = listOf("Seleccione una opcion", "Data 1", "Data 2")
) {
    Spinner(
        modifier = modifier.wrapContentSize(),
        dropDownModifier = Modifier.wrapContentSize(),
        items = list,
        selectedItem = "Seleccione una opcion",
        onItemSelected = {},
        selectedItemFactory = { modifierContainer, item ->
            Card(
                modifier = modifierContainer
                    .fillMaxWidth()
                    .height(60.dp),
                elevation = 0.dp,
                shape = RoundedCornerShape(10.dp),
                backgroundColor = GraySelector
            ) {
                Row(
                    modifier = modifierContainer
                        .padding(start = 16.dp, end = 20.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    MediumText(
                        text = item,
                        size = 15.sp
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_down),
                        contentDescription = "drop down arrow"
                    )
                }
            }

        },
        dropdownItemFactory = { item, _ ->
            Text(text = item)
        }
    )
}

@Composable
fun SelectorDetail(
    modifier: Modifier = Modifier, text: String = "",
    @DrawableRes iconRes: Int,
    onClicked: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .background(Color.White)
            .padding(horizontal = 30.dp)
            .clickable { onClicked() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = "comment icon"
        )
        BoldText(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            text = text, size = 13.sp
        )
        Icon(
            modifier = Modifier
                .rotate(180f)
                .width(21.dp)
                .height(12.dp),
            tint = GrayLetterArrow,
            painter = painterResource(id = R.drawable.ic_right_arrow_simbol),
            contentDescription = "comment icon"
        )
    }
}