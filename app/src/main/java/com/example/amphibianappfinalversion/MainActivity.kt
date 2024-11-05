package com.example.amphibianappfinalversion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.amphibianappfinalversion.ui.theme.AmphibianListScreen
import com.example.amphibianappfinalversion.ui.theme.AmphibiansAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibianListScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAmphibianListScreen() {
    AmphibiansAppTheme {
        AmphibianListScreen()
    }
}