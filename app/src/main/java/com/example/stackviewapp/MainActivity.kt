package com.example.stackviewapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.stackviewapp.ui.StackScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.stackviewapp.ui.theme.StackViewAppTheme

class MainActivity : ComponentActivity() {

    // Initialize the ViewModel
    private val viewModel: StackViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Setting up the UI Theme
            StackViewAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // Call the main StackScreen composable, passing the ViewModel
                    StackScreen(viewModel = viewModel)
                }
            }
        }
    }
}
