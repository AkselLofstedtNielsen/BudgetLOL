package com.example.budgetskoj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

var sum = 0
class MainActivity : AppCompatActivity() {

    lateinit var textView : TextView
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         textView = findViewById(R.id.totalView)
         for (i in DataManager.utgiftLista){
            sum += i.kostnad
            }
         textView.text = "Totala utgifter = ${sum}"



        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = UtgiftRecycleAdapter(this, DataManager.utgiftLista)
        recyclerView.adapter = adapter

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        fab.setOnClickListener{
            val intent = Intent(this,UtgifterActivity::class.java)
            startActivity(intent)
        }


        }
        override fun onResume() {
            super.onResume()
            var newSum = 0
            for (i in DataManager.utgiftLista){
                newSum += i.kostnad
            }
            textView.text = "Totala utgifter = ${newSum}"


            recyclerView.adapter?.notifyDataSetChanged()

    }
}