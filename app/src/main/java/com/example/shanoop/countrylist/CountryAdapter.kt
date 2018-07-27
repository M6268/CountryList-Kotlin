package com.example.shanoop.countrylist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class CountryAdapter(var data:ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.country_item,null)
        val viewholder=ViewHolder(view)
        return viewholder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data.get(position))
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bind(country:Country)
        {
            val country_name=itemView.findViewById<TextView>(R.id.name)
            val alpha3_code=itemView.findViewById<TextView>(R.id.alpha2)
            val alpha2_code=itemView.findViewById<TextView>(R.id.alpha3)

            country_name.text="Country    : "+country.name
            alpha2_code.text= "Alpha2_Code: "+country.alpha2
            alpha3_code.text= "Alpha3_Code: "+country.alpha3
        }
    }
}