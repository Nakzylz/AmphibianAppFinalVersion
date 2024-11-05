package com.example.amphibianappfinalversion.data

import com.example.amphibianappfinalversion.model.Amphibian
import com.example.amphibianappfinalversion.network.AmphibianService

class AmphibianRepository(private val apiService: AmphibianService) {

    interface AmphibiansRepository {
        /** Retrieves list of amphibians from underlying data source */
        suspend fun getAmphibians(): List<Amphibian>
    }

    class DefaultAmphibiansRepository(
        private val apiService: AmphibianService
    ) : AmphibiansRepository {
        /** Retrieves list of amphibians from underlying data source */
        override suspend fun getAmphibians(): List<Amphibian> = apiService.getAmphibians()
    }

    // Create an instance of DefaultAmphibiansRepository here
    private val repository: AmphibiansRepository = DefaultAmphibiansRepository(apiService)

    // Now you can call getAmphibians() on the repository
    suspend fun getAmphibians(): List<Amphibian> {
        return repository.getAmphibians()
    }
}
