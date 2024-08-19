package com.example.swipetounlock

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.swipetounlock.ui.theme.buttonColor
import com.example.swipetounlock.ui.theme.deepBlue
import com.example.swipetounlock.ui.theme.textColor
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Quote(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val quotes = listOf(
        "Discipline is the bridge between goals and accomplishment.",
        "Success is nothing more than a few simple disciplines, practiced every day.",
        "Without discipline, there’s no life at all.",
        "Discipline is choosing between what you want now and what you want most.",
        "The pain of discipline is far less than the pain of regret.",
        "Discipline is the soul of an army. It makes small numbers formidable; procures success to the weak, and esteem to all.",
        "Through discipline comes freedom.",
        "Discipline yourself, and others won’t need to.",
        "It’s not about perfect. It’s about effort. And when you implement that effort into your life every single day, that’s where transformation happens.",
        "Discipline is the foundation upon which all success is built. Lack of discipline inevitably leads to failure.",
        "Self-discipline begins with the mastery of your thoughts. If you don’t control what you think, you can’t control what you do.",
        "Discipline is the refining fire by which talent becomes ability.",
        "Discipline is the key to unlocking your true potential.",
        "The first and best victory is to conquer self.",
        "We must all suffer one of two things: the pain of discipline or the pain of regret.",
        "Self-discipline is when your conscience tells you to do something and you don’t talk back.",
        "Discipline is the art of making the subconscious conscious.",
        "Your level of success is determined by your level of discipline and perseverance.",
        "Discipline is doing what needs to be done, even if you don’t want to do it.",
        "The cost of discipline is always less than the price of regret."
    )
    val randomQuote = quotes[Random.nextInt(quotes.size)]


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(deepBlue),
        contentAlignment = Alignment.Center
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = buttonColor
            ),
            title = { /*TODO*/ },
            navigationIcon = {
            IconButton(onClick = {
                 navController.navigate("home")            }) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(60.dp)
                )
            }
        },
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CardApp(
                text = randomQuote, height = 300.dp, width = 250.dp
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardApp(
    text: String, height: Dp, width: Dp, onClick: () -> Unit = {},
) {

    Card(
        onClick = { onClick() },
        modifier = Modifier
            .size(height = height, width = width)
            .border(
                border = BorderStroke(1.dp, color = textColor),
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))

    ) {
        Box(
            modifier = Modifier
                .background(deepBlue)
                .fillMaxSize()
                .padding(15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                modifier = Modifier,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle(R.font.inter_18pt_medium),
                color = textColor,
                maxLines = 5,
            )
        }
    }
}




