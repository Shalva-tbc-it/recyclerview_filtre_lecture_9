package com.example.recyclerviewfilter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewfilter.adapter.CollectionAdapter
import com.example.recyclerviewfilter.adapter.FilterHorizontalAdapter
import com.example.recyclerviewfilter.data_models.CATEGORY
import com.example.recyclerviewfilter.data_models.Collection
import com.example.recyclerviewfilter.data_models.Filter
import com.example.recyclerviewfilter.databinding.ActivityMainBinding
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterCollection: CollectionAdapter
    private lateinit var adapterFilter: FilterHorizontalAdapter

    private val collection: MutableList<Collection> = mutableListOf()
    private val filter: MutableList<Filter> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        setRecyclerView()
        addToList()
    }

    private fun sort(category: CATEGORY): MutableList<Collection> {
        val localList: MutableList<Collection> = mutableListOf()
        collection.forEach {
            if (it.categoryType == category) {
                localList.add(it)
            }
        }
        return localList
    }

    private fun setRecyclerView() {
        adapterCollection = CollectionAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapterCollection
        adapterCollection.setData(collection)

        adapterFilter = FilterHorizontalAdapter(listener = {
            when(it.category) {
                CATEGORY.All -> adapterCollection.setData(collection)
                else -> adapterCollection.setData(sort(it.category))
            }
        })
        binding.recyclerViewHorizontal.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewHorizontal.adapter = adapterFilter
        adapterFilter.setData(filter)
    }

    private fun addToList() {

        val newBtn = listOf(
            Filter(
                icon = null,
                title = "All",
                category = CATEGORY.All
            ),
            Filter(
                id = UUID.randomUUID(),
                icon = R.drawable.ic_party,
                title = "Party",
                category = CATEGORY.Party
            ),
            Filter(
                id = UUID.randomUUID(),
                icon = R.drawable.ic_camping,
                title = "Camping",
                category = CATEGORY.Camping
            ),
            Filter(
                id = UUID.randomUUID(),
                icon = R.drawable.ic_camping,
                title = "Category1",
                category = CATEGORY.Category1
            ),
            Filter(
                id = UUID.randomUUID(),
                icon = R.drawable.ic_camping,
                title = "Category2",
                category = CATEGORY.Category2
            ),
            Filter(
                id = UUID.randomUUID(),
                icon = R.drawable.ic_camping,
                title = "Category3",
                category = CATEGORY.Category3
            )
        )
        filter.addAll(newBtn)


        val newCollection = listOf(
            Collection(
                id = UUID.randomUUID(),
                image = R.drawable.girl_1,
                title = "Black",
                price = 102.5,
                categoryType = CATEGORY.Camping
            ),
            Collection(
                id = UUID.randomUUID(),
                image = R.drawable.girl_2,
                title = "Black",
                price = 39.99,
                categoryType = CATEGORY.Party
            ),
            Collection(
                id = UUID.randomUUID(),
                image = R.drawable.girl_3,
                title = "Black",
                price = 49.99,
                categoryType = CATEGORY.Party
            ),
            Collection(
                id = UUID.randomUUID(),
                image = R.drawable.girl_4,
                title = "Black",
                price = 79.99,
                categoryType = CATEGORY.Camping,

                ),
            Collection(
                id = UUID.randomUUID(),
                image = R.drawable.girl_1,
                title = "Black",
                price = 82.9,
                categoryType = CATEGORY.Category2
            ),
            Collection(
                id = UUID.randomUUID(),
                image = R.drawable.girl_2,
                title = "Black",
                price = 19.99,
                categoryType = CATEGORY.Category2

            ),
            Collection(
                id = UUID.randomUUID(),
                image = R.drawable.girl_3,
                title = "Black",
                price = 79.99,
                categoryType = CATEGORY.Party
            ),
            Collection(
                id = UUID.randomUUID(),
                image = R.drawable.girl_4,
                title = "Black",
                price = 39.99,
                categoryType = CATEGORY.Category1
            ),
            Collection(
                id = UUID.randomUUID(),
                image = R.drawable.girl_3,
                title = "Black",
                price = 79.99,
                categoryType = CATEGORY.Category3
            ),
            Collection(
                id = UUID.randomUUID(),
                image = R.drawable.girl_4,
                title = "Black",
                price = 39.99,
                categoryType = CATEGORY.Category3
            )
        )
        collection.addAll(newCollection)
        collection.addAll(newCollection)
    }

}