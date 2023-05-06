package com.example.gabrielmonteiro_rm87350

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class CharacterProfile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_profile)
        val button_update_skills = findViewById<Button>(R.id.button_update_skills)


        button_update_skills.setOnClickListener{
            IrParaPrimeiraTela()
        }
    }

    private fun IrParaPrimeiraTela(){
        val primeiraTela = Intent(this, MainActivity::class.java)
        startActivity(primeiraTela)
    }
}