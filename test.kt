package com.example.myapplication

fun main(){
    // 변수를 선언하는 키워드: var
    var x = 1
    println("변수 x = ${x}")
    // 상수를 선언하는 키워드: val
    val y = 1
    println("상수 y = ${y}")

    //변수는 변경 가능하지만 상수는 변경 불가능
    x = 2   // 오류 x
    // y = 2    -> 오류 O

    // when의 사용법
    var myNum = readLine()!!.toInt()
    when(myNum){
        1 -> println("myNum = 1")
        2 -> println("myNum = 2")
        else -> println("big myNum")
    }
}