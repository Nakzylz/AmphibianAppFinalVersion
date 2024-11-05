package com.example.amphibianappfinalversion.network

import com.example.amphibianappfinalversion.model.Amphibian
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.http.GET

interface AmphibianService {
    @GET("amphibians") // The endpoint for fetching amphibians
    suspend fun getAmphibians(): List<Amphibian>

    companion object {
        fun create(): AmphibianService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://android-kotlin-fun-mars-server.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(AmphibianService::class.java)
        }
    }

}