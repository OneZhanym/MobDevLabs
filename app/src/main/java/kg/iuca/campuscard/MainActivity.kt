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
        // Вызов extracted-функции ProfileHeader
        ProfileHeader(
            name = "Ada Lovelace",
            status = "Student ID: 2026001"
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Секция расписания
        Text(
            text = "Schedule",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Вызовы extracted-функции ScheduleRow
        ScheduleRow(
            time = "09:00 AM",
            title = "Advanced Cross-Platform Mobile Application Development and Architecture",
            room = "Room 304"
        )

        Spacer(modifier = Modifier.height(12.dp))

        ScheduleRow(
            time = "11:00 AM",
            title = "Database Systems",
            room = "Lab 2"
        )

        Spacer(modifier = Modifier.height(12.dp))

        ScheduleRow(
            time = "02:00 PM",
            title = "Discrete Math",
            room = "Room 101"
        )
    }
}

//Extracted Composable 1: Заголовок профиля
@Composable
fun ProfileHeader(
    name: String,
    status: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Campus Card",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(text = name)
        Text(text = status)
    }
}

// Extracted Composable 2: Строка расписания
@Composable
fun ScheduleRow(
    time: String,
    title: String,
    room: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = time,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = room,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CampusCardLabTheme {
        CampusCardScreen()
    }
}