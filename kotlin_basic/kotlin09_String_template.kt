package fastcampus.part0.kotlin

fun main() {
    val a = 10
    val name = "안녕"
    val isHigh = true

    println(a.toString() + name + isHigh.toString()) // java에서의 String  변환
    String.format("%..") // 타입에 따라 값을 써줌

    println("$a $name ${name.length} $isHigh") // $ 사용하면 문자열로 변경됨 +{} :  추가 정보 출력 가능
}