package com.example.mehhhh.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mehhhh.Model
import com.example.mehhhh.R
import com.example.mehhhh.remote.MealService
import com.example.mehhhh.remote.Result
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    companion object{
        fun newInstance(): SearchFragment = SearchFragment()
    }

    var mMealList: List<Result>? = null
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var searchAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }


    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?, savedInstanceState: Bundle?):
            View? {searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_search, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            searchViewModel.getAllMeals()

        }
    }
}