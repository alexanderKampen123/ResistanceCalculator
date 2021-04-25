package com.example.resi

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CustomColorSpinner(context: Context, textViewResourceId: Int, items: ArrayList<Ring>) :
    ArrayAdapter<Ring>(context, textViewResourceId, items) {
    val items = items

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val row  = inflater.inflate(R.layout.color_spinner_item, parent,false)
        val label = row.findViewById<TextView>(R.id.color_name)
        label.text = items[position].color!!.label

        val unit: Unit = Unit();
        var value = row.findViewById<TextView>(R.id.color_value)
        value.text = unit.format(items[position]);

        val icon = row.findViewById<View>(R.id.color_shape)
        val color = items[position].color!!.name
        icon.setBackgroundResource(ValueMapping.getColorMapping()[color]!!)

        return row
    }


}