package Baekjun.일차원배열

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args:Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {

    var arr= arrayOfNulls<Boolean>(31)

    for (i in 0 until 28){
        arr[Integer.parseInt(readLine())] = true
    }

    for (i in 1 until arr.size) {
        if(arr[i] == null) {
            println(i)
        }
    }

}