package com.a4nt0n64r.testapp.ui.fragments.home

import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.a4nt0n64r.testapp.R
import com.a4nt0n64r.testapp.domain.model.StudySubject
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class ClassesAdapter : ListDelegationAdapter<List<StudySubject>>() {

    init {
        delegatesManager.addDelegate(ClassElemDelegate())
    }

    fun setData(data: List<StudySubject>) {
        this.items = data
        notifyDataSetChanged()
    }
}

private class ClassElemDelegate :
    AbsListItemAdapterDelegate<StudySubject, StudySubject, ClassElemDelegate.ViewHolder>() {

    override fun isForViewType(
        item: StudySubject,
        items: List<StudySubject>,
        position: Int
    ): Boolean {
        return item is StudySubject
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.classes_card_skype,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(item: StudySubject, viewHolder: ViewHolder, payloads: List<Any>) {
        if (item.skype) {
            viewHolder.skypeButton.visibility = VISIBLE
        } else {
            viewHolder.skypeButton.visibility = INVISIBLE
        }
        viewHolder.name.text = item.name
        viewHolder.time.text = item.time
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name_of_subject)
        val skypeButton: LinearLayout = itemView.findViewById(R.id.skype_button)
        val time: TextView = itemView.findViewById(R.id.time_for_subject)
    }
}