package com.example.joker.ui.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.function.Predicate

@RequiresApi(Build.VERSION_CODES.N)
fun <T> filter(list: MutableList<T>, predicate: Predicate<T>) {
    val itr = list.iterator()

    while (itr.hasNext())
    {
        val t = itr.next()
        if (predicate.test(t)) {
            itr.remove()
        }
    }
}