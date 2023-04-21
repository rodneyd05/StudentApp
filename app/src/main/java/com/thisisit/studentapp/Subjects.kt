package com.thisisit.studentapp

data class Subjects(val name: String,
                    val instructor: String,
//                    val announce: Announcement,
//                    val assign: Assignment,
//                    val notes: Notes,
//                    val syllabus: Syllabus
                   ) :java.io.Serializable

data class Announcement(val heading: String, val announceContent: String)
data class Assignment(val heading: String, val assignContent: String)
data class Notes(val heading: String, val notesContent: String)
data class Syllabus(val heading: String, val syllabusContent: String)

//values

val subjectList = listOf(
    Subjects("Understanding the Self", "Instructor 1"),
    Subjects("Contemporary World", "Instructor 2"),
    Subjects("Purposive Communication", "Instructor 3"),
    Subjects("Art Appreciation", "Instructor 4"),
    Subjects("Ethics", "Instructor 5"),
    Subjects("Readings in Philippine History", "Instructor 6"),
    Subjects("Mathematics in the Modern World", "Instructor 7"),
    Subjects("Science and Technology, and Society", "Instructor 8"),
    Subjects("Life and Works of Rizal", "Instructor 9")
)