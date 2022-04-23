package interview

object VulcanLabsTest {
    object Test1 {
        /*
         Write a function that takes an array and check if it is palindrome.
         Example:
         [7, 3, 2, 7]: false
         [1, 9, 1]: true
         [7, 1, 3, 3, 1, 7]: true
         [1, 4, 3, 4, 1]: true
        */

        fun isPalindrome(array: Array<Int>): Boolean {
            val size = array.size - 1
            val middleIndex = array.size.div(2)

            for (i in 0..middleIndex) {
                if (array[i] != array[size - i]) {
                    return false
                }
            }

            return true
        }
    }

    object Test2 {
        /*
         Write a function that takes input integer n and prints the Fibonacci sequence.
         F(0) = 1
         F(1) = 1
         Example: The first 5 numbers
         1, 1, 2, 3, 5
        */

        fun printFibonacciSequence(n: Int) {
            var n1 = 0
            var n2 = 1
            for (i in 0 until n) {
                print("$n2${if (i != n - 1) ", " else ""}")

                val sum = n1 + n2
                n1 = n2
                n2 = sum
            }
        }
    }

    object Test3 {
        /*
         Write a function that find the lowest number by multiplied by 2 numbers in an integer array.
         Example: [6, 4, 5, 3] // 6* 4, 6*5, 6*3, 4*5, 4*3, 5*3
         Output: 12
         Example: [-2, 10, -5, 9]
         Output: -50
        */
        fun findLowestMultiplied(array: Array<Int>): Int? {
            var answer: Int? = null

            val n1 = array[0]
            val n2 = array

            for (i in 0 until array.size - 1) {
                for (j in i + 1 until array.size) {
                    val temp = array[i] * array[j]
                    if (answer == null || temp < answer) {
                        answer = temp
                    }
                }
            }
            return answer
        }
    }
}

fun main() {
    println(VulcanLabsTest.Test1.isPalindrome(arrayOf(1, 4, 3, 4, 1)))
    VulcanLabsTest.Test2.printFibonacciSequence(6)
    println()
    print(VulcanLabsTest.Test3.findLowestMultiplied(arrayOf(-2, 10, -5, 9)))
}
