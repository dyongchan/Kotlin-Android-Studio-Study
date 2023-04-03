package kotlin_lecture_Dimo

/*

다형성 : 객체가 다양한 성질을 가질 수 있는 특징

Up-Casting : 상위의 자료형의 수퍼클래스의 인스턴스로 생성
Down-Casting : Up-Casting으로 만들어진 상위의 인스턴스를 하위 자료형으로 변환 (as, is 사용)

as : 호환되는 자료형으로 변환해주는 캐스팅 연산자
is : 변수가 자료형에 호환되는지 확인 후 체크 후 변환하는 캐스팅 연산자 / 조건문 내에서 사용

 */

fun main() {

//    var a:Drink = Cola() // Up-Casting : 상위 자료형의 수퍼클래스로 생성
//    var b =  a as Cola // Drink에서 Cola로 동작하는 a를 b의 변수로 반환가능

    var a = Drink()
    a.drink()

    var b: Drink = Cola() // Drink 타입의 Cola 인스턴스 (Up-Casting)
    b.drink();
//    b.washDishes() 참조할 수 없다는 에러 발생 = as 나 is로 Down-Casting이 필요함

    if(b is Cola) { // is로 호환을 확인 후 변환하여 사용
        b.washDishes()
    }

    var c = b as Cola // as로 바로 Cola 인스턴스로 변경
    c.washDishes()
    b.washDishes() // 이전과 달리 참조할 수 없다는 에러가 발생하지 않음 : 반환 + 변경을 동시에 발생

}

open class Drink() {
    var name = "음료"

    open fun drink() {
        println("${name}을 마십니다.")
    }
}

class Cola : Drink() {
    var type = "콜라"

    override fun drink() {
        println("${name}중에 ${type}을 마십니다.")
    }

    fun washDishes() {
        println("${type}로 설거지를 합니다.")
    }
}