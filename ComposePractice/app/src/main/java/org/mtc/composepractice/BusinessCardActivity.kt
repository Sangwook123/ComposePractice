package org.mtc.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import org.mtc.composepractice.ui.theme.ComposePracticeTheme

class BusinessCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting4()
                }
            }
        }
    }
}

@Composable
fun Greeting4(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.LightGray)
    ) {
        GreetingImage(
            title = "Sangwook Woo",
            body = "Android Developer",
            backgroundColor = Color.DarkGray,
            modifier = Modifier.weight(1f)
        )
        GreetingText(
            phone = "010-6677-2349", sns = "@w._.k2", email = "sangwook@gmail.com"
        )
    }
}

@Composable
fun GreetingImage(
    title: String,
    body: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .size(200.dp)
                .background(backgroundColor)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = body,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun GreetingText(phone: String, sns: String, email: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(modifier = modifier.padding(vertical = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.baseline_phone_24),
                contentDescription = null
            )
            Text(
                text = phone,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(modifier = modifier.padding(vertical = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.baseline_share_24),
                contentDescription = null
            )
            Text(
                text = sns,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Row(modifier = modifier.padding(top = 8.dp, bottom = 20.dp)) {
            Image(
                painter = painterResource(id = R.drawable.baseline_alternate_email_24),
                contentDescription = null
            )
            Text(
                text = email,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview4() {
    ComposePracticeTheme {
        Greeting4()
    }
}