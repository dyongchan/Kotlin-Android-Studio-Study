package fastcampus.part0.kotlin

fun main() {
    // java 와의 차이 : mutable or immutable 선택가능
    // default = immutable
    // 확장함수가 엄청나게 많아서 반복문을 쓸 경우가 적다.
    // 확장함수에 대한 학습을 많이 해야한다.

    val list = mutableListOf(1,2,3,4,5) // 변경이 가능한 리스트
    list.add(6)
    list.addAll(listOf(7,8,9))

    val list1 = listOf(1,2,3,4) // 변경이 불가능한 리스트
    // list1.add 불가
    list1[0] // get 메소드와 동일하게 []를 사용할 수 있다.

    println(list) // 참조하는 주소값을 가져온다. 값을 읽어낼 수는 없다.

    println(list.joinToString(",")) //

    val map = mapOf((1 to "안녕"),(2 to "Hello"))
    val map_m = mutableMapOf((1 to "안녕"),(2 to "Hello"))

    // map.put 불가
    map_m.put(3, "Hi")
    map_m[4] = "hh" // put 대신 [] (index operator 를 사용할 수 있다.)

    val diverseList = listOf(1, "안녕", 1.78, true) // 다양한 값을 넣을 수 있다.

    println(list1.map { it * 10 }.joinToString ("/")) // 내부의 값을 변형하고 / 로 나눠 출력

}