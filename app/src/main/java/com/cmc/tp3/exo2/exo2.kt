package com.cmc.tp3.exo2

import android.content.pm.PackageManager
import android.Manifest
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.cmc.tp3.R
import com.cmc.tp3.databinding.ActivityExo2Binding
import java.io.File


class exo2 : AppCompatActivity() {

    private lateinit var binding: ActivityExo2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityExo2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val image = binding.image

        binding.local.setOnClickListener {
            image.setImageResource(R.drawable.min)
        }

        binding.url.setOnClickListener {
            Glide.with(this)
                .load("https://i1.sndcdn.com/avatars-000460097835-t201zc-t240x240.jpg")
                .error(R.drawable.ic_launcher_background)
                .into(image)

            Log.d(
                "ImageLoad",
                "Loading image from URL: https://i1.sndcdn.com/avatars-000460097835-t201zc-t240x240.jpg"
            )
        }

        binding.storage.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_CODE)
            }   else {
                loadImage()
            }
        }

    }
    private fun loadImage() {
        val filePath = "${Environment.getExternalStorageDirectory()}/Pictures/Screenshots/madaraEyes.jpg"
        val file = File(filePath)

        if (file.exists()) {
            Glide.with(this)
                .asBitmap()
                .load(file)
                .into(binding.image)
        } else {
            Toast.makeText(this, "File does not exist", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                loadImage()
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val REQUEST_CODE = 100
    }
}