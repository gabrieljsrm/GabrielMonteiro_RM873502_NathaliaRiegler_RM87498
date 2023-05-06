package com.example.gabrielmonteiro_rm87350
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botaoSkills = findViewById<Button>(R.id.botaoSkills)

        botaoSkills.setOnClickListener{
            IrParaSegundaTela()
        }
    }

    private fun IrParaSegundaTela(){
        val segundaTela = Intent(this, CharacterProfile::class.java)
        startActivity(segundaTela)
    }
}