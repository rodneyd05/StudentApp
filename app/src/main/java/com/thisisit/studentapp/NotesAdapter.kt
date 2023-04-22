package com.thisisit.studentapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private var list: List<Content>): RecyclerView.Adapter<NotesAdapter.NotesHolder>() {

    class NotesHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val heading: TextView = itemView.findViewById(R.id.itemHeading)
        val content: TextView = itemView.findViewById(R.id.itemContent)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotesHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.subject_content_design, parent, false)

        return NotesHolder(view)
    }

    override fun onBindViewHolder(holder: NotesHolder, position: Int) {
        holder.heading.text = list[position].heading
        holder.content.text = list[position].content
    }

    override fun getItemCount(): Int {
        return list.size
    }
}