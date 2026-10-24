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
    var isTopAligned by remember { mutableStateOf(true) }

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

            // Блок расписания с разным шрифтом (Exercise 3)
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Schedule",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(12.dp))
                // Кнопка для переключения verticalAlignment
                Button(
                    onClick = { isTopAligned = !isTopAligned },
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    Text(text = if (isTopAligned) "Alignment: Top" else "Alignment: CenterVertically")
                }
                //Строка расписания с разным размером текста
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = if (isTopAligned) Alignment.Top else Alignment.CenterVertically
                ) {
                    Text(text = "09:00 AM", style = MaterialTheme.typography.headlineSmall, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))

                    //Меньший шрифт для названия предмета
                    Text(text = "Mobile Development Lab\nRoom 305", style = MaterialTheme.typography.bodyMedium)

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