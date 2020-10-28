package com.a4nt0n64r.testapp.ui

import com.a4nt0n64r.testapp.ui.base.AbstractActivityPresenter
import moxy.InjectViewState


@InjectViewState
class ActivityPresenterImpl : AbstractActivityPresenter() {

    override fun loadHomeFragment() {
        viewState.showFragment(HOME_FRAGMENT)
    }

    override fun loadClassesFragment() {
        viewState.showFragment(CLASSES_FRAGMENT)
    }
}