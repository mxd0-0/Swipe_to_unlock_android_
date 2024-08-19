package com.example.swipetounlock.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.ExperimentalWearMaterialApi
import androidx.wear.compose.material.FractionalThreshold
import androidx.wear.compose.material.SwipeableState
import androidx.wear.compose.material.rememberSwipeableState
import androidx.wear.compose.material.swipeable
import com.example.swipetounlock.R
import kotlin.math.roundToInt

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalWearMaterialApi::class)
@Composable
fun SwipeToAccessButton(
   navController: NavController,
    /** onNavigate: () -> Unit
    ,*/
    modifier: Modifier = Modifier
) {//width.toPx() to "End"
    val dragnet = painterResource(id = R.drawable.btn)
    val width = 300.dp
    val swappableState: SwipeableState<Int> = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { width.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1)
    var show by remember { mutableStateOf(false) }



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                bottom = 150.dp
            )
    ) {
        Box(
            modifier = Modifier
                .width(width)
                .clip(CircleShape)
                .border(
                    BorderStroke(1.5.dp, Color.White), shape = CircleShape
                )
                .swipeable(
                    state = swappableState,
                    anchors = anchors,
                    thresholds = { _, _ -> FractionalThreshold(0.7f) },
                    orientation = Orientation.Horizontal
                )
                .background(Color.Transparent)
        ) {


            Row(modifier = Modifier.fillMaxWidth()) {
                Icon(painter = dragnet,
                    contentDescription = "DragButton",
                    tint = Color.White,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .offset { IntOffset(swappableState.offset.value.roundToInt(), 0) }
                        .padding(9.dp)


                )
                Spacer(modifier = Modifier.width(40.dp))
                if (swappableState.offset.value == 0f) {

                    Text(
                        text = "SWIPE TO UNLOCK",
                        fontFamily = FontFamily.SansSerif, // sans-serif font
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }

            }
        }
        if (show) { navController.navigate("quotes") }

    }

    LaunchedEffect(swappableState.currentValue) {
        if (swappableState.currentValue == 1) {
            show = true
              swappableState.animateTo(0)
        }
    }
}

@Preview
@Composable
private fun Swip() {

}