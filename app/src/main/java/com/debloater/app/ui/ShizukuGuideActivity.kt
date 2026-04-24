package com.debloater.app.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.debloater.app.R
import rikka.shizuku.Shizuku

class ShizukuGuideActivity : AppCompatActivity() {

    private val REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shizuku_guide)

        val btnRequest = findViewById<Button>(R.id.btnRequestPermission)
        val tvStatus   = findViewById<TextView>(R.id.tvPermStatus)

        btnRequest.setOnClickListener {
            try {
                if (Shizuku.checkSelfPermission() == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                    tvStatus.text = "✅ Permissão já concedida!"
                } else {
                    Shizuku.requestPermission(REQUEST_CODE)
                }
            } catch (e: Exception) {
                tvStatus.text = "❌ Shizuku não está rodando. Siga o passo a passo abaixo."
            }
        }
    }

    private val permissionListener = Shizuku.OnRequestPermissionResultListener { _, grantResult ->
        val tv = findViewById<TextView>(R.id.tvPermStatus)
        if (grantResult == android.content.pm.PackageManager.PERMISSION_GRANTED) {
            tv.text = "✅ Permissão concedida! Volte para a tela inicial."
            tv.setTextColor(getColor(R.color.green))
        } else {
            tv.text = "❌ Permissão negada."
            tv.setTextColor(getColor(R.color.red))
        }
    }

    override fun onStart() {
        super.onStart()
        Shizuku.addRequestPermissionResultListener(permissionListener)
    }

    override fun onStop() {
        super.onStop()
        Shizuku.removeRequestPermissionResultListener(permissionListener)
    }
}
