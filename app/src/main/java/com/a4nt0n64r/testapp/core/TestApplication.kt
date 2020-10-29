package com.a4nt0n64r.testapp.core

import android.app.Application
import android.content.res.Resources
import com.a4nt0n64r.testapp.di.modules.applicationModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        instance = this
        res = resources

        val context = this
        startKoin {
            androidContext(this@TestApplication)
            modules(applicationModules)
        }
    }

    companion object {
        var instance: TestApplication? = null
            private set
        private var res: Resources? = null

        val resourses: Resources?
            get() = res
    }
}
