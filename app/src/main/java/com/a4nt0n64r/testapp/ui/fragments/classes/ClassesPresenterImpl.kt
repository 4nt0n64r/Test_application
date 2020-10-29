package com.a4nt0n64r.testapp.ui.fragments.classes

import com.a4nt0n64r.testapp.domain.model.StudySubject
import com.a4nt0n64r.testapp.domain.repository.Repository
import com.a4nt0n64r.testapp.ui.base.AbstractClassesPresenter
import moxy.InjectViewState

@InjectViewState
class ClassesPresenterImpl(private val repo: Repository) : AbstractClassesPresenter() {

    private lateinit var classesList: List<StudySubject>

    override fun initializeClasses() {
        classesList = repo.getClasses()
        viewState.showClasses(classesList)
    }
}
