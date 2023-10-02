package com.mc7.firstapptry.ui.homemenu

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mc7.firstapptry.databinding.ActivityAritmatikaBinding

class AritmatikaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAritmatikaBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAritmatikaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            binding.txtResult.text = result
        }

        binding.btnHitung.setOnClickListener{
            val inputLength  = binding.edtLength.text.toString().trim()
            val inputWidth   = binding.edtWidth.text.toString().trim()
            val inputHeight  = binding.edtHeight.text.toString().trim()
            var isEmptyField = false

            if (inputLength.isEmpty()){
                isEmptyField = true
                binding.edtLength.error = "Panjang tidak Boleh Kosong"
            }
            if (inputWidth.isEmpty()){
                isEmptyField = true
                binding.edtWidth.error = "Lebar tidak Boleh Kosong"
            }
            if (inputHeight.isEmpty()){
                isEmptyField = true
                binding.edtHeight.error = "Tinggi tidak Boleh Kosong"
            }

            if (!isEmptyField){
                val volume = inputLength.toDouble() * inputWidth.toDouble() *
                        inputHeight.toDouble()

                volume.toString()

                binding.txtResult.text = "Hasil nilai volumenya adalah $volume"
            }
        }
    }

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, binding.txtResult.text.toString())
    }
}