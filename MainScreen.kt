package com.example.studybuddy.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    var tasks by remember { mutableStateOf(listOf("Task 1", "Task 2", "Task 3")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("StudyBuddy", fontSize = 28.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO: Start study session */ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Start Study Session")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* TODO: View progress */ },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("View Progress")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier.fillMaxSize()) {
            // Tasks List
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.LightGray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            ) {
                Text("Tasks", fontWeight = FontWeight.Bold)
                LazyColumn {
                    items(tasks) { task ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(vertical = 4.dp)
                        ) {
                            Checkbox(checked = false, onCheckedChange = {})
                            Text(task)
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        tasks = tasks + "Task ${tasks.size + 1}"
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Default.Add, contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Add Task")
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Progress Box
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.LightGray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            ) {
                Text("Total", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(16.dp))
                Text("This Week")
                // Replace with actual progress chart or data if needed
                repeat(5) {
                    Box(
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .height(16.dp)
                            .fillMaxWidth()
                            .background(Color.Blue, RoundedCornerShape(4.dp))
                    )
                }
            }
        }
    }
}

