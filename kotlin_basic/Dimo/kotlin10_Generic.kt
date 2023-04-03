package kotlin_lecture_Dimo

/*

제너릭(Generic) : 함수나 클래스 선언 시 고정적인 자료형 대신 실제 자료형으로 대체하는 타입 패러미터 받게함
- 캐스팅의 빈도를 줄여 프로그램의 신속한 실행을 가능하게 함
- 일반적으로 <T>를 사용하는 것이 관례
- 여러개의 제너릭을 사용할 때에 <T,U,V>를 사용
- 특정한 수퍼클래스를 상속 받은 클래스 타입으로만 제한하기
 <T: SuperClass 이름 명시>
 ex) 함수 :  fun <T> genericFunc (var param:T) {}
 genericFunc(1) 입력 시 T = int로 자동으로 타입 추론
 ex) 클래스 1 : class GenericClass<T>
 GenericClass<Int> () 타입 패러미터에 수동으로 자료형 지정
 ex) 클래스 2 : class GenericClass<T> (var pref:T) = 생성자에 제너릭 지정
 GenericClass(1) = 지정하지 않아도 자동으로 T = int로 지정
 */

fun main() {
    // UsingGeneric<A>(A()).doShouting() <A>로 넘겨주어도 되지만 생성자를 통해 클래스 A라는 것을 자동 추론
    UsingGeneric(A()).doShouting() // 클래스 A의 인스턴스를 패러미터로 받게하고 함수 실행
    UsingGeneric(B()).doShouting()
    UsingGeneric(C()).doShouting()

    doShouting(B()) // 캐스팅 없이 B의 객체를 함수에 바로 사용할 수 있음
}

fun <T: A> doShouting(t: T) {
    t.shout()
}

open class A {
    open fun shout() {
        println("A가 소리칩니다.")
    }
}

class B : A() {
    override fun shout() {
        println("B가 소리칩니다.")
    }
}

class C : A() {
    override fun shout() {
        println("C가 소리칩니다.")
    }
}

class UsingGeneric<T: A> (val t:T) {
    // T를 A로 제한하고 생성자에서 T에 맞는 인스턴스를 속성 t로 받는다.
    fun doShouting() {
        t.shout()
    }
}