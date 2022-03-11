import kotlin.random.Random

fun IntArray.sumMinMax() = this.minOf { it } + this.maxOf{ it }

fun sumMinMax2(array: IntArray): Int {
    return when(array.size){
        0 -> throw NoSuchElementException("Empty array.")
        1 -> array[0]*2
        else -> {
            var min = if(array[0] < array[1]) array[0] else array[1]
            var max = if(array[0] > array[1]) array[0] else array[1]
            for(i in array){
                if(i < min) min = i
                else if(i > max) max = i
            }
            min + max
        }
    }
}

fun String.checkPalindrome() = this == this.reversed()

fun checkPalindrome2(text: String): Boolean {
    var j = text.length - 1
    for(i in text.indices){
        if(i >= j) break
        if(text[i] != text[j--]) return false
    }
    return true
}

fun getSizedUniqueArray(size: Int): IntArray {
    return if(size < 1) throw IllegalStateException("Size cannot be less than 1.")
    else IntArray(size) { i -> i }
}

fun getSizedRandomUniqueArray(size: Int): IntArray {
    return if(size < 1) throw IllegalStateException("Size cannot be less than 1.")
    else {
        val list = mutableListOf<Int>()
        while (list.size != size){
            val i = Random.nextInt()
            if(i !in list) list.add(i)
        }
        list.toIntArray()
    }
}

fun String.toCamelCaseString() = this.split("_")
    .joinToString("") { part -> part.replaceFirstChar { it.uppercase()}}

fun String.toCamelCaseStringFirstSmall() = this.split("_")
    .mapIndexed { i, part -> if(i == 0) part else part.replaceFirstChar { it.uppercase()} }.joinToString("")


fun toCamelCaseString(snakeCase: String, firstSmall: Boolean): String{
    val parts = snakeCase.split("_").toTypedArray()
    val start = if(firstSmall) 1 else 0
    for(i in start until parts.size){
        parts[i] = parts[i].replaceFirstChar { it.uppercase()}
    }
    return parts.joinToString("")
}