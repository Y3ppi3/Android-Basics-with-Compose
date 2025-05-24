fun main() {
    // Integer variables
    val count: Int = 10
    println("You have $count unread messages.")
    
    // String variables
    val name: String = "Kotlin"
    println("Hello, $name!")
    
    // Using var for mutable variables
    var score = 0
    println("Score: $score")
    score = 100
    println("New score: $score")
    
    // Type inference
    val temperature = 25 // Int is inferred
    val greeting = "Good morning" // String is inferred
    
    // Numeric data types
    val byte: Byte = 127 // 8-bit signed integer, range: -128 to 127
    val short: Short = 32767 // 16-bit signed integer, range: -32768 to 32767
    val int: Int = 2147483647 // 32-bit signed integer, range: -2^31 to 2^31-1
    val long: Long = 9223372036854775807L // 64-bit signed integer, range: -2^63 to 2^63-1
    
    // Floating-point numbers
    val float: Float = 3.14f // 32-bit floating point number
    val double: Double = 3.14159265359 // 64-bit floating point number
    
    // Boolean
    val isOnline: Boolean = true
    println("User is online: $isOnline")
    
    // Character
    val letter: Char = 'A'
    println("First letter: $letter")
}