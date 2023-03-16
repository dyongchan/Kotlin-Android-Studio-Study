package fastcampus.part0.kotlin

fun main() {
    // language 단계에서 Null이 될 수 있는 값과 될 수 없는 값을 분류한다.
    // java와 다른 중요한 차이 중 하나이다.

    var name : String = "용찬"
    var number : Int = 10
    //  name = null : 이 들어갈 수 없는 타입이다.
    //  number = null : 이 들어갈 수 없는 타입이다.

    var nickname: String? = "용가리" // 타입 + ? 해당 타입이 null이 들어 갈 수 있다.
    var sencondNumber : Int? = null

//    var result = if(nickname == null) {
//        "값이 없음"
//    } else {
//        nickname
//    }
//
//    println(result)

    // kotlin에서의 null 체크법
    nickname = null
    val result = nickname?: "값이 없음" // nickname이 null 이면 우측 문장을 출력해라
    println(result)

    nickname = null
    val size = nickname?.length // ?를 붙임으로 null이면 null / null이 아니면 length값 가져옴
        nickname?: "없음" // 엘비스 오퍼레이터 : null이면 오른쪽 아니면 왼쪽 가져옴
    // ? 대신 !!를 쓸 수 있긴하지만 !!를 쓰는 경우는 nullable한 타입이지만 반드시 null이 아닐 때 사용할 수 있음
    // !!가 있긴하지만 선언할때 null이 가능한지 불가능한지 미리 선언해주는게 좋다.

}