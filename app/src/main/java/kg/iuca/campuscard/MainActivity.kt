package kg.iuca.campuscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kg.iuca.campuscard.ui.theme.CampusCardLabTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.OutlinedButton
import androidx.compose.foundation.layout.width
import androidx.compose.ui.text.style.TextOverflow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusCardLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CampusCardScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CampusCardScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween, // Чтобы действия были внизу
        horizontalAlignment = Alignment.Start
    ) {
            // Заголовок (Exercise 1)
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Campus Card",
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(text = "Ada Lovelace")
                Text(text = "Student ID: 2026001")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Блок расписания (Exercise 4)
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Schedule",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(16.dp))

                //Строка расписания 1: С очень длинным названием курса
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Время (без weight, фиксированное пространство слева)
                    Text(text = "09:00 AM", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.width(12.dp))

                    // Название курса с Modifier.weight(1f) - занимает всю гибкую середину
                    Text(text = "Advanced Cross-Platform Mobile Application Development and Architecture",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.weight(1f), // Позволяет тексту занимать всю середину
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                        )

                    Spacer(modifier = Modifier.width(12.dp))

                    // Кабинет (без weight, всегда прижат к правому краю и не уходит за экран)
                    Text(
                        text = "Room 305",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                //Строка расписания 2: Стандартное короткое название
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "11:00 AM",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = "Database Systems",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Text(
                        text = "Lab 2",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
                }

        }
            }
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CampusCardLabTheme {
        CampusCardScreen()
    }
}