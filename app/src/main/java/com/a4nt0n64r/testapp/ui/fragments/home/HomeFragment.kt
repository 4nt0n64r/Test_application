package com.a4nt0n64r.testapp.ui.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a4nt0n64r.testapp.R
import com.a4nt0n64r.testapp.ui.base.AbstractHomePresenter
import com.a4nt0n64r.testapp.ui.base.HomeFV
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get


class HomeFragment : MvpAppCompatFragment(), HomeFV {

    @InjectPresenter
    lateinit var presenter: AbstractHomePresenter

    @ProvidePresenter
    fun provide(): AbstractHomePresenter = get()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("asd","asd")

    }

}
