package kotlin_lecture_Dimo

fun main() {
 val test1 = "Test.Kotlin.String"
 println(test1.length) // 문자열 길이
 println(test1.toLowerCase()) // 소문자 변환
 println(test1.toUpperCase()) // 대문자 변환

 val test2 = test1.split(".") // 특정 조건으로 문자열 잘라 리스트로 반환

 println(test2)

 println(test2.joinToString()) // 문자열 합치기
 println(test2.joinToString("-")) // -를 문자열 사이에 넣어서 합치기

 println(test1.substring(5..10)) // 5~10까지의 인덱스의 문자열 출력

}

