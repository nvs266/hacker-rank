package day4

/*
 * Complete the 'gridChallenge' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING_ARRAY grid as parameter.
 */

fun gridChallenge(grid: Array<String>): String {
    // Write your code here
    var result = true

    grid.forEachIndexed { index, s ->
        grid[index] = s.toCharArray().let {
            it.sort()
            it.joinToString(separator = "")
        }

        if (index > 0) {
            val currentRow = grid[index]
            val upperRow = grid[index - 1]

            for (i in currentRow.indices) {
                if (currentRow[i] < upperRow[i]) {
                    result = false
                    return@forEachIndexed
                }
            }
        }
    }

    return if (result) "YES" else "NO"
}

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()

    for (tItr in 1..t) {
        val n = readLine()!!.trim().toInt()

        val grid = Array<String>(n, { "" })
        for (i in 0 until n) {
            val gridItem = readLine()!!
            grid[i] = gridItem
        }

        val result = gridChallenge(grid)

        println(result)
    }
}