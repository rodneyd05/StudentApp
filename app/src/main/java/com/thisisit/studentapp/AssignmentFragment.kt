package com.thisisit.studentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.thisisit.studentapp.databinding.FragmentAssignmentBinding

class AssignmentFragment : Fragment() {
    private lateinit var assignmentBinding: FragmentAssignmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        //If viewBinding is used, View should be made non-nullable instead of View?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_your_books, container, false)
        assignmentBinding = FragmentAssignmentBinding.inflate(layoutInflater)
        return assignmentBinding.root
    }

    //call and override this function
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //use context instead of (this@AssignmentFragment)
        assignmentBinding.assignmentRecyclerView.layoutManager = LinearLayoutManager(context)

        val thisSubject = arguments?.getParcelable<Subjects>(MainActivity.CONTENT_OBJECT)

        if (thisSubject != null) {
            val detailsAdapter = DetailsAdapter(thisSubject.assign)
            assignmentBinding.assignmentRecyclerView.adapter = detailsAdapter
        }
    }
}