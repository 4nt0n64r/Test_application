package com.a4nt0n64r.testapp.data

import com.a4nt0n64r.testapp.domain.model.Homework
import com.a4nt0n64r.testapp.domain.model.StudySubject
import com.a4nt0n64r.testapp.domain.repository.Repository

class RepositoryImpl : Repository {
    override fun getClasses(): List<StudySubject> {
        val listOfClasses =
            listOf<StudySubject>(
                StudySubject("History", "8:30 - 10:00", "Mr. Thomas", true),
                StudySubject("Literature", "10:00 - 11:30", "Mr. Barros", false),
                StudySubject("Physic", "12:00 - 13:30", "Mr. Peters", false),
                StudySubject("Chemistry", "13:40 - 15:10", "Mr. Himik", true),
                StudySubject("Physical Education", "15:30 - 17:00", "Mr. Fizruk", false)
            )
        return listOfClasses
    }

    override fun getHomework(): List<Homework> {
        val listOfHomework =
            listOf<Homework>(
                Homework(
                    "Literature",
                    2,
                    "Read scenes 1.1-1.2 of The Master and the Margarita."
                ),
                Homework(
                    "Physics",
                    5,
                    "Learn 2nd law of Newton."
                )
            )
        return listOfHomework
    }
}