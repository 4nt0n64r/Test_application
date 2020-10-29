package com.a4nt0n64r.testapp.ui.base

import com.a4nt0n64r.testapp.domain.model.Homework
import com.a4nt0n64r.testapp.domain.model.StudySubject
import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType


//функции вьюх. Всё что написано тут - то и может нарисовать вьюха, больше ничего.
@StateStrategyType(SingleStateStrategy::class)
interface ActivityView : MvpView {
    fun showFragment(fragmentId: Int)
}

@StateStrategyType(SingleStateStrategy::class)
interface HomeFV : MvpView {
    fun showClasses(classesList: List<StudySubject>)
    fun showHomework(homeworkList: List<Homework>)
}

@StateStrategyType(SingleStateStrategy::class)
interface ClassesFV : MvpView {
    fun showClasses(classesList: List<StudySubject>)
}