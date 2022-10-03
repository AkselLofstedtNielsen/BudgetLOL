package com.example.budgetskoj

import android.graphics.PostProcessor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


const val UTGIFT_POSITION_KEY = "UTGIFT_POSITION"
const val POSITION_NOT_SET = -1


class UtgifterActivity : AppCompatActivity() {

    lateinit var nameEditText : EditText
    lateinit var kostnadEditText : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utgifter)

        nameEditText = findViewById(R.id.editName)
        kostnadEditText = findViewById(R.id.editKostnad)


        val utgiftPosition = intent.getIntExtra(UTGIFT_POSITION_KEY,POSITION_NOT_SET)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val deleteButton = findViewById<Button>(R.id.deleteButton)

        if (utgiftPosition != POSITION_NOT_SET){
            displayUtgift(utgiftPosition)
            saveButton.setOnClickListener {
                editUtgift(utgiftPosition)

            }
            deleteButton.setOnClickListener {
                deleteUtgift(utgiftPosition)
            }
        }
        else{
            saveButton.setOnClickListener {
                addNewUtgift()

            }
        }


    }
    fun addNewUtgift(){
        val name = nameEditText.text.toString()
        val kostnad = kostnadEditText.text.toString().toInt()

        if(name != "" && kostnad != -1){
            val utgift = Utgift(name,kostnad )
            DataManager.utgiftLista.add(utgift)
            finish()
        }

    }
    fun editUtgift (position: Int){
        DataManager.utgiftLista[position].name = nameEditText.text.toString()
        DataManager.utgiftLista[position].kostnad = kostnadEditText.text.toString().toInt()
        finish()
    }
    fun displayUtgift (position: Int){
        val utgift = DataManager.utgiftLista[position]

        nameEditText.setText(utgift.name)
        kostnadEditText.setText(utgift.kostnad.toString())
    }
    fun deleteUtgift (position:Int){
        DataManager.utgiftLista.removeAt(position)
        finish()
    }
}