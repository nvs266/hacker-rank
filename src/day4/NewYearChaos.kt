package day4

/*
 * Complete the 'minimumBribes' function below.
 *
 * The function accepts INTEGER_ARRAY q as parameter.
 */

fun minimumBribes(q: Array<Int>): Unit {
    // Write your code here
    var swapCount = 0
    val swap: (Int, Int) -> Unit = { index1, index2 ->
        val temp = q[index2]
        q[index2] = q[index1]
        q[index1] = temp
    }

    for (i in (q.size - 1) downTo 0) {
        when {
            i >= 1 && q[i - 1] == (i + 1) -> {
                // swap 1 times
                swapCount++
                swap(i - 1, i)
            }
            i >= 2 && q[i - 2] == (i + 1) -> {
                // swap 2 times
                swapCount += 2
                swap(i - 2, i - 1)
                swap(i - 1, i)
            }
            q[i] != i + 1 -> {
                println("Too chaotic")
                return
            }
        }
    }

    println(swapCount)
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val q = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

        minimumBribes(q)
    }
}

// 1    2   5   3   7   8   6   4
// 1    2   3   4   5   6   7   8
// 0    0  -2  +1   -2  -2  +1  +4
//          3
// 1 2 3 5 4 6 7 8
// 1 2 5 3 4 6 7 8
// 1 2 5 3 4 7 6 8
// 1 2 5 3 7 4 6 8
// 1 2 5 3 7 4 8 6
// 1 2 5 3 7 8 4 6
// 1 2 5 3 7 8 6 4

// 1 2 5 3 7 6 4 8 +2
// 1 2 5 3 6 4 7 8 +2
