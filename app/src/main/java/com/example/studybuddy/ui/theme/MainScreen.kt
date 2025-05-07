package com.example.studybuddy.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    var taskText by remember { mutableStateOf("") }
    val tasks = remember { mutableStateListOf("Task 1", "Task 2", "Task 3") }
    val checkStates = remember { mutableStateMapOf<String, Boolean>() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "StudyBuddy",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO: Start Study Session */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Start Study Session")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* TODO: View Progress */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("View Progress")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Task List
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text("Tasks", fontWeight = FontWeight.SemiBold)
                LazyColumn {
                    items(tasks) { task ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Checkbox(
                                checked = checkStates[task] ?: false,
                                onCheckedChange = { checked ->
                                    checkStates[task] = checked
                                }
                            )
                            Text(task)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = taskText,
                    onValueChange = { taskText = it },
                    label = { Text("New Task") }
                )
                Button(
                    onClick = {
                        if (taskText.isNotBlank()) {
                            tasks.add(taskText)
                            taskText = ""
                        }
                    }
                ) {
                    Text("+ Add Task")
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Progress Graph (placeholder)
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text("Total", fontWeight = FontWeight.SemiBold)
                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("This Week", fontWeight = FontWeight.SemiBold)
                Box(
                    modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray)
                )
            }
        }
    }
}
