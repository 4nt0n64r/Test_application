package com.a4nt0n64r.testapp.domain.model

interface InterfaceForAdapter


data class ExtraClass(
    val name: String,
    val time: String,
    val description: String,
    val teacher: String
) : InterfaceForAdapter

data class Homework(
    val name: String,
    val daysLeft: Int,
    val description: String
): InterfaceForAdapter

data class StudySubject(
    val name: String,
    val time: String,
    val description: String,
    val teacher: String
): InterfaceForAdapter