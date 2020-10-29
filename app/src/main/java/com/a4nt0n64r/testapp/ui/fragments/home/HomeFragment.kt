package com.a4nt0n64r.testapp.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.a4nt0n64r.testapp.R
import com.a4nt0n64r.testapp.domain.model.Homework
import com.a4nt0n64r.testapp.domain.model.StudySubject
import com.a4nt0n64r.testapp.ui.base.AbstractHomePresenter
import com.a4nt0n64r.testapp.ui.base.HomeFV
import kotlinx.android.synthetic.main.fragment_home.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.get
import org.koin.core.KoinComponent


class HomeFragment : MvpAppCompatFragment(), HomeFV, KoinComponent {

    val classesAdapter = ClassesAdapter()
    val homeworkAdapter = HomeworkAdapter()

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

        classes_rv.layoutManager =
            LinearLayoutManager(activity!!.applicationContext, RecyclerView.HORIZONTAL, false)
        classes_rv.adapter = classesAdapter

        homework_rv.layoutManager =
            LinearLayoutManager(activity!!.applicationContext, RecyclerView.HORIZONTAL, false)
        homework_rv.adapter = homeworkAdapter

        presenter.initializeClasses()

    }

    override fun showClasses(classesList: List<StudySubject>) {
        classesAdapter.setData(classesList)
        presenter.initializeHomework()
    }

    override fun showHomework(homeworkList: List<Homework>) {
        homeworkAdapter.setData(homeworkList)
    }
}
