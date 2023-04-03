package kotlin_lecture_Dimo

/*
고차함수(higher-order function) 와 람다함수(lambda function)

고차함수 : 함수를 인스턴스처럼 취급할 수 있음
- 패러미터 (인자) 로 넘겨주기
- 결과값으로 반환

람다함수 : 자체가 고차함수이기에 연산자가 필요없다.
 */

fun main() {

    b(::a) // 함수를 패러미터로 받을 때에는 :: 추가

    val c: (String)->Unit = { str -> println("$str 람다함수") }
    // 자료형대신 함수의 형식 작성
    // 기본 : str: String이 맞지만 kotlin의 타입추론으로 이전에 작성한 (String) 때문에 생략가능
    /*
    축약한 람다식
    val c = {str: String -> println("$str 람다함수")
    변수 c에 (String) -> Unit 자료형으로 함수형식의 객체로써 저장된다.
     */
    b(c)

    // 람다 함수
    val calculate :(Int, Int) -> Int = {a,b -> // 마지막 구문인 a+b를 int로 반환한다.
        println(a)
        println(b)
        a+b
    }

    val a:() -> Unit = { println("패러미터가 없어요") } // 패러티머가 존재하지 않는 람다함수

    val d:(String) -> Unit = { println("$it 람다함수") } // 패러미터가 하나일 떄에는 it으로 인자의 자료형을 받아옴
}

fun a (str: String) {
    println("$str 함수 a")
}
/*

 */

fun b(function: (String) -> Unit) {
/*
 함수를 받아오는데, 받아올 함수의 (인자) -> (반환형)을 작성해준다.
 Unit : 반환값이 없다.
 */
    function("b가 호출한")
}



