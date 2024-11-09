package com.fundox.fundbox.presentation.features.home.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fundox.fundbox.R
import com.fundox.fundbox.ui.theme.spacing


@Composable
fun ProfileBanner(
    modifier: Modifier = Modifier,
    url: String,
    onClick: () -> Unit,
    title: String,
) {
    Row(
        modifier = modifier
            .padding(top = 40.dp)
            .padding(horizontal = MaterialTheme.spacing.extraLarge)
            .height(100.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomImage(
            modifier = Modifier
                .size(50.dp),
            url = url,
            onClick = { onClick.invoke() },
            showPlaceHolder = false,
        )
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.large))
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            modifier = Modifier.weight(3f)
        )

        IconButton(onClick = {},modifier = Modifier.weight(1f)) {
            Icon(
                painter = painterResource(R.drawable.logout),
                contentDescription = "Profile Image",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(25.dp)
            )
        }
    }
}
@Preview
@Composable
fun ProfileBannerPreview() {
    ProfileBanner(
        url = "",
        onClick = { /*TODO*/ },
        title = "Title"
    )
}