package kotlin_lecture_Dimo

/*

Object 객체 : 생성자 없이 객체를 직접 만들어 낼 수 있음
하나의 객체로 공통적인 속성과 함수를 사용 해야 하는 경우 Object객체를 이용함.
- Singleton Pattern을 언어적으로 지원
- 코드 자체에서 공용으로 사용가능
- 공통적으로 사용할 내용들을 묶어서 사용하는 것이 좋다

Companion Object :
클래스의 인스턴스 기능을 사용하면서 인스턴스 간 공용으로 사용할 속성 및 함수를 별도로 만든다.
기능적으로는 Static 멤버과 비슷함


 */

fun main() {
    println(Counter1.count)

    Counter1.cointUp()
    Counter1.cointUp()

    println(Counter1.count)

    Counter1.clear()

    println(Counter1.count)

    var a = FoodPoll("짜장")
    var b = FoodPoll("짬뽕")

    a.vote()
    a.vote()

    b.vote()
    b.vote()
    b.vote()

    println("${a.name} : ${a.count}")
    println("${b.name} : ${b.count}")
    println("총계 : ${FoodPoll.total}")
    // FoodPoll로 생성된 객체가 total을 공유하기 때문에 모든 인스턴스에서 누적이 가능

}

object Counter1 { // 그 자체로 객체 (생성자 사용 x)
    var count = 0

    fun cointUp() {
        count++
    }

    fun clear() {
        count = 0
    }
}

class FoodPoll(val name: String) {
    companion object {
        var total = 0
    }

    var count = 0

    fun vote() {
        total++
        count++
    }
}