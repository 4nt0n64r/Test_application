package com.a4nt0n64r.testapp.core

import android.app.Application
import com.a4nt0n64r.testapp.di.modules.applicationModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TestApplication)
            modules(applicationModules)
        }
    }
}
