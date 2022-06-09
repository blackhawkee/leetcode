#
# @lc app=leetcode id=2196 lang=python3
#
# [2196] Create Binary Tree From Descriptions
#

# @lc code=start
# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        dict = {}
        setVar = set()

        for parent, child, childPointer in descriptions:

            setVar.add(child)
            parentNode = None
            parentNode = dict.get(
                parent) if parent in dict else TreeNode(parent)

            if childPointer == 1:
                childNode = dict.get(
                    child) if child in dict else TreeNode(child)
                parentNode.left = childNode
                dict[child] = childNode
            else:
                childNode = dict.get(
                    child) if child in dict else TreeNode(child)
                parentNode.right = childNode
                dict[child] = childNode

            dict[parent] = parentNode

        root = None
        for list in descriptions:
            if not list[0] in setVar:
                root = list[0]
                break

        return None if root is None else dict.get(root)

# @lc code=end
