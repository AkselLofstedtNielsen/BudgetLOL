package com.example.budgetskoj

import android.content.Context
import android.content.Intent
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UtgiftRecycleAdapter(val context: Context, val utgiftLista : List<Utgift>) :
        RecyclerView.Adapter<UtgiftRecycleAdapter.ViewHolder>(){

    val layoutInflater = LayoutInflater.from(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.list_item, parent,false)

       return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val utgift = utgiftLista[position]

        holder.nameView.text = utgift.name
        holder.kostnadView.text = utgift.kostnad.toString()
        holder.utgiftListaPosition = position

    }

    override fun getItemCount(): Int {
        return utgiftLista.size
    }
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val nameView = itemView.findViewById<TextView>(R.id.nameView)
        val kostnadView = itemView.findViewById<TextView>(R.id.kostnadView)
        var utgiftListaPosition = 0

        init {

            itemView.setOnClickListener {
                val intent = Intent(context, UtgifterActivity::class.java)
                intent.putExtra(UTGIFT_POSITION_KEY, utgiftListaPosition)
                context.startActivity(intent)
            }
        }

    }

}