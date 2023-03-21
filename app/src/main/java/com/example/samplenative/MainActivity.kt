package com.example.samplenative

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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
        binding.sampleText.text = stringFromJNI()
        val sum_array = floatFromJNI(arr)
        var x:String = ""
        for (item in sum_array){
            x += item.toString()+ " - "
        }
        binding.sum.text = x
    }

    /**
     * A native method that is implemented by the 'samplenative' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    external fun  floatFromJNI(arr:FloatArray) : FloatArray

    companion object {
        // Used to load the 'samplenative' library on application startup.
        init {
            System.loadLibrary("samplenative")
        }
    }
}