package fastcampus.part0.kotlin

fun main() {
//    for(int i = 0; i < N; i++) {
//        자바의 반복문
//    }

//    1..10 == IntRange(1, 10)
    for( i in 1..10) { // Range 넣어주기
        print(i)
        print(",")
    }
    println()

    // until 어느 숫자 까지 (끝 숫자 포함 X)
    for(i in 1 until 10) {
        print(i)
        print(",")
   }
    println()

    // step : 내부의 값 만큼 범위의 변화 (반드시 양의정수)
    for(i in -10..1 step(2)) {
        print(i)
        print(",")
    }
    println()

    // downTo : 범위를 작은 방향으로 설정
    for(i in 10 downTo 1) {
        print(i)
        print(",")
    }
    println()

    for(i in 10 downTo 1 step(2)) {
        print(i)
        print(",")
    }
    println()

    var c = 1

    while (c < 11) {
        print(c)
        print(",")
        c++
    }
}