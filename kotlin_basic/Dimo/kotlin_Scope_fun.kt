package kotlin_lecture_Dimo

/*
Scope function :
- 함수형 언어의 특징의 편리한 사용을 위해 기본제공하는 함수
- 클래스의 인스턴스를 스코프 함수로 전달 시 인스턴스의 속성이나 함수를 깔끔하게 불러서 사용 가능
- 코드의 가독성을 증가시켜줌

apply :
- 인스턴스를 생성 후 변수에 담기전에 초기화 과정에 많이 사용
run :
- 여러줄의 람다함수 처럼 마지막 구문의 결과값을 반환함
- 인스턴스가 생성된 후에 인스턴스의 함수나 속성을 scope내에서 사용할 때 유용
with :
- run과 동일한기능을 가지지만 참조연산자 대신 패러미터로 받음
also : apply의 기능을 가짐 (처리가 끝나면 인스턴스 반환)
let : run의 기능을 가짐 (처리가 끝나면 최종값을 반환)
also let = 참조연산자 없이 사용하는 apply와 run 과 다르게 패러미터를 통해 it을 이용함
- 같은 이름의 변수나 함수가 scope 밖에 존재할 때 혼란을 방지하기 위해 존재
 */

fun main() {
    var price = 5000

    // apply를 사용하여 인스턴스의 생성과 동시에 내부의 값을 설정하고 자신을 반환하여 변수에 넣을 수 있음
    // 참조연산자를 사용하지 않아 코드를 깔끔하게 만들 수 있다.
    var a = Book("디모의 코틀린", 10000).apply {
    name = "[초특가]" + name
    discount()
    }
    // run을 사용하여 a의 가격을 1번 출력하고 b에는 a의 name을 저장함
    // 인스턴스가 생성된 후에 인스턴스의 함수나 속성을 scope내에서 사용할 때 유용
    var b = a.run {
        println(a.price)
        a.name
    }
    println(b)
    println(b)

    // run의 사용
    a.run {
        println("상품명: ${name}, 가격: ${price}원") // apply 보다 main의 price를 우선시함
    }

    a.let {
        println("상품명: ${it.name}, 가격: ${it.price}원")
    }

    // wㅑth의 사용
    with(a) {
        println("상품명: ${name}, 가격: ${price}")
    }
}

class Book(var name:String, var price: Int) {
    fun discount() {
        price-= 2000
    }
}

