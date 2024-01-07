package com.alemicode.ui_toolkit.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.alemicode.ui_toolkit.util.TextType

@Composable
fun BoldText(
    text: String,
    fontSize: TextUnit = 20.sp,
    fontColor: Color = Color.Black,
    modifier: Modifier = Modifier
) {

    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        fontWeight = FontWeight.Bold,
        color = fontColor
    )
}

@Composable
fun SemiBoldText(
    text: String,
    fontSize: TextUnit = 20.sp,
    fontColor: Color = Color.Black,
    modifier: Modifier = Modifier
) {

    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        fontWeight = FontWeight.SemiBold,
        color = fontColor
    )
}


@Composable
fun BodyText(
    text: String,
    fontSize: TextUnit = 14.sp,
    fontColor: Color = Color.Black,
    modifier: Modifier = Modifier,
    overflow: TextOverflow = TextOverflow.Ellipsis
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        color = fontColor,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun TitleText(
    text: String,
    fontSize: TextUnit = 17.sp,
    fontColor: Color = Color.Black,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        color = fontColor
    )

}


@Composable
fun CustomAnnotatedText(textTypes: List<TextType>) {
    Text(
        text = buildAnnotatedString {
            for (type in textTypes) {
                when (type) {
                    is TextType.TypeBody -> {
                        append(type.text)
                    }

                    is TextType.TypeBold -> {
                        withStyle(
                            style = BioSpanStyle()
                        ) {
                            append(type.text)
                        }
                    }
                }
            }
        },
        fontSize = 14.sp,
        color = Color.Black,
        maxLines = 1
    )

}

@Composable
fun BioSpanStyle() = SpanStyle(
    color = Color.Black,
    fontSize = 14.sp,
    fontWeight = FontWeight.SemiBold
)
