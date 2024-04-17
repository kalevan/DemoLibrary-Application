package com.custom.testlibrary

import android.util.Log
import timber.log.Timber

/**
 * Created by Michael Ruppen on 15.04.2024
 */
class CustomFile(
    val testBool: Boolean
) {

    fun mySuperFun() {
        Log.d("TestLibrary", "Bool was: $testBool")
        if (BuildConfig.BUILD_TYPE == "debug") {
            Timber.plant(Timber.DebugTree())
        }

        Timber.d("Log for debug only")
    }
}