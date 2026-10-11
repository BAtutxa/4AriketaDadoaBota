package com.example.a4ariketadadoabota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a4ariketadadoabota.ui.theme._4AriketaDadoaBotaTheme

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
    Box(modifier.fillMaxSize()){
        DadoaBotaFondoa ()
        DadoaBotaTestua()
    }
}

@Composable
fun DadoaBotaFondoa(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.fondoa4)

    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun DadoaBotaTestua(modifier: Modifier = Modifier){

    var zbk by remember { mutableStateOf<Int?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { zbk = (1..6).random() }) {
                Text(text = "Jaurti dadoa")
            }
        }

        Spacer(modifier = modifier.height(36.dp))

        zbk?.let { zenbakia ->

            val imageDado = when (zenbakia) {
                1 -> R.drawable.dadoa_1
                2 -> R.drawable.dadoa_2
                3 -> R.drawable.dadoa_3
                4 -> R.drawable.dadoa_4
                5 -> R.drawable.dadoa_5
                6 -> R.drawable.dadoa_6
                else -> R.drawable.dadoa_1
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {

                Image(
                    painter = painterResource(id = imageDado),
                    contentDescription = null,
                    modifier = modifier.size(100.dp)
                )

                Spacer(modifier = modifier.width(16.dp))

                Text(
                    text = "$zenbakia",
                    fontSize = 28.sp
                )
            }
        }
    }

}

@Preview (showBackground = true)
@Composable
fun DadoaBotaPreview (){
    _4AriketaDadoaBotaTheme {
        DadoaBota()
    }
}


