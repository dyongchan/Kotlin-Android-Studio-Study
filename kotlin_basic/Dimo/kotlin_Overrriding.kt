package kotlin_lecture_Dimo

fun main() {
    var t = tico()

    t.run()
    t.accerlate()

    var d = Dog()
    d.run()
    d.eat()
}
// Overriding
open class Animal02 (var name:String) {
    open fun eat() {
        println("음식을 먹습니다")
    }
}
class Tiger() : Animal02("타이거") {
    override fun eat() { // 수퍼 클래스의 함수를 오버라이드를 통해 재구현
        println("고기를 먹습니다.")
    }
}
// 추상 클래스와 수 함수
abstract class car { // 추상클래스 = 단독으로 객체(인스턴스) 생성 불가
    abstract fun accerlate()
    fun run() {
        println("달리는 중입니다.")
    }

}

class tico() : car() {
    override fun accerlate() {
        println("과속 중입니다.")
    }
}

// Interface
/*
kotlin의 인터페이스
1. 추상함수, 일반함수, 속성 소유 가능
2. 추상 함수 : 생성자 소유가능 / 인터 페이스 생성자 소유 불가
3. 구현부 O = open 함수 / X  = abstract 함수로 간주
: 키워드 없이 서브클래스에 구현 및 재정의 가능
4. 다중 상속을 통해 유연한 프로그래밍 설계가 가능하다.
 */

interface Runner {
    fun run()
}

interface Eater {
    fun eat() {
        println("음식을 먹습니다.")
    }
}
class Dog : Runner, Eater {
    override fun run() { // 추상 함수 구현
        print("다다다다")
    }

    override fun eat() { // Override를 통한 재정의
        println("허겁지겁 먹습니다.")
    }
}
