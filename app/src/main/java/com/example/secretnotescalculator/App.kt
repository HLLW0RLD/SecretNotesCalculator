package com.example.secretnotescalculator

import android.app.Application
import com.example.secretnotescalculator.data.di.localDbModule
import com.example.secretnotescalculator.data.di.repositoryModule
import com.example.secretnotescalculator.data.di.useCaseModule
import com.example.secretnotescalculator.data.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
        startKoin {
            androidContext(this@App.baseContext)
            modules(
                viewModelModule,
                localDbModule,
                repositoryModule,
                useCaseModule
            )
        }.koin
    }

    companion object {
        var appInstance: App? = null
    }
}