package Baekjun.반복문

import android.icu.number.IntegerWidth
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var N = Integer.parseInt(readLine())

    for(i in 1 until 10) {
        println(N.toString()+" * "+i+" = "+N*i)
    }

}