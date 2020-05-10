package problem09_perfectSquare

class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        if (num == 1) return true

        var left = 1.toBigInteger()
        var right = num.toBigInteger()
        val bigNum = num.toBigInteger()

        while (right - left > 1.toBigInteger()) {
            val current = (right + left) / 2.toBigInteger()
            val sq = current * current

            if (sq == bigNum) return true
            if (sq < bigNum) left = current
            if (sq > bigNum) right = current
        }

        return false
    }
}


fun main() {
    println(Solution().isPerfectSquare(1))
    println(Solution().isPerfectSquare(16))
    println(Solution().isPerfectSquare(14))
    println(Solution().isPerfectSquare(808201))
}
