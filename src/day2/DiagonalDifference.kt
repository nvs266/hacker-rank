package day2

import kotlin.math.abs

/*
 * Complete the 'diagonalDifference' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    // Write your code here
    var sumLeftDiagonal = 0
    var sumRightDiagonal = 0
    for (i in arr.indices) {
        sumLeftDiagonal += arr[i][i]
        sumRightDiagonal += arr[arr.size - 1 - i][i]
    }

    return abs(sumLeftDiagonal - sumRightDiagonal)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = diagonalDifference(arr)

    println(result)
}