package com.thisisit.studentapp

import java.io.Serializable

data class Subjects(val name: String,
                    val instructor: String,
                    val announce: List<Content>,
                    val assign: List<Content>,
                    val notes: List<Content>,
                    val syllabus: List<Content>
) : Serializable {

}

data class Content(val heading: String, val content: String): Serializable

//values announcement
val announcement = listOf(
    Content("Announcement1", "Content1"),
    Content("Announcement2", "Content2"),
    Content("Announcement3", "Content3"),
    Content("Announcement4", "Content4"),
    Content("Announcement5", "Content5"),
    Content("Announcement6", "Content6"),
    Content("Announcement7", "Content7"),
    Content("Announcement8", "Content8"),
    Content("Announcement9", "Content9")
)

//values assignment
val assignment = listOf(
    Content("Assignment", "Content1"),
    Content("Assignment", "Content2"),
    Content("Assignment", "Content3"),
    Content("Assignment", "Content4"),
    Content("Assignment", "Content5"),
    Content("Assignment", "Content6"),
    Content("Assignment", "Content7"),
    Content("Assignment", "Content8"),
    Content("Assignment", "Content9")
)

//values notes
val notes = listOf(
    Content("Notes", "Content1"),
    Content("Notes", "Content2"),
    Content("Notes", "Content3"),
    Content("Notes", "Content4"),
    Content("Notes", "Content5"),
    Content("Notes", "Content6"),
    Content("Notes", "Content7"),
    Content("Notes", "Content8"),
    Content("Notes", "Content9")
)

//values syllabus
val syllabus = listOf(
    Content("Syllabus", "Content1"),
    Content("Syllabus", "Content2"),
    Content("Syllabus", "Content3"),
    Content("Syllabus", "Content4"),
    Content("Syllabus", "Content5"),
    Content("Syllabus", "Content6"),
    Content("Syllabus", "Content7"),
    Content("Syllabus", "Content8"),
    Content("Syllabus", "Content9")
)

val subjectList = listOf(
    Subjects("Understanding the Self", "Instructor 1", announcement, assignment, notes, syllabus),
    Subjects("Contemporary World", "Instructor 2", announcement, assignment, notes, syllabus),
    Subjects("Purposive Communication", "Instructor 3", announcement, assignment, notes, syllabus),
    Subjects("Art Appreciation", "Instructor 4", announcement, assignment, notes, syllabus),
    Subjects("Ethics", "Instructor 5", announcement, assignment, notes, syllabus),
    Subjects("Readings in Philippine History", "Instructor 6", announcement, assignment, notes, syllabus),
    Subjects("Mathematics in the Modern World", "Instructor 7", announcement, assignment, notes, syllabus),
    Subjects("Science and Technology, and Society", "Instructor 8", announcement, assignment, notes, syllabus),
    Subjects("Life and Works of Rizal", "Instructor 9", announcement, assignment, notes, syllabus)
)

// , announcement, assignment, notes, syllabus