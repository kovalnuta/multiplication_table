package com.example.multiplication_table
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.multiplication_table.ui.theme.Multiplication_tableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MultiplicationTable()
            }
        }
    }
@Preview
@Composable
fun MultiplicationTable() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // внутри каждой строки ячеечки создаем
        for (row in 1..9) {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                // 9 ячеек в одной строке
                for (col in 1..9) {
                    val result = row * col
                    val setiColor = when {
                        row == col -> Color.Green
                        (row + col) % 2 == 0 -> Color.Cyan
                        else -> Color.White
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxSize()
                            .background(setiColor)
                            .border(1.dp, Color.Black)
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = result.toString(),
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}


//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Multiplication_tableTheme {
//        Greeting("Android")
//    }
//}