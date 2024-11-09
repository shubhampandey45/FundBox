package com.fundox.fundbox.presentation.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.fundox.fundbox.R

@Composable
fun CustomImage(
    modifier: Modifier = Modifier,
    url: String,
    onClick: () -> Unit,
    showPlaceHolder: Boolean = false,
    progressModifier: Modifier = Modifier,
    progressIndicatorColor: Color = MaterialTheme.colorScheme.primary
) {
    Box(
        modifier = modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(Color.Transparent)
            .clickable { onClick.invoke() }
    ) {
        if (!showPlaceHolder) {
            SubcomposeAsyncImage(
                alignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(),
                model = url,
                contentDescription = "profile image",
                contentScale = ContentScale.Crop,
                loading = {
                    CircularProgressIndicator(
                        strokeWidth = 2.dp,
                        modifier = progressModifier
                            .size(50.dp)
                            .padding(0.dp),
                        color = progressIndicatorColor
                    )
                },
            )
        } else {
            Icon(
                painter = painterResource(R.drawable.no_profile),
                contentDescription = "Profile Image",
                tint = Color.Gray,
                modifier = Modifier
                    .fillMaxSize()
                    .border(1.dp, Color.Gray, CircleShape)
            )
        }
    }
}

@Preview
@Composable
fun CustomImagePreview() {
    CustomImage(
        url = "",
        onClick = { },
        showPlaceHolder = false,
    )
}