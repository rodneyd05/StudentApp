package com.thisisit.studentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.thisisit.studentapp.databinding.ActivitySubjectBinding

class SubjectActivity : AppCompatActivity() {

    private lateinit var subjectBinding: ActivitySubjectBinding
    private lateinit var thisSubjectList: Subjects

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subjectBinding = ActivitySubjectBinding.inflate(layoutInflater)
        setContentView(subjectBinding.root)

//        if(intent.hasExtra("details")) {
//            thisSubjectList = intent.getSerializableExtra("details") as Subjects
//        }
        thisSubjectList = intent.getSerializableExtra("details") as Subjects

        subjectBinding.subjectActivityName.text = thisSubjectList.name
        subjectBinding.subjectActivityInstructor.text = thisSubjectList.instructor

        //initialize frameLayout
        replaceFragment(AnnouncementFragment())

        subjectBinding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.announcement_nav -> replaceFragment(AnnouncementFragment())
                R.id.assignment_nav -> replaceFragment(AssignmentFragment())
                R.id.notes_nav -> replaceFragment(NotesFragment())
                R.id.syllabus_nav -> replaceFragment(SyllabusFragment())

                else -> {
                }
            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}