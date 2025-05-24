// Basic function
fun greet() {
    println("Hello, world!")
}

// Function with parameters
fun greetPerson(name: String, greeting: String = "Hello") {
    println("$greeting, $name!")
}

// Function with return value
fun sum(a: Int, b: Int): Int {
    return a + b
}

// Single-expression function
fun multiply(a: Int, b: Int): Int = a * b

// Function with Unit return type (explicit)
fun displayMessage(message: String): Unit {
    println(message)
}

// Function overloading
fun printDetails(name: String) {
    println("Name: $name")
}

fun printDetails(name: String, age: Int) {
    println("Name: $name, Age: $age")
}

// Main function to demonstrate all function types
fun main() {
    greet()
    
    greetPerson("Alice")
    greetPerson("Bob", "Hi")
    
    val result = sum(5, 3)
    println("5 + 3 = $result")
    
    val product = multiply(4, 7)
    println("4 × 7 = $product")
    
    displayMessage("This is a message")
    
    printDetails("Charlie")
    printDetails("David", 30)
}