package com.a4nt0n64r.testapp.ui

import android.os.Bundle
import com.a4nt0n64r.testapp.R
import com.a4nt0n64r.testapp.ui.base.AbstractActivityPresenter
import com.a4nt0n64r.testapp.ui.base.ActivityView
import com.a4nt0n64r.testapp.ui.fragments.home.HomeFragment
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get

const val HOME_FRAGMENT = 0
const val CLASSES_FRAGMENT = 1
const val FRAGMENT_CHANGED = "fragment_changed"


class MainActivity : MvpAppCompatActivity(), ActivityView {

    @InjectPresenter
    lateinit var presenter: AbstractActivityPresenter

    @ProvidePresenter
    fun provide(): AbstractActivityPresenter = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.loadFragment(HOME_FRAGMENT)

    }

    override fun showSnackbar(msg_id: Int) {
        TODO("Not yet implemented")
    }

    override fun showFragment(fragmentId: Int) {
        when (fragmentId) {
            HOME_FRAGMENT -> {
                setUpHomeFragment()
            }
            CLASSES_FRAGMENT-> {
                setUpClassesFragment()
            }
        }
    }

    private fun setUpHomeFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, HomeFragment(), FRAGMENT_CHANGED)
            .commit()
    }

    private fun setUpClassesFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, HomeFragment(), FRAGMENT_CHANGED)
            .commit()
    }

    public override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}
