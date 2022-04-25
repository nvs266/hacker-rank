package interview

object TrustingSocial {
    /*
     * Complete the 'dominatingXorPairs' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    object Test1 {
        fun run() {
            val arrCount = readLine()!!.trim().toInt()

            val arr = Array<Int>(arrCount, { 0 })
            for (i in 0 until arrCount) {
                val arrItem = readLine()!!.trim().toInt()
                arr[i] = arrItem
            }

            val result = dominatingXorPairs(arr)

            println(result)
        }

        fun dominatingXorPairs(arr: Array<Int>): Long {
            // Write your code here
            var count = 0
            for (i in 0 until arr.size - 1) {
                for (j in i + 1 until arr.size) {
                    if (arr[i] xor arr[j] > arr[i] and arr[j]) {
                        count++
                    }
                }
            }

            return count.toLong()
        }
    }

    object Test2 {
        /*
        * Complete the 'getMaximumMex' function below.
        *
        * The function is expected to return an INTEGER.
        * The function accepts following parameters:
        *  1. INTEGER_ARRAY arr
        *  2. INTEGER x
        */

        fun run() {
            val arrCount = readLine()!!.trim().toInt()

            val arr = Array(arrCount) { 0 }
            for (i in 0 until arrCount) {
                val arrItem = readLine()!!.trim().toInt()
                arr[i] = arrItem
            }

            val x = readLine()!!.trim().toInt()

            val result = getMaximumMex(arr, x)

            println(result)
        }

        fun checkExist(arr: Array<Int>, x: Int, arrCheck: Array<Boolean>, answer: Int): Int? {
            arr.forEachIndexed { index, i ->
                if (!arrCheck[index] &&
                    (i == answer ||
                            (i < answer && (answer - i).mod(x) == 0) ||
                            (i > answer && (i - answer).mod(x) == 0))
                ) {
                    arrCheck[index] = true
                    return index
                }
            }

            return null
        }

        fun getMaximumMex(arr: Array<Int>, x: Int): Int {
            // Write your code here
            val arrCheck = Array(arr.size) { false }
            var answer = 0

//            while (checkExist(arr, x, arrCheck, answer)) {
//                answer++
//            }

            return answer
        }
    }

    object Test3 {
        // 6
        //the
        //bats
        //tabs
        //in
        //cat
        //act
        //3
        //cat the bats
        //in the act
        //act tabs in

        fun run() {
            val wordSetCount = readLine()!!.trim().toInt()

            val wordSet = Array<String>(wordSetCount, { "" })
            for (i in 0 until wordSetCount) {
                val wordSetItem = readLine()!!
                wordSet[i] = wordSetItem
            }

            val sentencesCount = readLine()!!.trim().toInt()

            val sentences = Array<String>(sentencesCount, { "" })
            for (i in 0 until sentencesCount) {
                val sentencesItem = readLine()!!
                sentences[i] = sentencesItem
            }

            val result = countSentences(wordSet, sentences)

            println(result.joinToString("\n"))
        }

        fun countSentences(wordSet: Array<String>, sentences: Array<String>): Array<Long> {
            // Write your code here
            val charWordSet: List<CharArray> = wordSet.map {
                it.toCharArray()
            }

            sentences.map { it.split(" ") }
                .forEach { words ->
                    var answer: Int? = null
                    words.forEach { word ->
                        val charArr = word.toCharArray()
                        val count = charWordSet.count { charArr.contentEquals(it) }
                        if (count != 0) {
                            answer = answer?.let { it * count } ?: count
                        }
                    }
                    println(answer)
                }

            return emptyArray()
        }
    }
}


fun main() {
    TrustingSocial.Test3.run()
}

//7
//0
//1
//2
//2
//0
//0
//10
//3
