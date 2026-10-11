package ca.georgebrown.keags.a3074project.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.georgebrown.keags.a3074project.ui.theme._3074ProjectTheme

@Composable
fun Create(modifier: Modifier = Modifier) {
    var getName by rememberSaveable { mutableStateOf("") }
    var location by rememberSaveable { mutableStateOf("") }
    var rating by rememberSaveable { mutableStateOf("") }
    var notes by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Add New Entry",
            fontSize = 36.sp
        )
        Column(
            modifier = Modifier.width(320.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Name Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Name", fontSize = 18.sp)
                TextField(
                    value = getName,
                    onValueChange = { getName = it },
                    singleLine = true,
                    modifier = Modifier.width(210.dp).height(55.dp)
                )
            }

            // Location Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Location", fontSize = 18.sp)
                TextField(
                    value = location,
                    onValueChange = { location = it },
                    singleLine = true,
                    modifier = Modifier.width(210.dp).height(55.dp)
                )
            }

            // Rating Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Rating", fontSize = 18.sp)
                TextField(
                    value = rating,
                    onValueChange = { rating = it },
                    singleLine = true,
                    placeholder = { Text("/5") },
                    modifier = Modifier.width(100.dp).height(55.dp)
                )
            }
        }

        // Notes Section
        Column(
            modifier = Modifier.width(320.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "Notes", fontSize = 18.sp)
            TextField(
                value = notes,
                onValueChange = { notes = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
        }

        // Bottom Button
        Button(
            onClick = { /* Handle click */ },
            modifier = Modifier.width(200.dp)
        ) {
            Text("Add Now")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreatePreview() {
    _3074ProjectTheme {
        Create()
    }
}