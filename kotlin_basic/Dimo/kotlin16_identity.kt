package kotlin_lecture_Dimo

/*
변수의 동일성 체크 방법

내용의 동일성 vs 객체의 동일성
1) 내용의 동일성 : 서로 다른 메모리에 할당된 객체라고 해도 내용이 같을 때에 같다고 나타냄
- 연산자 : ==
- 자동적인 판단은 불가
- 내부적으로 코틀린의 모든 클래스가 상속받는 Any 클래스의 equals 함수가 반환하는 boolean으로 판단
- 기본 자료형이 아닌 커스텀 class 제작 시 open fun equals(other: Any?):Boolean 으로 구현해주어야 한다.

2) 객체의 동일성 : 서로 다른 변수가 메모리 상의 서로 같은 객체를 가리킬 떄에 같다고 나타냄
- 연산자 : ===

 */

fun main() {

    var a = Product("콜라", 1000)
    var b = Product("콜라", 1000)
    var c = a
    var d = Product("사이다", 1000)

    println(a == b) // 값만 일치
    println(a === b)

    println(a == c) // 주소와 값 모두 일치
    println(a === c)

    println(a == d) // 주소와 값 모두 불일치
    println(a === d)

}

class Product(val name: String, val price: Int) {
    override fun equals(other: Any?) : Boolean { // 최상위 클래스인 Any의 equals 구현
        if(other is Product) {
            return other.name == name && other.price == price
        } else {
            return false
        }
    }
}