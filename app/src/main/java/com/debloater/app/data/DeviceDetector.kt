package com.debloater.app.data

import android.os.Build

object DeviceDetector {
    fun getBrand(): String = Build.MANUFACTURER
    fun getModel(): String = Build.MODEL
    fun getAndroidVersion(): String = Build.VERSION.RELEASE
}
