package com.alemicode.ui_toolkit.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alemicode.ui_toolkit.text.SemiBoldText

@Composable
fun ContentInfo(
    modifier : Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null
) {
    Row(
        modifier = modifier
            .border(width = 1.dp, color = Color.LightGray, RoundedCornerShape(5.dp))
            .clip(RoundedCornerShape(5.dp)),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        text?.let {
            SemiBoldText(
                text = it,
                fontSize = 14.sp
            )
        }

        icon?.let {
            Icon(
                imageVector = it,
                contentDescription = null,
                tint = Color.Black
            )
        }

    }
}