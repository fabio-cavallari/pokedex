package com.pokedex.custom_views

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.content.res.AppCompatResources
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.pokedex.R
import kotlinx.android.synthetic.main.pokemon_list_item_type.view.*


class TypeView: CoordinatorLayout {
    constructor(context: Context, type: String): super(context){
        LayoutInflater.from(context).inflate(R.layout.pokemon_list_item_type, this, true)
        val typeIcon = type_icon
        typeIcon.background.setTint( ContextCompat.getColor(context, context.resources.getIdentifier(type, "color",context.packageName)))
        typeIcon.setImageResource(context.resources.getIdentifier(type, "drawable", context.packageName))
    }
}