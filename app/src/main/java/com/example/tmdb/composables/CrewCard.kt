package com.example.tmdb.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdb.R
import com.example.tmdb.ui.theme.Colors
import com.example.tmdb.ui.theme.TmdbTheme

@Composable
fun CrewCard(
    modifier: Modifier,
    item: CrewItemViewState
) {
    Column() {
        Text(
            text = item.name,
            color = Colors.Blue700,
            fontWeight = FontWeight(800),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp)
        )
        Text(
            text = item.job,
            color = Colors.Blue700,
            fontWeight = FontWeight(300),
            fontSize = 15.sp,
            modifier = Modifier
                .padding(top = 2.dp, bottom = 10.dp, start = 15.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CrewCardPreview() {
    TmdbTheme() {
        CrewCard(
            modifier = Modifier.padding(end = 5.dp),
            item = CrewItemViewState(
                name = "Jon Favreau",
                job = "Director",
            )
        )
    }
}