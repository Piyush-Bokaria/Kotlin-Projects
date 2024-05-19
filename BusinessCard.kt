package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column {
        Card(
            name = stringResource(R.string.name),
            position = stringResource(R.string.position),
            phone = stringResource(R.string.phone),
            social = stringResource(R.string.mediaacc),
            mail = stringResource(R.string.mail)
        )
    }
}

@Composable
private fun Card(name: String, position: String,phone : String,
                 social : String,
                 mail : String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxSize()
            .background(Color(0xFFCFE5D0))
            .padding(top = 250.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = modifier
            .background(Color(0xff0e303f))
            .width(100.dp)) {
            Image(
                painter = painterResource(
                    id = R.drawable.android_logo
                ),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
        }
        Text(
            text = name,
            fontSize = 34.sp,
            modifier = modifier.padding(top = 8.dp),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = position,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(top = 8.dp, bottom = 320.dp),
            color = Color(0xFF3ddc84)
        )

        Row(modifier = modifier.padding(bottom = 20.dp)){
            Column(modifier.padding(start = 40.dp, end = 10.dp)){
                Image(
                    painter = painterResource(id = R.drawable.phone_24dp),
                    contentDescription = null,
                    modifier = modifier.padding(bottom = 15.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.share_24dp__1_),
                    contentDescription = null,
                    modifier = modifier.padding(bottom = 20.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.phone_24dp),
                    contentDescription = null
                )
            }
            Column{
                Text(
                    text = phone,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(bottom = 30.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = social,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(bottom = 30.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = mail,
                    fontWeight = FontWeight.Bold
                )
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}