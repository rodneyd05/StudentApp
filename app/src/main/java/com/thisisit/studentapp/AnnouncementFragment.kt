package com.thisisit.studentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.thisisit.studentapp.databinding.FragmentAnnouncementBinding

class AnnouncementFragment : Fragment() {
    private lateinit var announcementBinding: FragmentAnnouncementBinding
    private lateinit var announcementList: Subjects
    private lateinit var announce: Subjects
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        announce = arguments?.getSerializable("content_details") as Subjects
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        //If viewBinding is used, View should be made non-nullable instead of View?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_your_books, container, false)
        announcementBinding = FragmentAnnouncementBinding.inflate(layoutInflater)
        return announcementBinding.root
    }

    //call and override this function
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //use context instead of (this@AnnouncementFragment)
        announcementBinding.announcementRecyclerView.layoutManager = LinearLayoutManager(context)

//        announcementList = arguments?.getSerializable("content_details") as Subjects

        val announcementAdapter = AnnouncementAdapter(announcement)
        announcementBinding.announcementRecyclerView.adapter = announcementAdapter
    }

}