package com.example.samplenative

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.getdoubledarray.FloatArrayLib
import com.example.samplenative.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.Flow


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var arr = floatArrayOf(5F,3f,4f,5f,5f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method

        val sum_array = FloatArrayLib.simpleNativeLib(baseContext,arr)
        var x = ""
        for (item in sum_array){
            x += item.toString()+ " - "
        }
        binding.sum.text = x

    }

    /**
     * A native method that is implemented by the 'samplenative' native library,
     * which is packaged with this application.
     */

}