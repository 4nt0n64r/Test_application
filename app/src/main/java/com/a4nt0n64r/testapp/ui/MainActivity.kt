package com.a4nt0n64r.testapp.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.a4nt0n64r.testapp.R
import com.a4nt0n64r.testapp.ui.base.AbstractActivityPresenter
import com.a4nt0n64r.testapp.ui.base.ActivityView
import com.a4nt0n64r.testapp.ui.fragments.home.ClassesFragment
import com.a4nt0n64r.testapp.ui.fragments.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
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

        setOnNavigationItemListener()

        presenter.loadHomeFragment()

    }

    override fun showFragment(fragmentId: Int) {
        when (fragmentId) {
            HOME_FRAGMENT -> {
                setUpHomeFragment()
            }
            CLASSES_FRAGMENT -> {
                setUpClassesFragment()
            }
        }
    }

    private fun setUpHomeFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.frame,
                HomeFragment(), FRAGMENT_CHANGED
            )
            .commit()
    }

    private fun setUpClassesFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.frame,
                ClassesFragment(), FRAGMENT_CHANGED
            )
            .commit()
    }

    public override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun setOnNavigationItemListener() {
        val onNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        showFragment(HOME_FRAGMENT)
                    }
                    R.id.navigation_classes -> {
                        showFragment(CLASSES_FRAGMENT)
                    }
                    R.id.navigation_feature1 -> {
                        Log.d("TODO","Not implemented.")
                    }
                    R.id.navigation_feature2 -> {
                        Log.d("TODO","Not implemented.")
                    }
                }
                return@OnNavigationItemSelectedListener true
            }

        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

}
