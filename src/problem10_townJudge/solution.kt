package problem10_townJudge

class Solution {
    fun findJudge(N: Int, trust: Array<IntArray>): Int {
        if (N == 1) return 1

        val trustRate = mutableMapOf<Int, Int>()
        val trusters = mutableSetOf<Int>()
        for (pair in trust) {
            trustRate[pair[1]] = trustRate.getOrDefault(pair[1], 0) + 1
            trusters.add(pair[0])
        }

        for ((trustedPerson, trustedCount) in trustRate)
            if (trustedCount == N - 1 && !trusters.contains(trustedPerson))
                return trustedPerson

        return -1
    }
}


fun main() {
    val inputData1: Array<IntArray> = arrayOf(
        intArrayOf(1, 2)
    )
    val inputData2: Array<IntArray> = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3)
    )
    val inputData3: Array<IntArray> = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(3, 1)
    )
    val inputData4: Array<IntArray> = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3)
    )
    val inputData5: Array<IntArray> = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(1, 4),
        intArrayOf(2, 3),
        intArrayOf(2, 4),
        intArrayOf(4, 3)
    )

    println("${Solution().findJudge(2, inputData1)}, 2")
    println("${Solution().findJudge(3, inputData2)}, 3")
    println("${Solution().findJudge(3, inputData3)}, -1")
    println("${Solution().findJudge(3, inputData4)}, -1")
    println("${Solution().findJudge(4, inputData5)}, 3")
}
