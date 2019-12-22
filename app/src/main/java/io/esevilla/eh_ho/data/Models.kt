package io.esevilla.eh_ho.data

import java.util.*

data class Topic(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val content: String
)
