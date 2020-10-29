package com.a4nt0n64r.testapp.ui.fragments.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.a4nt0n64r.testapp.R
import com.a4nt0n64r.testapp.domain.model.Homework
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class HomeworkAdapter : ListDelegationAdapter<List<Homework>>() {

    init {
        delegatesManager.addDelegate(HomeworkElemDelegate())
    }

    fun setData(data: List<Homework>) {
        this.items = data
        notifyDataSetChanged()
    }
}

private class HomeworkElemDelegate :
    AbsListItemAdapterDelegate<Homework, Homework, HomeworkElemDelegate.ViewHolder>() {

    override fun isForViewType(item: Homework, items: List<Homework>, position: Int): Boolean {
        return item is Homework
    }

    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.homework_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(item: Homework, viewHolder: ViewHolder, payloads: List<Any>) {
        viewHolder.name.text = item.name
        viewHolder.deadline.text = "${item.daysLeft} days left"
        viewHolder.descriptin.text = item.description
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name_of_subject)
        val deadline: TextView = itemView.findViewById(R.id.days_left)
        val descriptin: TextView = itemView.findViewById(R.id.description)
    }
}
