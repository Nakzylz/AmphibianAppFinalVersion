package com.example.amphibianappfinalversion.ui.theme


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.Image
import coil.compose.rememberImagePainter
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.amphibianappfinalversion.model.Amphibian
import com.example.amphibianappfinalversion.viewmodel.AmphibianViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.viewModel

@Composable
fun AmphibianListScreen() {
    val viewModel: AmphibianViewModel = getViewModel()
    val uiState = viewModel.uiState

    if (uiState.isLoading) {
        // Show a loading indicator
        CircularProgressIndicator()
    } else if (uiState.error != null) {
        // Show an error message
        Text(text = "Error: ${uiState.error}")
    } else {
        // Show the list of amphibians
        LazyColumn {
            items(uiState.amphibians) { amphibian ->
                AmphibianItem(amphibian) // Display each amphibian item
            }
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(message: String, onRetry: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = message, color = Color.Red)
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onRetry) {
                Text("Retry")
            }
        }
    }
}

@Composable
fun AmphibianList(amphibians: List<Amphibian>) {
    LazyColumn {
        items(amphibians) { amphibian ->
            AmphibianItem(amphibian)
        }
    }
}

@Composable
fun AmphibianItem(amphibian: Amphibian) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(model = amphibian.imgSrc),
                contentDescription = "Amphibian image",
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = amphibian.name, style = MaterialTheme.typography.titleMedium)
                Text(text = amphibian.type, style = MaterialTheme.typography.labelLarge)
                Text(text = amphibian.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}