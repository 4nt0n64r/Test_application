package com.a4nt0n64r.testapp.ui.fragments.home

import com.a4nt0n64r.testapp.domain.model.Homework
import com.a4nt0n64r.testapp.domain.model.StudySubject
import com.a4nt0n64r.testapp.domain.repository.Repository
import com.a4nt0n64r.testapp.ui.base.AbstractHomePresenter
import moxy.InjectViewState


@InjectViewState
class HomePresenterImpl(
    private val repo: Repository
) : AbstractHomePresenter() {

    private lateinit var classesList: List<StudySubject>
    private lateinit var homeworkList: List<Homework>

    override fun initializeClasses() {
        classesList = repo.getClasses()

        if (classesList.isNotEmpty()) {
            viewState.showClasses(classesList)
        }
    }

    override fun initializeHomework() {
        homeworkList = repo.getHomework()
        if (homeworkList.isNotEmpty()) {
            viewState.showHomework(homeworkList)
        }
    }
}

