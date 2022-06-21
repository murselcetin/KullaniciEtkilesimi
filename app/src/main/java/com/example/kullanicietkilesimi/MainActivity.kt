package com.example.kullanicietkilesimi

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
                .setAction("Evet"){
                    Snackbar.make(it,"Silindi",Snackbar.LENGTH_SHORT)
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

        }
    }
}