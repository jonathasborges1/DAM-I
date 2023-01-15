package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.io.IOException

class AnswerActivity : AppCompatActivity(R.layout.answer_activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnReturn = findViewById<Button>(R.id.btnReturn)
        val textViewAnswer = findViewById<TextView>(R.id.textViewAnswer)

        val answer = intent.getStringExtra("answer")
        if (answer != null) {
            textViewAnswer.text = answer
        }else {
            Log.v("Erro ao processar a resposta", "null")
            throw IOException();
        }

        btnReturn.setOnClickListener(View.OnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })


    }
}