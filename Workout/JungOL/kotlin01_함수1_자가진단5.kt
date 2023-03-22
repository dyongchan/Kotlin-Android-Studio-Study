package Baekjun.jungOL

import java.util.Scanner

fun main(args:Array<String>) = with(Scanner(System.`in`)) {
    val m = nextInt()
    val n = nextInt()

    print(involution(m,n))

}

fun involution(m:Int, n:Int) : Int {
    var sum =  m

    for (i in 1 until n) {
        sum *= m
    }


    return sum
}