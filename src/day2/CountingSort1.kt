package day2

/*
 * Complete the 'countingSort' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun countingSort(arr: Array<Int>): Array<Int> {
    // Write your code here
    val result = Array<Int>(100) { 0 }
    arr.forEach { i ->
        result[i] = result[i] + 1
    }

    return result
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = countingSort(arr)

    println(result.joinToString(" "))
}
