package com.example.unit_converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.unit_converter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //calls Binding for later use
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) //sets binding to layoutInflater
        setContentView(binding.root) //binds binding to contentView from the Root
        determineDropdown()

    }
    fun determineDropdown() {
        val valueChoice = binding.spinnerConvert.selectedItem.toString()
        val distanceArray = resources.getStringArray(R.array.distance)
        val weightArray = resources.getStringArray(R.array.weight)
        val convertAdapter = when(valueChoice)
        {
            "Distance" -> ArrayAdapter(this, android.R.layout.simple_spinner_item,distanceArray)
            else -> ArrayAdapter(this, android.R.layout.simple_spinner_item,weightArray)
        }

        binding.spinnerConvert2.adapter = convertAdapter
        binding.convertResult.adapter = convertAdapter
    }


}