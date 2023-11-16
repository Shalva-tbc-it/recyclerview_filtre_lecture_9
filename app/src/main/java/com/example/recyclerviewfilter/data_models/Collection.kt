package com.example.recyclerviewfilter.data_models

import java.util.UUID

data class Collection(
    val id: UUID,
    var image: Int,
    var title: String,
    var price: Double,
    var categoryType: CATEGORY
)

enum class CATEGORY {
    All,
    Party,
    Camping,
    Category1,
    Category2,
    Category3
}
