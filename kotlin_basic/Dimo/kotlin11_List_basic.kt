package kotlin_lecture_Dimo

/*

List : Collection class를 상속받아 만들어진 데이터를 관리하는 sub 클래스 중 일부
- 여러 데이터를 원하는 순서에 넣어 관리하는 방식
- Mutable vs ImMutable
ImMutable = List<out T> : 생성시에 넣은 객체를 대체, 추가, 삭제 불가
Mutable = MutableList<T> : 생성시에 넣은 객체를 대체, 추가, 삭제 가능
- Mutable의 함수의 일부
    1) 추가 add(데이터) / add(인덱스, 데이터)
    2) 삭제 remove(데이터) / removeAt(인덱스)
    3) 정렬 sort()
    4) 섞기 shuffle()
    5) 대체 list[인덱스] = 데이터

 */

fun main() {
    val a = listOf("사과", "딸기", " 배")
    println(a[1])

    for (fruit in a) {
        println("${fruit}:")
    }

    println()

    var b = mutableListOf(6,3,1)
    println(b)

    b.add(4)
    println(b)

    b.add(2,8)
    println(b)

    b.removeAt(1)
    println(b)

    b.shuffle()
    println(b)

    b.sort()
    println(b)
}