package com.example.a4ariketadadoabota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a4ariketadadoabota.ui.theme._4AriketaDadoaBotaTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _4AriketaDadoaBotaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DadoaBota(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DadoaBota (modifier: Modifier = Modifier){
    var balioa by remember { mutableStateOf(1) }
    val ruta = when (balioa) {
        1 -> R.drawable.dadoa_1
        2 -> R.drawable.dadoa_2
        3 -> R.drawable.dadoa_3
        4 -> R.drawable.dadoa_4
        5 -> R.drawable.dadoa_5
        else -> R.drawable.dadoa_6
    }
    Box(
    ){
        Image(
            painter = painterResource(R.drawable._4ariketafondo),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
                .padding(20.dp)) {
            Image(
                painter = painterResource(ruta),
                contentDescription = null
            )
            Button(onClick = { balioa = (1..6).random()
            }) {
                Text(
                    text = "Klikatu"
                )
            }

        }
    }
}

@Preview
@Composable
fun DadoaBotaPreview ()  {
    _4AriketaDadoaBotaTheme  {
        DadoaBota()
    }
}
