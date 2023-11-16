package com.example.recyclerviewfilter.data_models

import java.util.UUID

data class Filter(
    var id: UUID = UUID.randomUUID(),
    var icon: Int?,
    var title: String,
    var category: CATEGORY,
    var isActive: Boolean = false

)

