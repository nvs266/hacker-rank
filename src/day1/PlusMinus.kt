package day1

/*
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

fun plusMinus(arr: Array<Int>): Unit {
    // Write your code here
    var positive: Int = 0
    var negative: Int = 0
    var zero: Int = 0

    arr.forEach {
        when {
            it > 0 -> {
                positive += 1
            }
            it < 0 -> {
                negative += 1
            }
            else -> {
                zero += 1
            }
        }
    }

    println(String.format("%.6f", positive.toLong().div(arr.size.toFloat())))
    println(String.format("%.6f", negative.div(arr.size.toFloat())))
    println(String.format("%.6f", zero.div(arr.size.toFloat())))
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    plusMinus(arr)
}

