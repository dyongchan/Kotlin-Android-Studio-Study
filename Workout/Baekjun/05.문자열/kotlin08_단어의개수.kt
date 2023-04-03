package Baekjun.문자열

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args:Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine()

    val result = input.split(" ")

    var count = 0

    for (i in result.indices) {
        if (result[i] == "") {
            continue
        } else {
            count++
        }
    }

    println(count)

}
