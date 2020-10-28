package com.a4nt0n64r.testapp.ui.base

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType


//функции вьюх. Всё что написано тут - то и может нарисовать вьюха, больше ничего.
@StateStrategyType(SingleStateStrategy::class)
interface ActivityView : MvpView {
    fun showFragment(fragmentId: Int)

    @StateStrategyType(SkipStrategy::class)
    fun showSnackbar(msg_id: Int)
}

@StateStrategyType(SingleStateStrategy::class)
interface HomeFV : MvpView {

}

@StateStrategyType(SingleStateStrategy::class)
interface ClassesFV : MvpView {

}