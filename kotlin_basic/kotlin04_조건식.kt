package fastcampus.part0.kotlin

import java.time.DayOfWeek

// kotlin과 java와 다른 점


fun main() {
    max(10,3)
    max2(10,3)
    max3(10,3)
    isHoliday("금")
    isHoliday2("일")

}

fun max(a:Int, b:Int) {
   val result =  if (a>b) { // if 문이 하나의 값이 될 수 있다.
        println(a)
    }
    else {
        println(b)
    }
    println(result) // unit으로 출력 println() = 어떠한 값이 아님
}

fun max2(a:Int, b:Int) {
    val result =  if (a>b) { // if 문이 하나의 값이 될 수 있다.
        a // result로 넣겠다
    }
    else {
        b // result로 넣겠다
    }
    println(result)
}

fun max3(a: Int,b: Int) {
    val result = if (a > b) a else b // (중괄호 생략가능)
}


// 월 화 수 목 금 토 일
fun isHoliday (dayOfWeek: String) {
    // java의 switch 문 대신 when 문 사용
    val result = when(dayOfWeek) {
        "토",
        "일" -> true
        else -> false
    }
    println(result)

//    when(dayOfWeek) { // expression으로 사용 가능
//        기본
//        "월" -> false
//        "화" -> false
//        "수" -> false
//        "목" -> false
//        "금" -> false
//        "토" -> true
//        "일" -> true

//        변형(, 사용)
//        "월" ,
//        "화" ,
//        "수" ,
//        "목" ,
//        "금" -> false
//        "토" ,
//        "일" -> true
        // ,로 묶기 가능

//        변형(, else 사용)
//        "토",
//        "일" -> true
//        else -> false
}

fun isHoliday2 (dayOfWeek: Any) { // Any = 다양한 값 투입가능
    // java의 switch 문 대신 when 문 사용
    val result = when(val day = dayOfWeek) { // 처리할 때 해당값이 필요할 때 다시 받음
        "토",
        "일" -> if(day == "토") "좋아" else "너무 좋아"
        else -> "안좋아"
//        in 2..4 -> {} / 범위
//        in listOf("월", "화") -> {} / 리스트
    }
    println(result)


    }
