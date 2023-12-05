package com.example.myapplication

fun main(){
    // 1. 메소드
    // 메소드: 함수라고 생각하면 됨
    // fun 메소드이름(변수1:자료형, 변수2:자료형, ....): 반환 자료형{
    //      소스코드 로직
    // }
    // 메소드 사용 예시
    var num1 = readLine()!!.toInt()
    var num2 = readLine()!!.toInt()
    add(num1, num2)

    // ************************************추가 공부*************************************
    // var num1 = readLine()!!.toInt()에서 "값을 입력하세요: " 라는 문구를 띄우고 싶다.
    print("값을 입력하세요: ")
    var num3 = readLine()!!.toInt()
    println(num3)
    // 이런식으로도 쓸 수는 있다. 아얘 한 줄로 줄일 순 없나?
    var num4 = print("값을 입력하세요: ").run { readLine()!!.toInt() }
    println(num4)
    // run이라는 함수를 사용해서 구현한다.
    // run: 확장 함수중 하나인데 객체를 사용할 때 명령문들을 람다블럭으로 묶어서 사용 가능하게 한다.
    // print라는 함수를 사용하면 run으로 람다를 실행시키는것.
    // 람다는 익명함수 형태로 표현되는 코드 블록이다. 중괄호{}안에 기능을 넣는다.
    // { 매개변수 -> 실행할 코드 }
    // 아래에는 람다블록의 예시.
    val multiplyByTwo: (Int) -> Int = { x -> x * 2 }
    println(multiplyByTwo(3))
    // 받은 값을 2배로 만들어주는 코드
    // 예시를 보던 중 또 처음보는 형식이 나왔다.
    // (Int) -> Int ==>> 함수 타입을 나타내는 표기법. kotlin에선 자료형 중에 함수 자료형도 있는것이다!
    // (Int)는 매개변수 목록이다. 여기선 정수형 매개변수 하나를 나타낸다.
    // -> Int 는 반환값의 타입을 나타낸다.
    val concatenateFunction: (String, Int) -> String = { str, num -> "$str$num" }
    val result2 = concatenateFunction("Year: ", 2023)
    println(result2)
    // 이런식으로 매개변수에 다른 자료형을 넣고, 이 자료형들을 string 형태로 반환할 수도 있다.
    //고차함수에도 사용 가능. 오늘 코드카타에서 작성한 코드 중 하나를 가져와본다.
    fun solution(num1: Int, num2: Int): Int {
        if(num1 in 1 .. 100 && num2 in 1 .. 100){
            var answer: Int = num1*1000 / num2
            return answer
        }
        else return 0
    }
    println(solution(3,2))
    // 위 코드는 두 정수를 받아 나눈 후 1000을 곱하는 코드이다
    // 3, 2를 받으면 3/2=1.5, 1.5 * 1000 = 1500 이런식의 결과가 나와야 한다.
    // 하지만 정수형으로 받은 num1과 num2를 나누면 결과도 정수형이기 때문에 3/2 = 1이 되어버린다.
    // 나는 앞 수에 1000을 곱해서 나누는 걸로 해결했지만 함수타입을 이용하면 다르게 해결할 수 있다고 생각했지만..
    fun newSolusion(num1: Int, num2: Int, operation: (Int, Int) -> Float): Float{
        if(num1 in 1 .. 100 && num2 in 1 .. 100){
            return operation(num1, num2)
        }
        else return 0f
    }
    val newResult = newSolusion(3,2) { x, y -> x / y }
    // (Int, Int) -> Float의 의미는 자료형의 변환이 아니였다. 단지 반환값의 자료형을 정하는 것이였고
    // 정해준 자료형과 일치하지 않으면 오류가 발생하는 것이였다.
    val newResult = newSolusion(3,2) { x, y -> (x / y).toFloat() }
    println(newResult)
    // 물론 이렇게 해도 1.5는 안나온다. 1.0이 나올 뿐.
    //*********************************************************************************

    // 2. 클래스
    // kotlin은 객체지향 언어(OOP)이다. 모든 코드를 클래스 형태로 객체화 시킬수 있으며 객체들간의 결합을 통해 유지보수를
    // 쉽게 할 수 있다.
    // OOP의 5대 키워드
    // 1. 클래스   2. 추상화  3. 캡슐화
    // 4. 상속    5. 다형성
    // 클래스: 각 요소별 설계도라고 보면 된다. 하나의 파일 형식임.
    // 이후 클래스 설명은 ClassStudy.kt로.

    // 3. 생성자
    // 클래스를 실체화할 때(인스턴스화) 최초로 실행할 로직 설정
    // 기본 생성자와 명시적 생성자가 있음
    // 기본 생성자는 이전에 봤던 클래스 생성과 차이 없음
    // 명시적 생성자는 주 생성자와 부 생성자로 구분
    // 주 생성자: init{...}
    //   ==>> 클래스 선언부에 생성자를 명시, 매개변수를 직접 생성자로 넘기지 않음
//    class Character(_name:String, _hairColor:String, _height:Double) {
//        var name:String = ""
//        var hairColor:String = ""
//        var height:Double = 0.0
//
//        init {
//            println("매개변수없는 생성자 실행 완료!")
//        }
//    }
    // 부 생성자: constructor
    //    ==>> 생성자에 변수를 넘기는 경우에 사용함. 클래스 선언부에 생성자를 명시할 필요 없음.
    // 여러 형태로 클래스를 실체화할 때 사용.
//    class Character {
//        var name: String = ""
//        var hairColor: String = ""
//        var height: Double = 0.0
//        var age: Int = 0
//        var gender: String = ""
//
//        // 명시적 생성자 (Constructor)
//        // _name, _hairColor, _height 3개만 받는 형태로 생성자 실행
//        constructor(_name: String, _hairColor: String, _height: Double) {
//            println("${_name}을 생성자로 넘겼어요")
//            println("${_hairColor}를 생성자로 넘겼어요")
//            println("${_height}를 생성자로 넘겼어요")
//        }
//
//        // _name, _hairColor, _height, _age, _gender 5개를 받는 형태로 생성자 실행
//        constructor( _name: String, _hairColor: String, _height: Double, _age: Int, _gender: String)
//        {
//            println("${_name}을 생성자로 넘겼어요")
//            println("${_hairColor}를 생성자로 넘겼어요")
//            println("${_height}를 생성자로 넘겼어요")
//            println("${_age}를 생성자로 넘겼어요")
//            println("${_gender}를 생성자로 넘겼어요")
//        }
//    }




    }
// 메소드 예시
fun add(num1:Int, num2:Int){
    println("${num1} + ${num2} = ${num1+num2}")
}

