package com.debloater.app.ui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.debloater.app.R
import com.debloater.app.data.DebloatPackages
import kotlinx.coroutines.*

class DebloatActivity : AppCompatActivity() {

    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_debloat)

        val brand       = intent.getStringExtra("brand") ?: "unknown"
        val tvTitle     = findViewById<TextView>(R.id.tvDebloatTitle)
        val tvLog       = findViewById<TextView>(R.id.tvLog)
        val btnRun      = findViewById<Button>(R.id.btnRunDebloat)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val recycler    = findViewById<RecyclerView>(R.id.recyclerPackages)

        val packages = DebloatPackages.getForBrand(brand)
        tvTitle.text = "Debloat para ${brand.replaceFirstChar { it.uppercase() }} (${packages.size} pacotes)"

        // Lista os pacotes
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = PackageAdapter(packages)

        btnRun.setOnClickListener {
            btnRun.isEnabled = false
            progressBar.visibility = android.view.View.VISIBLE
            tvLog.text = "Iniciando debloat...\n"

            scope.launch {
                var success = 0
                var failed  = 0

                packages.forEach { pkg ->
                    val result = withContext(Dispatchers.IO) {
                        runCatching {
                            val cmd = arrayOf("pm", "uninstall", "-k", "--user", "0", pkg)
                            val process = Runtime.getRuntime().exec(cmd)
                            process.waitFor()
                            process.exitValue() == 0
                        }.getOrDefault(false)
                    }

                    if (result) {
                        success++
                        tvLog.append("✅ $pkg\n")
                    } else {
                        failed++
                        tvLog.append("❌ $pkg\n")
                    }
                }

                progressBar.visibility = android.view.View.GONE
                tvLog.append("\n🎉 Concluído! ✅ $success removidos  ❌ $failed falhas\nReinicie o celular para aplicar as mudanças.")
                btnRun.isEnabled = true
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}

class PackageAdapter(private val packages: List<String>) :
    RecyclerView.Adapter<PackageAdapter.VH>() {

    class VH(view: android.view.View) : RecyclerView.ViewHolder(view) {
        val tv: TextView = view.findViewById(android.R.id.text1)
    }

    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): VH {
        val v = android.view.LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tv.text = packages[position]
        holder.tv.textSize = 11f
    }

    override fun getItemCount() = packages.size
}
