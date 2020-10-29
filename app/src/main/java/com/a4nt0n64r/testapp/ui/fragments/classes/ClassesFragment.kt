package com.a4nt0n64r.testapp.ui.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.a4nt0n64r.testapp.R
import com.a4nt0n64r.testapp.domain.model.StudySubject
import com.a4nt0n64r.testapp.ui.base.AbstractClassesPresenter
import com.a4nt0n64r.testapp.ui.base.ClassesFV
import kotlinx.android.synthetic.main.fragment_classes.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get
import org.koin.core.KoinComponent


class ClassesFragment : MvpAppCompatFragment(), ClassesFV, KoinComponent {

    val classesAdapter = ClassesAdapter()

    @InjectPresenter
    lateinit var presenter: AbstractClassesPresenter

    @ProvidePresenter
    fun provide(): AbstractClassesPresenter = get()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_classes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        classes_rv.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        classes_rv.adapter = classesAdapter

        presenter.initializeClasses()
        Log.d("frag","frag here")
    }

    override fun showClasses(classesList: List<StudySubject>) {
        classesAdapter.setData(classesList)
    }
}
