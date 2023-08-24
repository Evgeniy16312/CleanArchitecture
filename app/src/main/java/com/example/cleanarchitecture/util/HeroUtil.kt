package com.example.cleanarchitecture.util

import android.graphics.Color


fun getProWinRateTextColor(proWinRate: String): Int {
    val proWR = proWinRate.toInt()
    var textColor = "#F61E50"
    if (proWR > 50) textColor = "#2ED470"
    return Color.parseColor(textColor)
}
