package fastcampus.part0.kotlin

fun main() {
    // java = object instanceOf 로 어떤 타입이 맞는지 check를 했음
    // kotlin의 다른 방식
    // object is Type

    println(check(1))
    println(check1(true))
    cast("안녕")
    cast(1)
    println(smartcast("안녕"))
    println(smartcast(10))
    println(smartcast(true))
}

fun check(a: Any): String {
    return if(a is String) {
        "문자열"
    } else if (a is Int) {
        "숫자"
    } else {
        "뭐징"
    }
}

fun check1(a: Any): String {
    return when (a) { // when문에서도 is 사용가능
        is String -> {
            "문자열"
        }
        is Int -> {
            "숫자"
        }
        else -> {
            "뭐징"
        }
    }
}

fun cast(a: Any) {
    val result = (a as? String) ?: "실패"
    // 1. as = a를 String으로 받겠다.
    // 2. as?로 변경 시 알아서 null로 바꿔준다.
    // 3. 엘비스 오퍼레이터 설정 null이 나오면 왼, 아니면 오
    println(result)
}

fun smartcast(a: Any): Int {
    return if(a is String) { // a가 String이 확인되면 바로 원하는 값 접근 가능
        a.length
    } else if (a is Int) {
        a.dec() // 숫자 - 1
    } else {
        -1
    }
}