package com.example.getdoubledarray

import android.content.Context
import android.util.Log
import kotlin.FloatArray

private const val TAG = "FloatArrayLib"
class FloatArrayLib {

    companion object {
        // Used to load the 'samplenative' library on application startup.
        init {
            System.loadLibrary("samplenative")
        }
        fun simpleNativeLib( context: Context,floatArr: FloatArray) : FloatArray{
            Log.d(TAG, "simpleNativeLib: ")
            Log.d(TAG, "simpleNativeLib: sample")
            return floatFromJNI(floatArr)
        }

        external fun floatFromJNI(floatArr: FloatArray): FloatArray
    }




}