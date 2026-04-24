package com.debloater.app.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.debloater.app.R
import com.debloater.app.data.DeviceDetector
import rikka.shizuku.Shizuku

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvDevice     = findViewById<TextView>(R.id.tvDevice)
        val tvBrand      = findViewById<TextView>(R.id.tvBrand)
        val tvShizuku    = findViewById<TextView>(R.id.tvShizukuStatus)
        val btnShizuku   = findViewById<Button>(R.id.btnShizukuGuide)
        val btnDebloat   = findViewById<Button>(R.id.btnDebloat)
        val cardStatus   = findViewById<CardView>(R.id.cardStatus)

        // Detecta dispositivo
        val brand  = Build.MANUFACTURER
        val model  = Build.MODEL
        val android = Build.VERSION.RELEASE

        tvDevice.text  = "📱 $model"
        tvBrand.text   = "🏷️ $brand  •  Android $android"

        // Verifica Shizuku
        refreshShizukuStatus(tvShizuku, btnDebloat, cardStatus)

        btnShizuku.setOnClickListener {
            startActivity(Intent(this, ShizukuGuideActivity::class.java))
        }

        btnDebloat.setOnClickListener {
            val intent = Intent(this, DebloatActivity::class.java)
            intent.putExtra("brand", brand)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val tvShizuku = findViewById<TextView>(R.id.tvShizukuStatus)
        val btnDebloat = findViewById<Button>(R.id.btnDebloat)
        val cardStatus = findViewById<CardView>(R.id.cardStatus)
        refreshShizukuStatus(tvShizuku, btnDebloat, cardStatus)
    }

    private fun refreshShizukuStatus(tv: TextView, btn: Button, card: CardView) {
        val granted = try {
            Shizuku.checkSelfPermission() == android.content.pm.PackageManager.PERMISSION_GRANTED
        } catch (e: Exception) { false }

        if (granted) {
            tv.text = "✅ Shizuku conectado"
            tv.setTextColor(getColor(R.color.green))
            btn.isEnabled = true
            card.setCardBackgroundColor(getColor(R.color.card_ok))
        } else {
            tv.text = "❌ Shizuku não conectado"
            tv.setTextColor(getColor(R.color.red))
            btn.isEnabled = false
            card.setCardBackgroundColor(getColor(R.color.card_err))
        }
    }
}
