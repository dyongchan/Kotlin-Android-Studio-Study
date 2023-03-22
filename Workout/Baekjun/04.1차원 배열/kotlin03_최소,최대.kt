package Baekjun.일차원배열

import java.util.*

fun main(args:Array<String>) = with(Scanner(System.`in`)) {
    var N = nextInt();

    var min:Int = 1000000
    var max:Int = -1000000

    val arr = arrayOfNulls<Int>(N)

    for ( i in 0 until N) {
        arr[i] = nextInt()
    }

    for (i in 0 until arr.size) {
        if(max < arr[i]!!) {
            max = arr[i]!!
        }

        if(arr[i]!! < min) {
            min = arr[i]!!
        }
    }

    print(min)
    print(" ")
    print(max)
}

// contentToString : 배열 출력 함수
// !! : Nullable 한 타입에서 null이 아님이 확실할 때에 사용