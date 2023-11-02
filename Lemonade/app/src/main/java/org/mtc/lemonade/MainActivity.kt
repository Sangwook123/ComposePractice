package org.mtc.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.mtc.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lemonade()
                }
            }
        }
    }
}

@Composable
fun GreetingTopAppBarAndLemonade(title: String, modifier: Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    var randomSqueeze by remember { mutableStateOf((2..4).random()) }

    val image = when (currentStep) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val message = when (currentStep) {
        1 -> "Tap the lemon tree to select a lemon"
        2 -> "Keep tapping the lemon to squeeze it"
        3 -> "Tap the lemonade to drink it"
        else -> "Tap the empty glass to start again"
    }
    Box{
        GreetingAppBar()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                              when(currentStep){
                                  1 -> {currentStep++}
                                  2 -> {
                                      squeezeCount++
                                      if(squeezeCount >= randomSqueeze) {
                                          currentStep++
                                          randomSqueeze = (2..4).random()
                                          squeezeCount = 0
                                      }
                                  }
                                  3 -> {currentStep++}
                                  else -> currentStep = 1
                              }
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
                    shape = RoundedCornerShape(40.dp)
                ) {
                    GreetingImage(resourceId = image, modifier = modifier.padding(20.dp))
                }
                Text(
                    text = message,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}

@Composable
fun GreetingAppBar() {
    Box(
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
    ) {
        Text(
            text = "Lemonade",
            modifier = Modifier
                .align(Alignment.Center)
                .padding(vertical = 16.dp),
            fontWeight = Bold,
            fontSize = (20.sp)
        )
    }
}

@Composable
fun GreetingImage(resourceId: Int,  modifier: Modifier) {
    val image = painterResource(resourceId)
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Lemonade() {
    LemonadeTheme {
        GreetingTopAppBarAndLemonade(title = "Lemonade", modifier = Modifier)
    }
}