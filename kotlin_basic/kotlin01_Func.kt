package fastcampus.part0.kotlin

import android.provider.ContactsContract

fun main() {
    val result = test1(1,2)
    test2(id="chan", name= "jyc", nickname = "yc") // 인자에 대한 값을 순서 상관 x 명시적으로 표현 가능
    println("Hello World!!")
    test() // 함수의 호출
}

// 2 . 함수
fun test() { // Unit이 안보이게 존재 (생략가능)
    println("test")
}

fun test1(a: Int, b: Int = 3, c: Int = 4) : Int { // return 타입 선언
    println(a+b)
    return a+b
}

fun test1(a: Int) : Int { // Java 에서의 오버로딩
    val b = 3
    println(b)
    return a+b
}

/* fun test1(a: Int, b: Int =  3) : Int {
 // 오버로딩 필요없이 default 값을 지정할 수 있음
}
 */

/* fun test1(a: Int, c = 5) : Int {
 // 오버로딩 필요없이 default 값을 변경하여 사용가능
}
 */

fun test2(name: String, nickname: String, id:String) {
    println(name + nickname + id)
}

// fun test2(name: String, nickname: String, id:String) = println(name + nickname + id) 로 표현가능

fun time(a:Int, b:Int) = a * b // (single expression)
// 간결한 코드의 작성이 가능

fun t_c(a:Int, b:Int,) = a * b // tralling comma 기능 (추가될 수 있는 인자를 위해 컴파일 에러 발생 x)