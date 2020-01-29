package com.example.mehhhh.ui.search

import android.util.Log
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mehhhh.Model
import com.example.mehhhh.R
import com.example.mehhhh.remote.Result
import org.w3c.dom.Text

class ListAdapter(val meals: List<Result>, val listener: (Result) -> Unit)
    : RecyclerView.Adapter<SearchViewHolder>() {
    private val list: MutableList<Result> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return SearchViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
//        val meal: Result? = list[position]
//
//       // Log.w("myapp",meal.name)
//        if(meal != null) {
//            Log.e("myapp",meal.toString())
//            holder.bind(meal)
//        }
    }

    override fun getItemCount(): Int = list.size

    fun setList(newlist: List<Result>){
        list.clear()
        list.addAll(newlist)
        notifyDataSetChanged()
    }
}

class SearchViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    private var mTitleView: TextView? = null
    private var mIngredientView: TextView? = null
    private var mNotPossessedIngredient: TextView? = null


    init {
        mTitleView = itemView.findViewById(R.id.tv_search_title)
        mIngredientView = itemView.findViewById(R.id.tv_search_possessed_ingredients)
        mNotPossessedIngredient = itemView.findViewById(R.id.tv_search_not_possessed_ingredients)
    }

    fun bind(meal: Result, listener: (Result) -> Unit) = with(itemView){
        Log.w("hola", meal.name!!)
        mTitleView?.text = meal.name
        mIngredientView?.text = meal.ingredients
    }


}

