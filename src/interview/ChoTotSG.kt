package interview

fun test(): Int {

    val levels = arrayOf(5, 6, 3, 6, 7, 4, 9, 1, 1000)

    var startIndex = 0
    var endIndex = 1

    var answer = levels[endIndex] - levels[startIndex]

    while (endIndex < levels.size) {
        while (endIndex < levels.size && levels[endIndex] < levels[startIndex]) {
            if (levels[endIndex] < levels[startIndex]) startIndex = endIndex
            endIndex++
        }

        while (endIndex < levels.size && levels[endIndex] > levels[startIndex]) {
            if (levels[endIndex] - levels[startIndex] > answer) answer = levels[endIndex] - levels[startIndex]
            endIndex++
        }

        startIndex = endIndex
        endIndex = startIndex + 1
    }

    return if (answer < 0) return -1 else answer
}