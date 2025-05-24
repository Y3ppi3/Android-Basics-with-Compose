// High-order function that takes a function as parameter
fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

// Function that returns a function
fun createMultiplier(factor: Int): (Int) -> Int {
    return { number -> number * factor }
}

fun main() {
    // Lambda expression basics
    val sum = { a: Int, b: Int -> a + b }
    println("Sum of 5 and 3: ${sum(5, 3)}")
    
    // Using lambda with type declaration
    val multiply: (Int, Int) -> Int = { a, b -> a * b }
    println("5 * 3 = ${multiply(5, 3)}")
    
    // Passing lambdas to functions
    val result1 = operateOnNumbers(10, 5, { a, b -> a + b })
    println("10 + 5 = $result1")
    
    // Trailing lambda syntax
    val result2 = operateOnNumbers(10, 5) { a, b -> a - b }
    println("10 - 5 = $result2")
    
    // Function returning a function
    val doubler = createMultiplier(2)
    println("Double 7: ${doubler(7)}")
    
    val tripler = createMultiplier(3)
    println("Triple 7: ${tripler(7)}")
    
    // Anonymous functions
    val divide = fun(a: Int, b: Int): Int {
        if (b == 0) throw IllegalArgumentException("Cannot divide by zero")
        return a / b
    }
    println("10 / 2 = ${divide(10, 2)}")
    
    // it: implicit name of single parameter
    val square: (Int) -> Int = { it * it }
    println("Square of 8: ${square(8)}")
    
    // Capturing variables from scope (closure)
    var counter = 0
    val incrementCounter = { counter++ }
    incrementCounter()
    incrementCounter()
    println("Counter: $counter")
    
    // Using standard library functions with lambdas
    val numbers = listOf(1, 2, 3, 4, 5)
    
    // forEach
    print("Numbers: ")
    numbers.forEach { print("$it ") }
    println()
    
    // map
    val doubled = numbers.map { it * 2 }
    println("Doubled: $doubled")
    
    // filter
    val evenNumbers = numbers.filter { it % 2 == 0 }
    println("Even numbers: $evenNumbers")
    
    // reduce
    val sumOfNumbers = numbers.reduce { acc, num -> acc + num }
    println("Sum: $sumOfNumbers")
}