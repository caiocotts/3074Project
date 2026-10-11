package ca.georgebrown.keags.a3074project.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.georgebrown.keags.a3074project.ui.theme._3074ProjectTheme

@Composable
fun DetailsScreen(modifier: Modifier = Modifier) {
    var restaurantName by rememberSaveable { mutableStateOf("Restaurant Name") }
    var location by rememberSaveable { mutableStateOf("123 Street") }
    var rating by rememberSaveable { mutableStateOf("2/5") }
    var notes by rememberSaveable {
        mutableStateOf("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim")
    }
    var moreMenuExpanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier
            .fillMaxSize()
            .padding(24.dp), Arrangement.SpaceBetween, Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = restaurantName,
                onValueChange = { restaurantName = it },
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .weight(1f)
                    .height(60.dp)
            )
            Box {
                IconButton(onClick = { moreMenuExpanded = true }) {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "More options"
                    )
                }
                DropdownMenu(
                    expanded = moreMenuExpanded,
                    onDismissRequest = { moreMenuExpanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Delete") },
                        onClick = {
                            moreMenuExpanded = false
                            /* Handle delete click */
                        }
                    )
                }
            }
        }

        // Middle section: Location, Rating, Directions
        Column(
            modifier = Modifier.width(320.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Location Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Location:", fontSize = 16.sp)
                TextField(
                    value = location,
                    onValueChange = { location = it },
                    singleLine = true,
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp)
                )
            }

            // Rating Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Rating:", fontSize = 16.sp)
                TextField(
                    value = rating,
                    onValueChange = { rating = it },
                    singleLine = true,
                    modifier = Modifier
                        .width(100.dp)
                        .height(50.dp)
                )
            }
        }

        // Notes Section
        Column(
            modifier = Modifier.width(320.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(text = "Notes:", fontSize = 16.sp)
            TextField(
                value = notes,
                onValueChange = { notes = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            )
        }

        // Bottom Button
        Button(
            onClick = { /* Handle finalize changes click */ },
            modifier = Modifier
                .width(240.dp)
                .height(50.dp)
        ) {
            Text("Finalize Changes", fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _3074ProjectTheme {
        DetailsScreen()
    }
}

