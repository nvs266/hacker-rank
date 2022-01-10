package day2

/*
 * Complete the 'lonelyinteger' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY a as parameter.
 */

fun lonelyinteger(a: Array<Int>): Int {
    // Write your code here
    val hashSet = hashSetOf<Int>()
    a.forEach {
        val isExist = !hashSet.add(it)
        if (isExist) {
            hashSet.remove(it)
        }
    }
    return hashSet.first()
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = lonelyinteger(a)

    println(result)
}