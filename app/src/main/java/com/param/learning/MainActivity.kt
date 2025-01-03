package com.param.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
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

    val buttonClickedState = remember { mutableStateOf(false) }

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
                CustomImageProfile(size = 150.dp)
                HorizontalDivider(
                    modifier = Modifier.padding(top = 8.dp),
                    thickness = 2.dp
                )

                CreateInfo()

                Button(
                    modifier = Modifier.padding(top = 8.dp),
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                    }
                ) {
                    Text("Portfolio")
                }

                if (buttonClickedState.value) {
                    Content()
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
private fun CustomImageProfile(size: Dp) {
    Card(
        modifier = Modifier
            .size(size)
            .padding(5.dp),
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(4.dp),
        border = BorderStroke(0.5.dp, Color.LightGray),
        colors = CardDefaults.cardColors()
    ) {
        val imageVector =
            ImageVector.vectorResource(R.drawable.baseline_person_outline_24)
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

@Preview
@Composable
private fun Content() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(
                data = listOf("Project 1", "Project 2", "Project 3", "Project 4")
            )
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),
                shape = RectangleShape,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    CustomImageProfile(size = 50.dp)
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(item, fontWeight = FontWeight.Bold)
                        Text("A great project", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}
