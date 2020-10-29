package com.a4nt0n64r.testapp.domain.model

interface InterfaceForClassesAdapter


data class ExtraClass(
    val name: String,
    val time: String,
    val description: String,
    val teacher: String
) : InterfaceForClassesAdapter

data class Homework(
    val name: String,
    val daysLeft: Int,
    val description: String
) : InterfaceForClassesAdapter

data class StudySubject(
    val name: String,
    val time: String,
    val teacher: String,
    val skype: Boolean
) : InterfaceForClassesAdapter