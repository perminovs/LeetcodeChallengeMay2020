package problem16_oddEvenLinkedList

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        val nodes = mutableListOf<Int>()
        var current: ListNode? = this
        while (current != null) {
            nodes.add(current.`val`)
            current = current.next
        }

        return nodes.toString()
    }
}


fun fromList(data: List<Int>): ListNode {
    val head = ListNode(data[0])
    var current = head
    for (i in 1 until data.size) {
        val newNode = ListNode(data[i])
        current.next = newNode
        current = newNode
    }

    return head
}


class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var oddNode = head
        var evenNode = head.next
        if (evenNode?.next == null) return head

        val firstEvenNode = evenNode
        var isNodeEven = false

        var currentNode = evenNode.next
        while (currentNode != null) {
            if (isNodeEven) {
                evenNode?.next = currentNode
                evenNode = currentNode
            } else {
                oddNode?.next = currentNode
                oddNode = currentNode
            }

            currentNode = currentNode.next
            isNodeEven = !isNodeEven
        }
        evenNode?.next = null
        oddNode?.next = firstEvenNode

        return head
    }
}


fun main() {
    for (sample in listOf(
        fromList(listOf(1, 2, 3, 4, 5, 6)),
        fromList(listOf(1, 2, 3, 4, 5, 6, 7)),
        fromList(listOf(1, 2, 3, 4, 5)),
        fromList(listOf(2, 1, 3, 5, 6, 4, 7))
    )) {
        println(sample)
        println(Solution().oddEvenList(sample))
        println()
    }
}
