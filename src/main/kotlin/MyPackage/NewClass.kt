package MyPackage

fun SayHi():Unit {
  println("Hi!")
}

fun SayHi(name:String):Unit{
    println("Hi, ${name}!")
}

class NewClass(private val name:String){

}