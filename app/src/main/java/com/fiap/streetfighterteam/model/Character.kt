package com.fiap.streetfighterteam.model

import java.io.Serializable

data class Character(
    val id: Int,
    val name: String,
    val photo: String,
    val power: Int,
    val health: Int,
    val mobility: Int,
    val technique: Int,
    val reach: Int
) : Serializable