package com.example.mehhhh.ui.ingredients

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.mehhhh.R
import kotlinx.android.synthetic.main.fragment_ingredients.*


class IngredientFragment : Fragment() {

    private lateinit var ingredientViewModel: IngredientViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ingredientViewModel = ViewModelProviders.of(this).get(IngredientViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_ingredients, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        ingredientViewModel.text.observe(this, Observer {
//            textView.text = it
//        })


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_add_ingredient.setOnClickListener{
            if(!et_ingredients.text.isEmpty()){
                var checkBox = CheckBox(activity)
                checkBox.text = et_ingredients.text
                checkBox.layoutParams = LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
                    val msg = "You have " + (if (isChecked) "checked" else "unchecked") + " this Check it Checkbox."
                    Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
                }
                if(rootContainer != null){
                    rootContainer.addView(checkBox)
                }
            }
        }

    }



}