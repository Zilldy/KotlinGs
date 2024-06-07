package com.guilhermecardoso_rm94726

import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val praiasAdapter = PraiasAdapter()
        recyclerView.adapter = praiasAdapter

        val button = findViewById<Button>(R.id.button)
        val deleteButton = findViewById<Button>(R.id.deleteButton)
        val editTextNome = findViewById<EditText>(R.id.praia)
        val editTextCidade = findViewById<EditText>(R.id.cidade)
        val editTextEstado = findViewById<EditText>(R.id.estado)

        button.setOnClickListener {
            if (editTextNome.text.isEmpty() || editTextCidade.text.isEmpty() || editTextEstado.text.isEmpty()) {
                editTextNome.error = "Preencha um nome de praia"
                editTextCidade.error = "Preencha uma cidade"
                editTextEstado.error = "Preencha um estado"
                return@setOnClickListener
            }

            val praia = PraiaModel(
                nomePraia = editTextNome.text.toString(),
                cidade = editTextCidade.text.toString(),
                estado = editTextEstado.text.toString(),
                onRemove = {
                    praiasAdapter.removePraia(it)
                },
            )

            Log.d("Tag", "$praia")

            praiasAdapter.addPraia(praia)
            editTextNome.text.clear()
            editTextCidade.text.clear()
            editTextEstado.text.clear()
        }

        deleteButton.setOnClickListener {
            if (!praiasAdapter.praias.isEmpty()) {
                praiasAdapter.removeLista()
            }
        }

    }
}