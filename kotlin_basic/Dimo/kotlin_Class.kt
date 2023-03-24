package kotlin_lecture_Dimo

fun main() {

    var a = Person("박보영",1990) // 객체(인스턴스) 생성
    var b = Person("전정국",1997)
    var c = Person("장원영",2004)
    var d = Person("조용찬") // 기본생성자 + 보조생성자로 인스턴스 초기화
    var e = Person("안녕")

//    a.introduce() // 객체.함수명으로 참조하여  함수 사용가능
//    b.introduce()
//    c.introduce()
}
class Person (var name:String, val birthYear:Int) {
    init{ // 파라미터나 반환형이 존재하지 않음 = 클래스 생성 시 인스턴스의 초기화 진행
        println("안녕하세요 ${this.birthYear}년생 ${this.name}입니다.")
    }
    /*
    constructor : 보조 생성자 = 기본 생성자와 다른 형태
    인스턴스 생성 시 편의 제공 및 추가적인 구문 수행 제공
    항상 기본생성자를 통해 초기화 후 진행행     */
    constructor(name: String) : this(name, 1997) { // : this = 기본생성자로 속성 초기화
        println("1997년생인 ${this.name} 입니다.")

   }

//    fun introduce() { // 클래스 내의 함수
//        println("안녕하세요 ${birthYear}년생 ${name}입니다.")
//    }

}