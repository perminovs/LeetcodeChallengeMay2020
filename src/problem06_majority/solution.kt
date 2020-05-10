package problem06_majority

class Solution {
    fun majorityElement(nums: IntArray): Int {
        val counter = buildCounter(nums)

        for ((k, v) in counter) {
            if (v > nums.size / 2) {
                return k
            }
        }

        return 0
    }
}


fun buildCounter(nums: IntArray): Map<Int, Int> {
    val counter = mutableMapOf<Int, Int>()
    for (i in nums) {
        counter[i] = counter.getOrDefault(i, 0) + 1
    }
    return counter
}


fun main() {
    println(Solution().majorityElement(intArrayOf(3, 2, 3)))
    println(Solution().majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
}
