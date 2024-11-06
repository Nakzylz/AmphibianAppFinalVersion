package com.example.amphibianappfinalversion.data

import com.example.amphibianappfinalversion.model.Amphibian
import com.example.amphibianappfinalversion.network.AmphibianService

class AmphibianRepository(private val apiService: AmphibianService) {

    interface AmphibiansRepository {
        suspend fun getAmphibians(): List<Amphibian>
    }

    class DefaultAmphibiansRepository(
        private val apiService: AmphibianService
    ) : AmphibiansRepository {
        override suspend fun getAmphibians(): List<Amphibian> = apiService.getAmphibians()
    }

    private val repository: AmphibiansRepository = DefaultAmphibiansRepository(apiService)

    suspend fun getAmphibians(): List<Amphibian> {
        return repository.getAmphibians()
    }
}
