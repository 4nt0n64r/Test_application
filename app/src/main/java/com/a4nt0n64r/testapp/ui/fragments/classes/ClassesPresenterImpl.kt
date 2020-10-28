package com.a4nt0n64r.testapp.ui.fragments.classes

import com.a4nt0n64r.testapp.ui.base.AbstractClassesPresenter
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import moxy.InjectViewState

@InjectViewState
class ClassesPresenterImpl(
) : AbstractClassesPresenter() {


    private val job: Job by lazy { SupervisorJob() }


    override fun onDestroy() {

        job.cancel()
    }
}
