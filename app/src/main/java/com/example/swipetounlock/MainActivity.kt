package com.example.swipetounlock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.swipetounlock.ui.theme.SwipeToAccessButton
import com.example.swipetounlock.ui.theme.deepBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Nav()

        }
    }
}

@Composable
fun Welcome(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(color = deepBlue)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = modifier.height(150.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.small_logo),
                contentDescription = null,
                modifier = modifier
                    .size(
                        50.dp
                    )
                    .padding(end = 7.dp)
            )
            Text(
                text = "VortexCraft",
                color = Color.White,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = modifier.height(50.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Swipe to Unlock", color = Color.White.copy(alpha = 0.5f), fontSize = 28.sp

            )
            Text(
                text = "Motivational Quotes",
                color = Color.White.copy(alpha = 0.5f),
                fontSize = 28.sp

            )
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                alignment = Alignment.BottomStart,
                painter = painterResource(id = R.drawable.vector),
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
            SwipeToAccessButton(
                navController
            )
        }
    }
}


