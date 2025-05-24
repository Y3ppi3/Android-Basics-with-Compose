// Basic class
class Person(val name: String, var age: Int)

// Class with init block and secondary constructor
class Student(val name: String, var grade: Int) {
    var school: String = "Default School"
    
    init {
        println("Student created: $name")
    }
    
    // Secondary constructor
    constructor(name: String, grade: Int, school: String) : this(name, grade) {
        this.school = school
    }
    
    // Method
    fun study() {
        println("$name is studying")
    }
}

// Class with getters and setters
class Temperature {
    var celsius: Float = 0.0f
        set(value) {
            field = value
            fahrenheit = (value * 9/5) + 32
        }
    
    var fahrenheit: Float = 32.0f
        set(value) {
            field = value
            celsius = (value - 32) * 5/9
        }
}

// Data class
data class Product(val id: Int, val name: String, val price: Double)

// Enum class
enum class DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// Enum class with properties
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

// Sealed class
sealed class Result {
    class Success(val data: Any) : Result()
    class Error(val message: String) : Result()
    object Loading : Result()
}

// Extension function
fun String.addExclamation(): String {
    return this + "!"
}

fun main() {
    // Creating objects
    val person = Person("Alice", 25)
    println("Person: ${person.name}, ${person.age}")
    
    val student1 = Student("Bob", 10)
    println("Student: ${student1.name}, Grade: ${student1.grade}, School: ${student1.school}")
    
    val student2 = Student("Charlie", 11, "Science High")
    println("Student: ${student2.name}, Grade: ${student2.grade}, School: ${student2.school}")
    student2.study()
    
    // Using custom getters and setters
    val temp = Temperature()
    temp.celsius = 30.0f
    println("Temperature: ${temp.celsius}°C is ${temp.fahrenheit}°F")
    temp.fahrenheit = 68.0f
    println("Temperature: ${temp.celsius}°C is ${temp.fahrenheit}°F")
    
    // Data class
    val product1 = Product(1, "Laptop", 999.99)
    val product2 = Product(1, "Laptop", 999.99)
    println("Products are equal: ${product1 == product2}")
    
    // Destructuring data class
    val (id, name, price) = product1
    println("Product details - ID: $id, Name: $name, Price: $price")
    
    // Copy data class
    val discountedProduct = product1.copy(price = 899.99)
    println("Discounted product: $discountedProduct")
    
    // Enum
    val today = DayOfWeek.MONDAY
    println("Today is $today")
    
    // Enum with properties
    val favoriteColor = Color.BLUE
    println("RGB value of ${favoriteColor.name} is ${favoriteColor.rgb.toString(16)}")
    
    // Sealed class
    val result: Result = Result.Success("Data loaded")
    val message = when(result) {
        is Result.Success -> "Success: ${(result as Result.Success).data}"
        is Result.Error -> "Error: ${(result as Result.Error).message}"
        Result.Loading -> "Loading..."
    }
    println(message)
    
    // Extension function
    val greeting = "Hello"
    println(greeting.addExclamation())
}