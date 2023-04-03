package Baekjun.반복문

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args:Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var input = Integer.parseInt(readLine())

    for (i in 1..input) {
        for(i in 1..i) {
            print("*")
        }
        println()
    }
}