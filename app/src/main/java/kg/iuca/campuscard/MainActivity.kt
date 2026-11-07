package kg.iuca.campuscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kg.iuca.campuscard.ui.theme.CampusCardLabTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusCardLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        words = listOf("KOTLIN", "COMPOSE", "ANDROID", "STUDENT"),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(words: List<String>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        words.forEachIndexed { rowIndex, word ->
            // Считаем от 1: index 0 -> 1-я строка (нечётная), index 1 -> 2-я строка (чётная)
            val rowNumber = rowIndex + 1
            val isEvenRow = rowNumber % 2 == 0

            // 1. Нечётные строки - primary color, чётные — серый
            val rowBackgroundColor = if (isEvenRow) Color.LightGray else MaterialTheme.colorScheme.primary

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(rowBackgroundColor)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                word.forEachIndexed { letterIndex, char ->
                    // 2. Для чётных строк случайным образом выбираем жёлтый цвет фона плашки
                    val isYellowLetter = remember(rowIndex, letterIndex) {
                        isEvenRow && Random.nextFloat() < 0.4f
                    }

                    val boxBackgroundColor = if (isYellowLetter) Color.Yellow else Color.Transparent

                    // 3. Плашка буквы
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(boxBackgroundColor)
                            .border(1.dp, Color.Black),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = char.toString(),
                            color = if (isYellowLetter) Color.Black else if (isEvenRow) Color.Black else Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CampusCardLabTheme {
        Greeting(words = listOf("KOTLIN", "COMPOSE", "ANDROID"))
    }
}