fun main() {
    // LIST
    println("=== LISTS ===")
    
    // Immutable list
    val immutableList = listOf("apple", "banana", "cherry", "date")
    println("Immutable list: $immutableList")
    println("First item: ${immutableList[0]}")
    println("Contains banana? ${immutableList.contains("banana")}")
    
    // Mutable list
    val mutableList = mutableListOf("red", "green", "blue")
    println("Mutable list before: $mutableList")
    mutableList.add("yellow")
    mutableList.removeAt(0)
    println("Mutable list after: $mutableList")
    
    // ArrayList - specific implementation of mutable list
    val arrayList = ArrayList<Int>()
    arrayList.add(1)
    arrayList.add(2)
    arrayList.addAll(listOf(3, 4, 5))
    println("ArrayList: $arrayList")
    
    // List operations
    val numbers = listOf(5, 2, 10, 4, 3, 1)
    println("Original numbers: $numbers")
    println("Sorted: ${numbers.sorted()}")
    println("Reversed: ${numbers.reversed()}")
    
    // SET
    println("\n=== SETS ===")
    
    // Immutable set
    val immutableSet = setOf("apple", "banana", "cherry", "apple")
    println("Immutable set: $immutableSet") // No duplicates
    println("Size: ${immutableSet.size}")
    println("Contains cherry? ${immutableSet.contains("cherry")}")
    
    // Mutable set
    val mutableSet = mutableSetOf(1, 2, 3)
    println("Mutable set before: $mutableSet")
    mutableSet.add(4)
    mutableSet.add(2) // Won't be added as it's already in the set
    mutableSet.remove(1)
    println("Mutable set after: $mutableSet")
    
    // HashSet - specific implementation of mutable set with fast lookups
    val hashSet = HashSet<Char>()
    hashSet.add('a')
    hashSet.add('b')
    hashSet.add('c')
    println("HashSet: $hashSet")
    
    // Set operations
    val set1 = setOf(1, 2, 3, 4, 5)
    val set2 = setOf(4, 5, 6, 7, 8)
    println("set1: $set1")
    println("set2: $set2")
    println("Union: ${set1.union(set2)}")
    println("Intersection: ${set1.intersect(set2)}")
    println("Difference (set1 - set2): ${set1.subtract(set2)}")
    
    // MAP
    println("\n=== MAPS ===")
    
    // Immutable map
    val immutableMap = mapOf(
        "name" to "John",
        "age" to 30,
        "city" to "New York"
    )
    println("Immutable map: $immutableMap")
    println("Name: ${immutableMap["name"]}")
    println("Age: ${immutableMap["age"]}")
    println("Contains 'city'? ${"city" in immutableMap}")
    
    // Mutable map
    val mutableMap = mutableMapOf(
        1 to "One",
        2 to "Two",
        3 to "Three"
    )
    println("Mutable map before: $mutableMap")
    mutableMap[4] = "Four"
    mutableMap[2] = "TWO"
    mutableMap.remove(1)
    println("Mutable map after: $mutableMap")
    
    // HashMap - specific implementation of mutable map with fast lookups
    val hashMap = HashMap<String, Double>()
    hashMap["pi"] = 3.14159
    hashMap["e"] = 2.71828
    hashMap["phi"] = 1.61803
    println("HashMap: $hashMap")
    
    // Map iteration
    println("Map entries:")
    for ((key, value) in immutableMap) {
        println("$key: $value")
    }
    
    // Map keys and values
    println("Keys: ${immutableMap.keys}")
    println("Values: ${immutableMap.values}")
    
    // ARRAY
    println("\n=== ARRAYS ===")
    
    // Creating arrays
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    val stringArray = arrayOf("apple", "banana", "cherry")
    
    // Array operations
    println("Int array: ${intArray.joinToString()}")
    println("First element: ${intArray[0]}")
    
    // Modifying array elements (arrays are mutable)
    intArray[0] = 10
    println("Modified int array: ${intArray.joinToString()}")
    
    // Creating 2D array
    val matrix = Array(3) { IntArray(3) }
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            matrix[i][j] = i * 3 + j + 1
        }
    }
    
    println("2D array (matrix):")
    for (row in matrix) {
        println(row.joinToString())
    }
}