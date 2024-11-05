package com.example.amphibianappfinalversion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibianappfinalversion.data.AmphibianRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.amphibianappfinalversion.ui.theme.AmphibianUiState

class AmphibianViewModel (private val repository: AmphibianRepository) : ViewModel() {
    var uiState by mutableStateOf(AmphibianUiState())

    init {
        loadAmphibians()
    }

    private fun loadAmphibians() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            try {
                val amphibians = repository.getAmphibians()
                uiState = AmphibianUiState(amphibians = amphibians, isLoading = false)
            } catch (e: Exception) {
                uiState = uiState.copy(isLoading = false, error = e.message)
            }
        }
    }
}

