fun main() {
    // Task 1: Create variables for a person's name, age, and whether they're a student
    val name = "John Doe"
    val age = 25
    val isStudent = true
    
    // Task 2: Create a function to print person's details
    printPersonDetails(name, age, isStudent)
    
    // Task 3: Calculate and print the year a person was born
    val currentYear = 2025
    val birthYear = calculateBirthYear(age, currentYear)
    println("$name was born in $birthYear")
    
    // Task 4: Check if the person is an adult and print message
    checkAndPrintAdultStatus(name, age)
    
    // Task 5: Print a customized message based on student status
    printStudentMessage(name, isStudent)
}

fun printPersonDetails(name: String, age: Int, isStudent: Boolean) {
    println("Person Details:")
    println("Name: $name")
    println("Age: $age")
    println("Is Student: $isStudent")
}

fun calculateBirthYear(age: Int, currentYear: Int): Int {
    return currentYear - age
}

fun checkAndPrintAdultStatus(name: String, age: Int) {
    if (age >= 18) {
        println("$name is an adult")
    } else {
        println("$name is not an adult")
    }
}

fun printStudentMessage(name: String, isStudent: Boolean) {
    if (isStudent) {
        println("$name is currently studying")
    } else {
        println("$name is not a student")
    }
}