package com.a4nt0n64r.testapp.domain.repository

import com.a4nt0n64r.testapp.domain.model.Homework
import com.a4nt0n64r.testapp.domain.model.StudySubject


interface Repository {
    fun getClasses(): List<StudySubject>
    fun getHomework(): List<Homework>
}