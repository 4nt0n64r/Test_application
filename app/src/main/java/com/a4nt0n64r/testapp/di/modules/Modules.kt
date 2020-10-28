package com.a4nt0n64r.testapp.di.modules

import com.a4nt0n64r.testapp.ui.ActivityPresenterImpl
import com.a4nt0n64r.testapp.ui.base.AbstractActivityPresenter
import com.a4nt0n64r.testapp.ui.base.AbstractClassesPresenter

import com.a4nt0n64r.testapp.ui.base.AbstractHomePresenter
import com.a4nt0n64r.testapp.ui.fragments.classes.ClassesPresenterImpl
import com.a4nt0n64r.testapp.ui.fragments.home.HomePresenterImpl
import org.koin.dsl.module

val applicationModules = module(override = true) {

    //    presenters
    factory<AbstractActivityPresenter> {
        ActivityPresenterImpl()
    }

    factory<AbstractHomePresenter> {
        HomePresenterImpl()
    }

    factory<AbstractClassesPresenter> {
        ClassesPresenterImpl(
        )
    }
}
