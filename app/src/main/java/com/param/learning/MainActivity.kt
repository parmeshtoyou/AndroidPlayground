package com.param.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.param.evenodd.NumberSelectorScreen
import com.param.learning.ui.theme.LearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NumberSelectorScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
