package Baekjun.jungOL


import java.util.Scanner

fun main(args:Array<String>) = with(Scanner(System.`in`)) {

    val A = nextInt()
    val oper = next()
    val B = nextInt()

    operator(A,oper,B)

}

fun operator(a:Int,oper:String,b:Int) {
    val result =  if (oper.equals("+")) {
        print("$a + $b = "+(a+b))
    } else if (oper.equals("-")) {
        print("$a - $b = "+(a-b))
    } else if (oper.equals("/")) {
        print("$a / $b = "+(a/b))
    } else {
        print("$a * $b = "+(a*b))
    }
    return result
}