package problem07_binaryCousins

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Node(val treeNode: TreeNode, val deep: Int) {

}

class Solution {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        if (root == null) return false

        val xParent = foundParentNode(root, x, 0)
        val yParent = foundParentNode(root, y, 0)

        if (xParent != null && yParent != null)
            return xParent.treeNode != yParent.treeNode && xParent.deep == yParent.deep

        return false
    }

    private fun foundParentNode(root: TreeNode, nodeVal: Int, deep: Int): Node? {
        if (root.left?.`val` == nodeVal || root.right?.`val` == nodeVal) {
            return Node(root, deep)
        }

        if (root.left != null){
            val byLeft = foundParentNode(root.left!!, nodeVal, deep + 1)
            if (byLeft != null) {return byLeft}
        }

        if (root.right != null){
            val byRight = foundParentNode(root.right!!, nodeVal, deep + 1)
            if (byRight != null) {return byRight}
        }

        return null
    }
}
