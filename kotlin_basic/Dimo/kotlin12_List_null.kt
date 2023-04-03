package kotlin_lecture_Dimo

fun main() {
    val nuLLString: String? = null
    val emptyString = ""
    val blankStrng = "   "
    val normalString = "A"

    /*
     문자열이 비어있는지 boolean으로 반환받는 방법
     1) inNullOrEmpty() = null or 아예 값이 없음 (공백 포함)
     2) isNullOrBlank() = null or 공백은 제외하고 값이 없음
     공백 : 눈에 보이지 않는 문자도 포함
     */

    println(nuLLString.isNullOrEmpty())
    println(emptyString.isNullOrEmpty())
    println(blankStrng.isNullOrEmpty())
    println(normalString.isNullOrEmpty())

    println()

    println(nuLLString.isNullOrBlank())
    println(emptyString.isNullOrBlank())
    println(blankStrng.isNullOrBlank())
    println(normalString.isNullOrBlank())


}