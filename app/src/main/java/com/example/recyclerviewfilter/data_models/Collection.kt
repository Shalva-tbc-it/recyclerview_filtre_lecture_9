package com.example.recyclerviewfilter.data_models

import java.util.UUID

data class Collection(
    val id: UUID,
    val image: Int,
    val title: String,
    val price: Double,
    val categoryType: String
)
