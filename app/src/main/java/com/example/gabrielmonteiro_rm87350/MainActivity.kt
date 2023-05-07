package com.example.gabrielmonteiro_rm87350
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.example.gabrielmonteiro_rm87350.Profile
import com.example.gabrielmonteiro_rm87350.R

class MainActivity : AppCompatActivity() {

    private lateinit var profile: Profile
    private lateinit var skillsTexto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        skillsTexto = findViewById(R.id.SkillsTexto)
        val botaoSkills = findViewById<Button>(R.id.botaoSkills)

        botaoSkills.setOnClickListener{
            IrParaSegundaTela()
        }

        val botaoMudarCor = findViewById<Button>(R.id.BotaoLei)
        botaoMudarCor.setOnClickListener {
            MudarTema(it)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            profile = data?.getParcelableExtra("profile")!!
            skillsTexto.text = profile.skills.joinToString("\n")
        }
    }

    private fun IrParaSegundaTela() {
        profile = Profile("Growlithe", "Growlithe é um Pokémon quadrúpede, canino...", mutableListOf())
        val segundaTela = Intent(this, CharacterProfile::class.java)
        segundaTela.putExtra("profile", profile)
        startActivityForResult(segundaTela, 1)
    }

    // Adiciona a função de click no botão de atualizar o Tema
    fun MudarTema(view: android.view.View) {
        if (isDarkTheme()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        recreate()
    }

    private fun isDarkTheme(): Boolean {
        val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return currentNightMode == Configuration.UI_MODE_NIGHT_YES
    }
}



