package com.a4nt0n64r.testapp.ui.base

import moxy.MvpPresenter
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType


//Тут описаны события которые могут происходить (нажата кнопка, выделен элемент...)
@StateStrategyType(SkipStrategy::class)
interface ActivityPresenter {

    fun loadFragment(fragmentId: Int)

    fun onDestroy()
}

@StateStrategyType(SkipStrategy::class)
interface HomePresenter {
    fun onDestroy()
}

@StateStrategyType(SkipStrategy::class)
interface ClassesPresenter {
    fun onDestroy()
}

abstract class AbstractActivityPresenter : MvpPresenter<ActivityView>(), ActivityPresenter
abstract class AbstractHomePresenter : MvpPresenter<HomeFV>(), HomePresenter
abstract class AbstractClassesPresenter : MvpPresenter<ClassesFV>(), ClassesPresenter