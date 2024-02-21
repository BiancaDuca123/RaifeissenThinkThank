package com.ubb.raiffaisen.thinktank.main.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ubb.raiffaisen.thinktank.R
import com.ubb.raiffaisen.thinktank.databinding.FragmentMainBinding
import com.ubb.raiffaisen.thinktank.main.domain.Category
import com.ubb.raiffaisen.thinktank.main.domain.GridItem
import com.ubb.raiffaisen.thinktank.main.domain.GridItemAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val categoryList = ArrayList<Category>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCategories()

        val adapter = GridItemAdapter(categoryList.map { category ->
            Log.d("Main", category.name)
            GridItem(category.name, category.allocatedSum, category.usedSum, category.icon)
        })

        with(binding) {
            gridRecyclerView.layoutManager = GridLayoutManager(context, 2)
            gridRecyclerView.adapter = adapter

            btnAddCategory.setOnClickListener {
                // Create an instance of the bottom sheet fragment
                val bottomSheetFragment = CreateCategoryBottomSheet()
                // Show the bottom sheet
                fragmentManager?.let { it1 ->
                    bottomSheetFragment.show(
                        it1,
                        bottomSheetFragment.tag
                    )
                }
            }
        }
    }

    private fun setCategories() {
        categoryList.add(
            Category(
                "Supermarket",
                500.0,
                230.0,
                R.drawable.baseline_shopping_cart_24
            )
        ) // Example, replace R.drawable.ic_food with actual drawable resources
        categoryList.add(
            Category(
                "Transport",
                100.50,
                30.60,
                R.drawable.baseline_emoji_transportation_24
            )
        )
        categoryList.add(Category("Shopping", 500.0, 230.0, R.drawable.baseline_shopping_bag_24))
    }
}