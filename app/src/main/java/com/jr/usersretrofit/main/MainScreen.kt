package com.jr.usersretrofit.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    viewModel: MainViewModel,
) {
    val state = viewModel.state


    if (state.projects.isNotEmpty()) {
        LazyColumn(Modifier.fillMaxWidth()) {
            items(state.projects) { project ->
                Column {
                    Text("id: ${project.id}")
                    Text("name: ${project.name}")
                    Text("description: ${project.desc}")
                    Divider()

                }
            }
        }
    }
}
