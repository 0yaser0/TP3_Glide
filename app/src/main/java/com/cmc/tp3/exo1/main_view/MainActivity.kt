package com.cmc.tp3.exo1.main_view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.cmc.tp3.R
import com.cmc.tp3.exo1.viewModel.CompteViewModel
import com.cmc.tp3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val compteViewModel: CompteViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        compteViewModel.getCount().observe(this, Observer { count ->
            binding.textView.text = count.toString()
        })

        binding.add.setOnClickListener {
            compteViewModel.addNumber()
        }

        binding.min.setOnClickListener {
            compteViewModel.minNumber()
        }

    }
}