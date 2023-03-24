package kotlin_lecture_Dimo
/*
상속의 목적
1. 기존 클래스에서 확장된 기능이나 속성이 추가된 클래스의 생성
2. 여러개의 클래스에서 공통점을 뽑아 코드 관리의 편리성을 위해

장점 : 클래스를 구조적으로 다룬다.
단점 : 코드의 복잡성이 증가한다.
 */

fun main() {
    var a = Animal("피클",4,"개")
    var b = dog("피클",4)

    a.introduce()
    b.introduce()
    b.bark()

    var c = cat("보리",3)

    c.introduce()
    c.crawl()
}

open class Animal (var name:String, var age:Int, var type:String) { // open = 상속을 열어준다

    fun introduce() {
        println("저는${type} ${name}이고. ${age}살 입니다.")
    }
}
/*
상속의 조건
1. 서브 클래스는 수퍼 클래스에 존재하는 속성과 같은 이름의 속성을 가질 수 없다.
2. 서브 클래스의 생성 시 수퍼클래스의 생성자 호출이 필수
 */

class dog(name:String, age:Int) : Animal (name, age,"개"){ // 수퍼 클래스의 생성사 호출
    fun bark() {
        println("${name}이 짖습니다. 왈왈")
    }
}

class cat(name: String, age: Int) : Animal(name,age,"고양이") {
    fun crawl() {
        println("${name}이 웁니다. 냐옹")
    }
}