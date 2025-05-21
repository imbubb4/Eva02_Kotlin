package com.heredia.adrian.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.heredia.adrian.laboratoriocalificado02.databinding.ActivityEjercicio02Binding

class Ejercicio02Activity : AppCompatActivity() {

    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRegistrarButton()
    }

    private fun setupRegistrarButton() {
        binding.btnRegistrar.setOnClickListener {
            if (validateInputs()) {
                navigateToPedidoActivity()
            } else {
                showToast("Por favor, complete todos los campos")
            }
        }
    }

    private fun validateInputs(): Boolean {
        val nombreCliente = binding.etNombreCliente.text.toString().trim()
        val numeroCliente = binding.etNumeroCliente.text.toString().trim()
        val productos = binding.etProductos.text.toString().trim()
        val ciudad = binding.etCiudad.text.toString().trim()
        val direccion = binding.etDireccion.text.toString().trim()

        return nombreCliente.isNotEmpty() &&
                numeroCliente.isNotEmpty() &&
                productos.isNotEmpty() &&
                ciudad.isNotEmpty() &&
                direccion.isNotEmpty()
    }

    private fun navigateToPedidoActivity() {
        val intent = Intent(this, PedidoActivity::class.java).apply {
            putExtra("NOMBRE_CLIENTE", binding.etNombreCliente.text.toString().trim())
            putExtra("NUMERO_CLIENTE", binding.etNumeroCliente.text.toString().trim())
            putExtra("PRODUCTOS", binding.etProductos.text.toString().trim())
            putExtra("CIUDAD", binding.etCiudad.text.toString().trim())
            putExtra("DIRECCION", binding.etDireccion.text.toString().trim())
        }
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}