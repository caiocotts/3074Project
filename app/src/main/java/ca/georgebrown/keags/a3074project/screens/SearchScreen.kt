package ca.georgebrown.keags.a3074project.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ca.georgebrown.keags.a3074project.components.RestaurantCard
import ca.georgebrown.keags.a3074project.model.sampleRestaurants

@Composable
fun SearchScreen(modifier: Modifier = Modifier) {
    var search by rememberSaveable { mutableStateOf("") }

    val filteredRestaurants = remember(search) {
        if (search.isBlank()) {
            sampleRestaurants
        } else {
            sampleRestaurants.filter { restaurant ->
                restaurant.name.contains(search, ignoreCase = true) ||
                        restaurant.location.contains(search, ignoreCase = true)
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        TextField(
            value = search,
            onValueChange = { search = it },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search by name or location") },
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(
                items = filteredRestaurants,
                key = { it.id },
            ) { restaurant ->
                RestaurantCard(restaurant = restaurant)
            }
        }
    }
}
