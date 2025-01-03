package com.param.learning

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            LearningTheme {
////                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
////                    NumberSelectorScreen(modifier = Modifier.padding(innerPadding))
////                }
//            }

            CreateBizCard()
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .safeContentPadding()
    ) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomImageProfile()
                HorizontalDivider(
                    modifier = Modifier.padding(top = 8.dp),
                    thickness = 2.dp
                )
                CreateInfo()

                Button(
                    modifier = Modifier.padding(top = 8.dp),
                    onClick = {
                        Log.d("CLICK", "CreateBizCard CLICKED")
                    }
                ) {
                    Text("Portfolio")
                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column {
        Text(
            text = "Miles P.",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.primary
            )
        )
        Text("Android Compose Programmer")
        Text("@themilesCompose")
    }
}

@Composable
private fun CustomImageProfile() {
    Card(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(4.dp),
        border = BorderStroke(0.5.dp, Color.LightGray),
        colors = CardDefaults.cardColors()
    ) {
        val imageVector =
            ImageVector.vectorResource(com.param.learning.R.drawable.baseline_person_outline_24)
        Image(
            modifier = Modifier
                .size(135.dp)
                .padding(5.dp),
            imageVector = imageVector,
            contentScale = ContentScale.Crop,
            contentDescription = "profile image"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CreateBizCardPreview() {
    CreateBizCard()
}