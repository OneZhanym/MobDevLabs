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
import androidx.compose.material3.OutlinedButton

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
    // Состояние переключателя (toggle)
    var useSpaceBetween by remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween, // Чтобы действия были внизу
        horizontalAlignment = Alignment.Start
    ) {
        // Верхняя и средняя части Контент
        Column(modifier = Modifier.fillMaxWidth()) {
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

            // Расписание
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Schedule",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "• 09:00 AM - Mobile Development")
                Text(text = "• 11:00 AM - Database Systems")
                Text(text = "• 02:00 PM - Discrete Math")
            }
        }

        // Нижняя часть (Exercise 2: Action Row + Toggle)
        Column(modifier = Modifier.fillMaxWidth()) {
            // Кнопка-переключатель для демонстрации обоих вариантов
            Button(
                onClick = { useSpaceBetween = !useSpaceBetween },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(text = if (useSpaceBetween) "Mode: SpaceBetween" else "Mode: Center + SpacedBy")
            }

            // Нижняя строка действий (Action Row)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = if (useSpaceBetween) {
                    Arrangement.SpaceBetween
                } else {
                    Arrangement.Center
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Если не SpaceBetween, добавляем свойство spacedBy динамически или стилизуем кнопки
                if (useSpaceBetween) {
                    OutlinedButton(onClick = { }) { Text("Details") }
                    Button(onClick = { }) { Text("Share") }
                } else {
                    // Используем отдельные отступы или общий Arrangement.spacedBy(16.dp)
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedButton(onClick = { }) { Text("Details") }
                        Button(onClick = { }) { Text("Share") }
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
        CampusCardScreen()
    }
}