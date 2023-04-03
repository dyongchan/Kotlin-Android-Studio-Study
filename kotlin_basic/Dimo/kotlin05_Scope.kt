package kotlin_lecture_Dimo

/*
Scope : 변수나 함수 클래스의 공용 범위를 제어
access modifier : Scope 외부에서 Scope 내부로의 접근을 제어

Scope의 3가지 규칙
1. 외부에서는 내부의 Scope 내부의 멤버를 참조연산자로만 참조가 가능 / 객체.연산자 / import 등
2. 동일 Scope 내에서는 멤버를 공유한다.
3. 하위스코프에서 상위스코프의 멤버를 재정의 가능하다.

 */



val a = "패키지 스코프"

class Q {
    val a = "클래스 스코프"
    fun print() {
        println(a)
    }
}

fun main() {
    val a = "함수 스코프"
    println(a)
    Q().print() // 인스턴스를 변수에 담지않고 바로 사용 가능
}

