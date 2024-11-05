package com.example.amphibianappfinalversion.ui.theme

import com.example.amphibianappfinalversion.model.Amphibian
import java.util.Collections.emptyList

data class AmphibianUiState(
    val amphibians: List<Amphibian> = emptyList(),
    val isLoading: Boolean = true,
    val error: String? = null
)