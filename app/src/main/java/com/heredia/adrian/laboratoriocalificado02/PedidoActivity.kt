package com.heredia.adrian.laboratoriocalificado02

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.heredia.adrian.laboratoriocalificado02.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPedidoBinding
    private lateinit var nombreCliente: String
    private lateinit var numeroCliente: String
    private lateinit var productos: String
    private lateinit var ciudad: String
    private lateinit var direccion: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getExtras()
        setupViews()
        setupButtons()
    }

    private fun getExtras() {
        intent.extras?.let { extras ->
            nombreCliente = extras.getString("NOMBRE_CLIENTE", "")
            numeroCliente = extras.getString("NUMERO_CLIENTE", "")
            productos = extras.getString("PRODUCTOS", "")
            ciudad = extras.getString("CIUDAD", "")
            direccion = extras.getString("DIRECCION", "")
        }
    }

    private fun setupViews() {
        binding.tvNombreCliente.text = nombreCliente
        binding.tvNumeroCliente.text = numeroCliente
        binding.tvProductos.text = productos
        binding.tvUbicacion.text = "$ciudad, $direccion"
    }

    private fun setupButtons() {
        // Botón Llamar
        binding.cardBtnLlamar.setOnClickListener {
            val mensaje = "Llamando a $nombreCliente al número $numeroCliente"
            showToast(mensaje)
        }

        // Botón WhatsApp
        binding.cardBtnWhatsapp.setOnClickListener {
            val mensaje = "Hola $nombreCliente Tus productos: $productos están en camino a la dirección: $direccion"
            showToast(mensaje)
        }

        // Botón Maps
        binding.cardBtnMaps.setOnClickListener {
            val mensaje = "Mostrando ubicación: $ciudad, $direccion"
            showToast(mensaje)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}