package com.example.apexamistryassignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.apexamistryassignment1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var count = 0;

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding. apply {
            txtCount.text = count.toString()
            btnToast.setOnClickListener { showToast(it) }
            btnInc.setOnClickListener { countInc(it) }
            btnDec.setOnClickListener { countDec(it) }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count);
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt("count");
        binding.txtCount.text = count.toString();
    }

    private fun showToast(view: View) {
        Toast.makeText(this, "Hello $count", Toast.LENGTH_LONG).show();
    }

    private fun countInc(view: View) {
        count++
        binding.txtCount.text = count.toString();
    }

    private fun countDec(view: View) {
        count--
        binding.txtCount.text = count.toString();
    }
}