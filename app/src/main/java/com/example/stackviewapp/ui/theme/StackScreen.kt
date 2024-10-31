package com.example.stackviewapp.ui.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.stackviewapp.StackViewModel

@Composable
fun StackScreen(viewModel: StackViewModel) {
    val stackItems by viewModel.stackItems.collectAsState()

    Column {
        stackItems.forEach { item ->
            StackItem(
                title = item.title,
                isExpanded = item.isExpanded,
                onClick = { viewModel.onItemClicked(item.id) }
            )
        }
    }
}
