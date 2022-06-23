package com.example.kullanicietkilesimi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.example.kullanicietkilesimi.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToast.setOnClickListener {
            Toast.makeText(this, "Merhaba", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSnackBar.setOnClickListener {
            Snackbar.make(it, "Silmek istiyor musunuz?", Snackbar.LENGTH_LONG)
                .setAction("Evet") {
                    Snackbar.make(it, "Silindi", Snackbar.LENGTH_SHORT)
                        .setTextColor(Color.BLUE)
                        .setBackgroundTint(Color.WHITE)
                        .show()
                }
                .setActionTextColor(Color.RED)
                .setTextColor(Color.BLUE)
                .setBackgroundTint(Color.WHITE)
                .show()
        }

        binding.buttonAlert.setOnClickListener {
            /*val ad = AlertDialog.Builder(this)
            ad.setTitle("Başlık")
            ad.setMessage("İçerik")
            ad.setIcon(R.drawable.resim)
            ad.setPositiveButton("Tamam") { d, i ->
                Toast.makeText(this, "Tamam seçildi", Toast.LENGTH_SHORT).show()
            }
            ad.setNegativeButton("İptal") { d, i ->
                Toast.makeText(this, "İptal seçildi", Toast.LENGTH_SHORT).show()
            }

            ad.create().show()*/

            val ad = AlertDialog.Builder(this)
            val alertTasarim = layoutInflater.inflate(R.layout.alert_tasarim, null)

            val textViewAlert = alertTasarim.findViewById(R.id.textViewAlert) as TextView
            textViewAlert.text = "Yapılacaklar"

            val editTextAlert = alertTasarim.findViewById(R.id.editTextAlert) as EditText
            val checkBoxAlert = alertTasarim.findViewById(R.id.checkBoxAlert) as CheckBox
            val buttonKaydet = alertTasarim.findViewById(R.id.buttonKaydet) as Button
            ad.setView(alertTasarim)
            val d = ad.create()

            buttonKaydet.setOnClickListener {
                val yapilacakIs = editTextAlert.text.toString()
                val acilDurum = checkBoxAlert.isChecked
                Log.e("Alert", "$yapilacakIs - $acilDurum")
                d.dismiss()
            }
            d.show()
        }
    }
}