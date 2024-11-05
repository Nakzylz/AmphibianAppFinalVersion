package com.example.amphibianappfinalversion.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.example.amphibianappfinalversion.data.AmphibianRepository
import com.example.amphibianappfinalversion.network.AmphibianService // Ensure this import is correct
import com.example.amphibianappfinalversion.viewmodel.AmphibianViewModel

val appModule = module {
    single { AmphibianService.create() }
    single { AmphibianRepository(get()) } // Provide the repository, passing the ApiService instance
    viewModel { AmphibianViewModel(get()) } // Inject the repository into the ViewModel
}

