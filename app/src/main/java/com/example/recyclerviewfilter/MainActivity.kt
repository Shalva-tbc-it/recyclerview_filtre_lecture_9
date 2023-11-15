package com.example.recyclerviewfilter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewfilter.adapter.CollectionAdapter
import com.example.recyclerviewfilter.data_models.CATEGORY
import com.example.recyclerviewfilter.data_models.Collection
import com.example.recyclerviewfilter.databinding.ActivityMainBinding
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CollectionAdapter

    private val collection: MutableList<Collection> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    private fun setUp() {
        setRecyclerView()
        listeners()
        addToList()
    }

    private fun listeners() = with(binding) {
        btnAll.setOnClickListener {
            adapter.setData(collection)
        }
        btnParty.setOnClickListener {
            adapter.setData(sort(CATEGORY.Party))
        }
        btnCamping.setOnClickListener {
            adapter.setData(sort(CATEGORY.Camping))
        }
        btnCategory1.setOnClickListener {
            adapter.setData(sort(CATEGORY.Category1))
        }
        btnCategory2.setOnClickListener {
            adapter.setData(sort(CATEGORY.Category2))
        }
        btnCategory3.setOnClickListener {
            adapter.setData(sort(CATEGORY.Category3))
        }
    }


    private fun sort(category: CATEGORY) : MutableList<Collection> {
        val localList: MutableList<Collection> = mutableListOf()
        collection.forEach {
            if (it.categoryType == category) {
                localList.add(it)
            }
        }
        return localList
    }




    private fun setRecyclerView() {
        adapter = CollectionAdapter()
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.adapter = adapter
        adapter.setData(collection)
    }



    private fun addToList() {
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
                categoryType = CATEGORY.Category1
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
                categoryType = CATEGORY.Category3
            )
        )
        collection.addAll(newCollection)
        collection.addAll(newCollection)

    }


}