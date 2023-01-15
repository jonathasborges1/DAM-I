package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var inputMessage: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        inputMessage = findViewById<EditText>(R.id.textInputMessage)
        val btnSend = findViewById<Button>(R.id.sendButton)

        btnSend.setOnClickListener{
            analyzingAnswer(inputMessage.text.toString())
        }

    }

    private fun analyzingAnswer(message: String){
        val marciano = MarcianoAvancado()
//        Log.v("Entrada: ", message)
        val answer = marciano.responda(message)
//        Log.v("Resposta: ", answer)
        intent = Intent(this, AnswerActivity::class.java).apply {
            putExtra("answer", answer)
        }

        startActivity(intent)
    }

    override fun onResume(){
        super.onResume()
        inputMessage.text.clear()
    }

}