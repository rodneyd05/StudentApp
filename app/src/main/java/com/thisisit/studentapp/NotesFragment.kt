package com.thisisit.studentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.thisisit.studentapp.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {
    private lateinit var notesBinding: FragmentNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        //If viewBinding is used, View should be made non-nullable instead of View?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_your_books, container, false)
        notesBinding = FragmentNotesBinding.inflate(layoutInflater)
        return notesBinding.root
    }

    //call and override this function
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //use context instead of (this@NotesFragment)
        notesBinding.notesRecyclerView.layoutManager = LinearLayoutManager(context)

        val thisSubject = arguments?.getParcelable<Subjects>(MainActivity.CONTENT_OBJECT)

        if (thisSubject != null) {
            val detailsAdapter = DetailsAdapter(thisSubject.notes)
            notesBinding.notesRecyclerView.adapter = detailsAdapter
        }
    }

}