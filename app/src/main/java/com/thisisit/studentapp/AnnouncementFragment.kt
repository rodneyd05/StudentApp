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

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            announcementBinding = FragmentAnnouncementBinding.inflate(layoutInflater)
            return announcementBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        announcementBinding.announcementRecyclerView.layoutManager = LinearLayoutManager(context)

        val thisSubject = arguments?.getParcelable<Subjects>(MainActivity.CONTENT_OBJECT)

        if (thisSubject != null) {
            val detailsAdapter = DetailsAdapter(thisSubject.announce)
            announcementBinding.announcementRecyclerView.adapter = detailsAdapter
        }
    }
}