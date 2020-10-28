package com.a4nt0n64r.testapp.ui.fragments.home

import com.a4nt0n64r.testapp.ui.base.AbstractHomePresenter
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import moxy.InjectViewState


@InjectViewState
class HomePresenterImpl(
) : AbstractHomePresenter() {


    private val job: Job by lazy { SupervisorJob() }



    override fun onDestroy() {

        job.cancel()
    }
}
