package kotlin_lecture_Dimo
/*
null 객체와 값의 처리 방법
null 객체는 null 인지 확인이 되지 않으면 컴파일이 되지 않는 특성이 있기 떄문에 if 문으로 조건을 체크해야한다.
조건의 편리한 체크를 위한 연산자
1) null safe operator = ?.
- 객체가 null 인지 확인
- null이면 뒤쪽 구문을 실행하지 않는다.
- sample?.toUpperCase / null이면 toUpperCase 실행 x

2) elvis operator = ?:
- 객체가 null이 아니라면 그대로 사용
- null 이면 우측의 객체로 대체
- ex) sample?:"default"

3) non-null assertion operator = !!.
- null 여부를 컴파일 시 확인하지 않도록 한다
- null pointer exception이 발생 해도 상관 없이 의도적으로 방치
- ex) sample!!.toUpperCase()
 */


fun main() {
    var a: String? = null

//    println(a?.toUpperCase())
//
//    println(a?:"default".toUpperCase())
//
//    println(a!!.toUpperCase())

    a?.run { // null 이기에 run 스코프 함수가 실행되지 않음 (null 체크시 우용함)
        println(toUpperCase())
        println(toLowerCase())
    }


}