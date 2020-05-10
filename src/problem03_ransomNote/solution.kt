package problem03_ransomNote

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val note = buildCounter(ransomNote)
        val available = buildCounter(magazine)

        for ((k, v) in note)
            if (available.getOrDefault(k, -1) < v)
                return false

        return true
    }
}


fun buildCounter(symbols: String): MutableMap<Char, Int> {
    val counter = mutableMapOf<Char, Int>()
    for (s in symbols) {
        counter[s] = counter.getOrDefault(s, 0) + 1
    }
    return counter
}


fun main() {
    println(Solution().canConstruct("a", "b"))
    println(Solution().canConstruct("aa", "ab"))
    println(Solution().canConstruct("ab", "aab"))
}
