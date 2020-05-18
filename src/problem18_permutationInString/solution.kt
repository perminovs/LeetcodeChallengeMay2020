package problem18_permutationInString

class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val desiredSymbols = buildCounter(s1)
        var sliceIndexes = s1.indices
        val windowSymbols = buildCounter(s2.slice(sliceIndexes))

        while (true) {
            if (windowSymbols == desiredSymbols) return true

            val leftSymbol = s2[sliceIndexes.first]
            windowSymbols[leftSymbol] = windowSymbols.getValue(leftSymbol) - 1
            if (windowSymbols[leftSymbol] == 0) windowSymbols.remove(leftSymbol)

            sliceIndexes = sliceIndexes.first + 1..sliceIndexes.last + 1
            if (sliceIndexes.last > s2.length - 1) break

            val rightSymbol = s2[sliceIndexes.last]
            windowSymbols[rightSymbol] = windowSymbols.getOrDefault(rightSymbol, 0) + 1
        }

        return false
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
    for (p in listOf(
        Pair("ab", "eidbaooo"), // true
        Pair("ab", "eidboaoo"), // false
        Pair("ab", "aboplkj"), // true
        Pair("aba", "oplkjbaa"),  // true
        Pair("aba", "baa"),  // true
        Pair("aba", "a")  // false
    )) {
        println(Solution().checkInclusion(p.first, p.second))
    }
}
