package com.example.gabrielmonteiro_rm87350

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profile(
    val nome: String,
    val descricao: String,
    var skills: MutableList<String>
) : Parcelable

fun MutableList<String>.adicionarSkill(skill: String) {
    if (!this.contains(skill)) {
        this.add(skill)
    }
}

fun MutableList<String>.removerSkill(skill: String) {
    if (this.contains(skill)) {
        this.remove(skill)
    }
}

fun MutableList<String>.temSkill(skill: String): Boolean {
    return this.contains(skill)
}

