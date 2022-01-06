package day1

/*
 * Complete the 'findMedian' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun findMedian(arr: Array<Int>): Int {
    // Write your code here
    return arr.sortedArray()[arr.size / 2]
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = findMedian(arr)

    println(result)
}