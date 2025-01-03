package com.param.evenodd

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NumberSelectorScreen(modifier: Modifier) {
    var selectedNumber by remember { mutableStateOf<Int?>(null) }
    var filterEven by remember { mutableStateOf(false) }
    var validationResultEven by remember { mutableStateOf<Boolean?>(null) }
    var validationResultOdd by remember { mutableStateOf<Boolean?>(null) }

    val allNumbers = (1..100).toList()
    val filteredNumbers = if (filterEven) {
        allNumbers.filter { it % 2 == 0 }
    } else {
        allNumbers.filter { it % 2 != 0 }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display Selected Number
        Text(
            text = selectedNumber?.toString() ?: "No Number Selected",
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Horizontal Cards List
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(allNumbers) { number ->
                NumberCard(number = number, isSelected = number == selectedNumber) {
                    selectedNumber = number
                    // Reset validation results on new selection
                    validationResultEven = null
                    validationResultOdd = null
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Even and Odd Buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    validationResultEven = selectedNumber?.let { it % 2 == 0 }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Even")
            }

            Button(
                onClick = {
                    validationResultOdd = selectedNumber?.let { it % 2 != 0 }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Odd")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Validation Result Images
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            validationResultEven?.let {
                Image(
                    painter = painterResource(id = if (it) R.drawable.ic_right else R.drawable.ic_wrong),
                    contentDescription = "Even Validation",
                    modifier = Modifier.size(50.dp)
                )
            }

            validationResultOdd?.let {
                Image(
                    painter = painterResource(id = if (it) R.drawable.ic_right else R.drawable.ic_wrong),
                    contentDescription = "Odd Validation",
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}

@Composable
fun NumberCard(number: Int, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundColor = if (isSelected) Color.Blue else Color.Gray
    val contentColor = if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(8.dp)
            .background(backgroundColor, shape = MaterialTheme.shapes.small)
            .height(80.dp)
            .width(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            color = contentColor,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NumberSelectorScreen(modifier = Modifier)
}