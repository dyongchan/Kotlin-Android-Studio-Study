package kotlin_lecture_Dimo

fun main() {
    var test3 = "kotlin.kt"
    var test4 = "java.java"

    // 지정한 문자열로 시작하는지 boolean 형태로 반환
    println(test3.startsWith("java"))
    println(test4.startsWith("java"))

    println()

    // 지정한 문자로 끝나는지 boolean 형태로 반환
    println(test3.endsWith(".kt"))
    println(test4.endsWith(".kt"))

    println()

    // 해당 문자열을 포함하는지 boolean 형태로 반환환
    println(test3.contains("lin"))
    println(test4.contains("lin"))
}