package interview

class Test1 {

    fun solution(list: Array<Int>): Boolean {
        for (i in list.indices) {
            for (j in i + 1 until list.size) {
                if (list[i] == list[j]) {
                    return true
                }
            }
        }

        return false
    }

    fun checkDuplicateValue(list: Array<Int>): Boolean {
        val set = mutableSetOf<Int>()
        list.forEach {
            val isExist = !set.add(it)
            if (isExist) return true
        }
        return false
    }
}

fun String.contain(other: String?): Boolean {
    if (other.isNullOrEmpty()) return false

    forEachIndexed { index, c ->
        val firstCharacterIsSameWithOther = c == other[0]
        if (firstCharacterIsSameWithOther) {
            val endIndex = index + other.length
            if (endIndex > length) return false

            // Check contain
            for (i in other.indices) {
                if (get(index + i) != other[i]) continue
                if (i == other.length - 1) return true
            }
        }
    }

    return false
}

fun main() {
    print("".contain(""))
}