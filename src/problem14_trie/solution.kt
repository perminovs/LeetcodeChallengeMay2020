package problem14_trie


class Node(var value: Char?, val deep: Int) {
    var childs: MutableMap<Char, Node> = mutableMapOf()
    var end = false

    override fun toString() = "<value>=\"$value\" <end>=$end"
}


class Trie {
    var root: Node = Node(value = null, deep = 0)

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var node = getDeepestMatchNode(word)

        for (i in node.deep until word.length) {
            val newNode = Node(value = word[i], deep = i + 1)
            node.childs[word[i]] = newNode
            node = newNode
        }

        node.end = true
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        val node = getDeepestMatchNode(word)
        return node.deep == word.length && node.end
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        val node = getDeepestMatchNode(prefix)
        return node.deep == prefix.length
    }

    private fun getDeepestMatchNode(prefix: String): Node {
        var deep = 0
        var node = root
        while (node.childs.isNotEmpty() && deep < prefix.length) {
            val childNode = node.childs[prefix[deep]] ?: break
            node = childNode
            deep += 1
        }
        return node
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */

fun main() {
    val trie = Trie()

    trie.insert("apple")
    println(trie.search("apple")) // returns true
    println(trie.search("app")) // returns false
    println(trie.startsWith("app")) // returns true
    trie.insert("app")
    println(trie.search("app")) // returns true
}
