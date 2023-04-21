package com.thisisit.studentapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SubjectAdapter(private var list: List<Subjects>): RecyclerView.Adapter<SubjectAdapter.SubjectListHolder>() {

    private var onClickListener: OnClickListener? = null

    class SubjectListHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val subjectName: TextView = itemView.findViewById(R.id.subjectName)
        val subjectInstructor: TextView = itemView.findViewById(R.id.subjectInstructor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectListHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.subject_list_design, parent, false)

        return SubjectListHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SubjectListHolder, position: Int) {

        holder.subjectName.text = list[position].name
        holder.subjectInstructor.text = list[position].instructor

        //Add an onClickListener to the item.
        holder.itemView.setOnClickListener {
            if (onClickListener != null) {
                onClickListener!!.onClick(position, list[position])
            }
        }
    }

    // A function to bind the onclickListener.
    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    // onClickListener Interface
    interface OnClickListener {
        fun onClick(position: Int, model: Subjects)
    }
}