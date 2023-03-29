package kotlin_lecture_Dimo

/*
observer : 이벤트가 일어나는 것을 감시하는 감시자의 역할을 생성

안드로이드의 예시
- 키의 입력, 터치 등 함수의 직접 요청이 아닌 시스템이나 루틴으로 발생되는 동작을 이벤트라 부른다.
- 이벤트가 발생할 때마다 즉각적으로 처리할 수 있도록 만드는 것이 옵저버 패턴이다.

이벤트의 수신 클래스와 송신 클래스간의 상호작용을 위해 observer라는 인터페이스 또는 코틀린에서는 listener
라고 부르며 이벤트를 넘겨주는 행위를 callback이라고 부른다.
 */

fun main() {

    EventPrinter().start()

}

interface EventListener {
    fun onEvent(count : Int)
}

class Counter2 (var Listener: EventListener) {
    fun count() {
        for(i in 1..100) {
            if (i % 5 == 0) Listener.onEvent(i)
        }
    }
}

class EventPrinter: EventListener {
    override fun onEvent(count: Int) {
        print("${count}-")
    }

    fun start() {
        val counter = Counter2(this) // EventPrinter 객체 자신을 나타냄
        // 수퍼클래스의 구현부를 전달받는다.
        counter.count()
    }
}

// 익명객체의 사용
//class EventPrinter2 {
//    fun start() {
//        val counter = Counter2(object: EventListener) {
//            Override fun onEvent(coint: Int) {
//                print("${coint}-")
//            }
//        }
//
//    }
//}