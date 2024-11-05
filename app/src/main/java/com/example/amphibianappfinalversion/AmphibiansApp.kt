package com.example.amphibianappfinalversion

import android.app.Application
import org.koin.core.context.startKoin
import com.example.amphibianappfinalversion.di.appModule
import org.koin.android.ext.koin.androidContext

class AmphibiansApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AmphibiansApp)
            modules(appModule)
        }
    }
}