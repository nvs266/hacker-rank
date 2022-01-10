package day2

import kotlin.math.max

/*
 * Complete the 'flippingMatrix' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
 */

fun flippingMatrix(matrix: Array<Array<Int>>): Int {
    // Write your code here
    val subMatrixSize = matrix.size / 2 - 1
    val matrixSize = matrix.size - 1
    var maxSum = 0
    for (i in 0..subMatrixSize) {
        for (j in 0..subMatrixSize) {
            maxSum += max(
                max(matrix[i][j], matrix[i][matrixSize - j]),
                max(matrix[matrixSize - i][matrixSize - j], matrix[matrixSize - i][j])
            )
        }
    }
    return maxSum
}

fun main(args: Array<String>) {
    val q = readLine()!!.trim().toInt()

    for (qItr in 1..q) {
        val n = readLine()!!.trim().toInt()

        val matrix = Array<Array<Int>>(2 * n, { Array<Int>(2 * n, { 0 }) })

        for (i in 0 until 2 * n) {
            matrix[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        }

        val result = flippingMatrix(matrix)

        println(result)
    }
}
//1
//2
//112 42 83 119
//56 125 56 49
//15 78 101 43
//62 98 114 108
//result: 414