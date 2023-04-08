package com.example.mycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycard.ui.theme.MyCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCardTheme {
                // A surface container using the 'background' color from the theme
                card()
            }
        }
    }
}

@Composable
fun cardList(iconPainter: Int, content: String) {
    Box(modifier = Modifier.padding(vertical = 10. dp)){
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
                ){
            Spacer(modifier = Modifier
                .size(50.dp)
                .background(Color.Transparent))
            Icon(painter = painterResource(id = iconPainter), contentDescription = null, tint = Color.White, modifier = Modifier.size(60.dp))
            Spacer(modifier = Modifier
                .size(20.dp)
                .background(Color.Transparent))
            Text(text=content, color = Color.White)
        }
    }

}

@Composable
fun card(){
    Surface(color = Color.Black) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.size(100.dp).background(Color.Transparent))
            profile()
            Spacer(modifier = Modifier.size(60.dp).background(Color.Transparent))
            group()
        }

    }
}

@Composable
fun profile(){
    val image = painterResource(id = R.drawable.apple_logo_white)
    Surface(color = Color.Black) {
        Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {

            Image(painter = image, contentDescription = null, modifier = Modifier.size(100.dp))
            Spacer(modifier = Modifier.size(20.dp).background(Color.Transparent))
            Text(
                text="Edmond Yang",
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                color = Color.White
            )
            Text(
                text="Apple Engineer",
                fontSize = 24.sp,
                color = Color.White
            )

        }

    }
}



@Composable
fun group() {
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
        cardList(R.drawable.phone, "0966-639-872")
        cardList(R.drawable.github, "Edmond-Yang")
        cardList(R.drawable.mail, "yuenho092590@gmail.com")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyCardTheme {
       card()
    }
}