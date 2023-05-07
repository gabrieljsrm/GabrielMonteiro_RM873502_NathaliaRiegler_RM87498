package com.example.gabrielmonteiro_rm87350
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import com.example.gabrielmonteiro_rm87350.Profile
import com.example.gabrielmonteiro_rm87350.R

class CharacterProfile : AppCompatActivity() {
    private lateinit var profile: Profile
    private lateinit var switch_skill1: Switch
    private lateinit var switch_skill2: Switch
    private lateinit var switch_skill3: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_profile)

        profile = intent.getParcelableExtra<Profile>("profile")!!
        switch_skill1 = findViewById(R.id.switch_skill1)
        switch_skill2 = findViewById(R.id.switch_skill2)
        switch_skill3 = findViewById(R.id.switch_skill3)

        switch_skill1.isChecked = profile.skills.contains("Flame Burst")
        switch_skill2.isChecked = profile.skills.contains("Crunch")
        switch_skill3.isChecked = profile.skills.contains("Heat Wave")

        // Adiciona a função de click no botão de Update Skill's
        val buttonUpdateSkills = findViewById<Button>(R.id.button_update_skills)
        buttonUpdateSkills.setOnClickListener {
            atualizarSkills()
        }
    }

    // Atualiza a lista de Skills do Perfil e retorna para a MainActivity
    private fun atualizarSkills() {
        val listaSkills = mutableListOf<String>()

        if (switch_skill1.isChecked) {
            listaSkills.add("Flame Burst")
        }
        if (switch_skill2.isChecked) {
            listaSkills.add("Crunch")
        }
        if (switch_skill3.isChecked) {
            listaSkills.add("Heat Wave")
        }

        profile.skills = listaSkills
        val primeiraTela = Intent()
        primeiraTela.putExtra("profile", profile)
        setResult(RESULT_OK, primeiraTela)
        finish()
    }

    // Adiciona a função de click no botão de atualizar o Tema
    fun MudarTema(view: android.view.View) {
        setTheme(R.style.Theme_GabrielMonteiro_RM87350_Alternative)
        recreate()
    }

}