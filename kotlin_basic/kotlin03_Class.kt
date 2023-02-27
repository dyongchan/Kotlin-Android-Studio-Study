package fastcampus.part0.kotlin

fun main() {
    val user = User("jyc", 10)
    println(user.age)
    kid("아이", 3, "male")
    /*
    kid 클래스 내에서 init 문이 먼저 실행되고 부생성자가 실행됨.
     */
}

open class User(open val name: String,open var age:Int = 100) { // 생성자
    // 구현부 없으면 {} 생략 가능
    // default = constructor (주생성자)
    // 값 할당 및 프로퍼티 접근가능 및 default 값 삽입 가능
    // 프로퍼티 내부 private 선언시 접근 불가
    // open으로 상속 열기
}

class kid(override val name: String, override var age: Int) : User(name, age) {
    // override : 상속으로 가져올 수 있게함.
    // kotlin은 기본적으로 상속에 닫혀있다. 이를 open을 통해 상속을 열어준다.
    var gender: String = "female"

    init {  // 클래스 안에서 가장 먼저 호출됨.
        println("초기화 중 입니다.")
    }

    constructor(name:String, age: Int, gender: String) : this(name, age) { // this : 자기자신 상속
            // 부생성자
            this.gender = gender
            println("부 생성자 호출")
    }

}
