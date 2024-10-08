package com.boreal.allen.components.bottomnavigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.boreal.allen.components.BoldText
import com.boreal.allen.domain.SellerScreen
import com.boreal.allen.theme.GrayLetterShipping

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CustomBottomNavigation(
    currentScreenId: String,
    onItemSelected: (SellerScreen) -> Unit
) {
    val items = listOf(SellerScreen.HomeSellerScreen, SellerScreen.ProductsSellerScreen)

    Card(elevation = 5.dp) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(8.dp)
                .height(80.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                CustomBottomNavigationItem(
                    item = item,
                    isSelected = item.route == currentScreenId
                ) {
                    onItemSelected(item)
                }
            }
        }
    }

}

@ExperimentalAnimationApi
@Composable
fun CustomBottomNavigationItem(item: SellerScreen, isSelected: Boolean, onClick: () -> Unit) {

    val background =
        if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor =
        if (isSelected) MaterialTheme.colors.primary else GrayLetterShipping

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                tint = contentColor
            )

            AnimatedVisibility(visible = isSelected) {
                BoldText(
                    text = item.title,
                    color = contentColor,
                    size = 12.sp
                )
            }

        }
    }


}