package com.boreal.allen.ui.client.productgraph.question

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavHostController
import com.boreal.allen.R
import com.boreal.allen.components.*
import com.boreal.allen.domain.model.QuestionModel
import com.boreal.allen.extensions.drawColoredShadow
import com.boreal.allen.theme.BlueTransparent
import com.boreal.allen.theme.GrayBackgroundMain
import com.boreal.allen.theme.GrayLetterShipping
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable
fun ViewQuestionCompose(navController: NavHostController? = null) {
    val systemUiController = rememberSystemUiController()
    if (isSystemInDarkTheme()) {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = White
        )
    }

    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(GrayBackgroundMain),
        constraintSet = ConstraintSet {
            val toolbarTitle = createRefFor("toolbarTitle")
            val search = createRefFor("search")
            val bottomQuestion = createRefFor("bottomQuestion")
            val content = createRefFor("content")
            val guideLine = createGuidelineFromTop(0.09f)

            val guideLineSearch = createGuidelineFromTop(0.24f)

            constrain(toolbarTitle) {
                top.linkTo(parent.top)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(search) {
                top.linkTo(guideLine)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(guideLineSearch)
                width = Dimension.matchParent
                height = Dimension.wrapContent
            }
            constrain(content) {
                top.linkTo(guideLineSearch, 0.dp)
                bottom.linkTo(bottomQuestion.top, margin = 30.dp)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
            constrain(bottomQuestion) {
                bottom.linkTo(parent.bottom)
                width = Dimension.matchParent
                height = Dimension.fillToConstraints
            }
        }) {
        SearcherWithButton(
            modifier = Modifier
                .background(White)
                .padding(top = 30.dp, end = 30.dp, start = 30.dp, bottom = 45.dp)
                .fillMaxSize()
                .layoutId("search"),
            value = "",
            placeHolder = "Buscar pregunta..."
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(GrayBackgroundMain)
                .layoutId("content")
        ) {

            itemsIndexed(
                listOf(
                    QuestionModel(
                        question = "¿Sirve para 220v?",
                        imageUser = "",
                        likesList = listOf("33", "33333", "33332"),
                        answerList = listOf("Si, incluso para 110v")
                    ), QuestionModel(
                        question = "¿Es nuevo el articulo?",
                        imageUser = "",
                        likesList = listOf("33", "333"),
                        answerList = listOf(
                            "¡Asi es, todos nuestros " +
                                    "articulos son nuevos " +
                                    "completamente!", "A precios bajos"
                        )
                    ), QuestionModel(
                        question = "¿Costo de envio?",
                        imageUser = "",
                        answerList = listOf(
                            "¡Comprando 4 el envio es gratis¡"
                        )
                    )
                )
            ) { index, item ->
                QuestionItem(
                    text = item.question,
                    likesList = item.likesList,
                    answerList = item.answerList
                )
            }
        }
        ToolbarTitle(
            modifier = Modifier.layoutId("toolbarTitle"),
            titleText = "Preguntas", backClicked = {
                navController?.navigateUp()
            },
            endIcon = R.drawable.ic_questions_icon
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .layoutId("bottomQuestion"),
            elevation = 9.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(White),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.padding(
                        start = 30.dp, end = 30.dp,
                        bottom = 18.dp
                    ),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    RegularText(
                        text = "Preguntar",
                        color = GrayLetterShipping,
                        size = 18.sp
                    )
                    OutlinedTextField(
                        modifier = Modifier.padding(bottom = 30.dp, top = 18.dp),
                        value = "",
                        onValueChange = {},
                        placeHolder = "Escribe una pregunta al vendedor",
                    )
                    ShadowButton(
                        modifier = Modifier
                            .padding(bottom = 18.dp)
                            .fillMaxWidth()
                            .drawColoredShadow(
                                color = BlueTransparent, alpha = 1f, borderRadius = 10.dp,
                                offsetY = 6.dp, offsetX = 5.dp, blurRadius = 10.dp
                            ),
                        text = "Hacer pregunta"
                    )
                }
            }
        }
    }
}