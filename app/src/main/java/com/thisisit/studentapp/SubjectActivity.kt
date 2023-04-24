package com.thisisit.studentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.thisisit.studentapp.databinding.ActivitySubjectBinding

class SubjectActivity : AppCompatActivity() {

    private lateinit var subjectBinding: ActivitySubjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subjectBinding = ActivitySubjectBinding.inflate(layoutInflater)
        setContentView(subjectBinding.root)

        val thisSubject = intent.getParcelableExtra<Subjects>(MainActivity.CONTENT_STRING)

        subjectBinding.subjectActivityName.text = thisSubject?.name
        subjectBinding.subjectActivityInstructor.text = thisSubject?.instructor

        //initialize frameLayout
        replaceFragment(AnnouncementFragment(), thisSubject!!)

        subjectBinding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.announcement_nav -> replaceFragment(AnnouncementFragment(), thisSubject)
                R.id.assignment_nav -> replaceFragment(AssignmentFragment(), thisSubject)
                R.id.notes_nav -> replaceFragment(NotesFragment(), thisSubject)
                R.id.syllabus_nav -> replaceFragment(SyllabusFragment(), thisSubject)

                else -> {
                }
            }
            true
        }

    }
    private fun replaceFragment(fragment: Fragment, data: Subjects) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val bundle = Bundle().apply { putParcelable(MainActivity.CONTENT_OBJECT,data) }
        fragment.arguments = bundle
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}