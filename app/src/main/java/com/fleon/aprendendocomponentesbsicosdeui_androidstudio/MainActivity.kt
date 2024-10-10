package com.fleon.aprendendocomponentesbsicosdeui_androidstudio

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    val editTextName: EditText by lazy { findViewById(R.id.name) }
    val editTextAge: EditText by lazy {findViewById(R.id.age)}
    val outputText: TextView by lazy {findViewById(R.id.output)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupView()
    }

    private fun setupView() {
        editTextName.addTextChangedListener { text ->
            atualizarText(text.toString(), editTextAge.toString())
        }

        editTextAge.addTextChangedListener { text ->
            atualizarText(editTextName.text.toString(), text.toString())
        }
    }

    private fun atualizarText(nome: String?, idade: String?) {
            outputText.text = "Olá, eu sou $nome e tenho $idade anos."
        }
}