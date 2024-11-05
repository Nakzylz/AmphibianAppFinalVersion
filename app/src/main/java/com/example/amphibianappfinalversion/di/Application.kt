package com.example.amphibianappfinalversion

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.example.amphibianappfinalversion.di.appModule  // Import your Koin module

class AmphibianApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AmphibianApp)
            modules(appModule)
        }
    }
}
