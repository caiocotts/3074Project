package ca.georgebrown.keags.a3074project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import ca.georgebrown.keags.a3074project.screens.SearchScreen
import ca.georgebrown.keags.a3074project.screens.Edit
import ca.georgebrown.keags.a3074project.screens.DetailsScreen
import ca.georgebrown.keags.a3074project.screens.Nav
import ca.georgebrown.keags.a3074project.ui.theme._3074ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _3074ProjectTheme {
                Nav()
            }
        }
    }
}
