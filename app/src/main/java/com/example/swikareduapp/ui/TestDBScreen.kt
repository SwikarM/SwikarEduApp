package com.example.swikareduapp.ui

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.swikareduapp.database.AppDatabase
import com.example.swikareduapp.viewmodel.AppViewModel
import com.example.swikareduapp.viewmodel.AppViewModelFactory

/**
 * Composable screen demonstrating Room Database interactions (adding users, clearing database, listing users).
 *
 * @param currentContext The Android [Context] used to construct the Room database instance.
 * @param modifier Optional [Modifier] for customizing layout behavior.
 */
@Composable
fun TestDBScreen(currentContext: Context, modifier: Modifier = Modifier) {
    // 1. Build or retrieve the Room database instance named "app_db"
    val db = Room.databaseBuilder(
        currentContext,
        AppDatabase::class.java,
        "app_db"
    ).build()

    // 2. Instantiate ViewModel using custom ViewModelProvider.Factory with the DAO
    val factory = AppViewModelFactory(db.appDao())
    val viewModel: AppViewModel = viewModel(factory = factory)

    // 3. Collect state flow of users as compose state, observing lifecycle events
    val users by viewModel.users.collectAsStateWithLifecycle(initialValue = emptyList())

    // Local state holding current text field input for username
    var name by remember { mutableStateOf("") }

    // Main layout container
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Text field for entering username
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Action buttons row
        Row {
            // Button to insert a user into the database
            Button(onClick = {
                if (name.isNotBlank()) {
                    viewModel.addUser(name)
                    name = ""
                }
            }) {
                Text("Add User")
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Button to clear all users from database
            Button(onClick = {
                viewModel.clearUsers()
            }) {
                Text("Clear")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Scrollable list displaying users retrieved from database
        LazyColumn {
            items(users) { user ->
                Text(
                    text = "ID: ${user.id}, ${user.username}, score=${user.score}, level=${user.level}"
                )
            }
        }
    }
}
