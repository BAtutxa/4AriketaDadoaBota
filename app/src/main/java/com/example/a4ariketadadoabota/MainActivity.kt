package com.example.a4ariketadadoabota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.a4ariketadadoabota.ui.theme._4AriketaDadoaBotaTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp

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
fun DadoaBota(modifier: Modifier = Modifier) {
    var numeroa by remember { mutableStateOf(1) }

    val imagen = when (numeroa) {
        1 -> R.drawable.dadoa_1
        2 -> R.drawable.dadoa_2
        3 -> R.drawable.dadoa_3
        4 -> R.drawable.dadoa_4
        5 -> R.drawable.dadoa_5
        else -> R.drawable.dadoa_6
    }

    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.irudia),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(0.4f))
            Text(text = "Dadoa bota:", fontSize = 40.sp, color = Color.White)
            Spacer(modifier = Modifier.weight(0.1f))
            Button(onClick = { numeroa = (1..6).random() }) {
                Text("Bota", color = Color.Blue)
            }
            Spacer(modifier = Modifier.weight(0.1f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Zenbakia: ", fontSize = 28.sp, color = Color.White)
                Text(text = "$numeroa", fontSize = 40.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.weight(0.1f))
            Image(
                painter = painterResource(imagen),
                contentDescription = "Dadoa $numeroa",
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.weight(0.4f))
        }
    }
}@Preview(showBackground = true)
@Composable
fun DadoPreview() {
    _4AriketaDadoaBotaTheme {
        DadoaBota()
    }
}