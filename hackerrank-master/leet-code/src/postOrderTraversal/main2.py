class TreeNode:

    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # @param root, a tree node
    # @return a list of integers

    def postorderTraversal(self, root):
        result = []

        def visit(e):
            result.append(e.val)

        if root == None:
            return result

        stack = [root]
        prev = None

        while stack:
            curr = stack[-1]
            # traverse down the tree
            if prev == None or prev.left == curr or prev.right == curr:
                if curr.left != None:
                    stack.append(curr.left)
                elif curr.right != None:
                    stack.append(curr.right)
                else:
                    visit(curr)
                    stack.pop()
            # came up from left tree
            elif curr.left == prev:
                if curr.right != None:
                    stack.append(curr.right)
                else:
                    visit(curr)
                    stack.pop()
            # came up from right tree
            else:
                visit(curr)
                stack.pop()
            prev = curr

        return result


def makeTree(A, i):
    if i >= len(A):
        return None
    node = TreeNode(A[i])
    # print node.val,
    node.left = makeTree(A, i * 2 + 1)
    node.right = makeTree(A, i * 2 + 2)
    return node

if __name__ == '__main__':
    t = [1, 2, 5, 3, 4, 0, 6]
    root = makeTree(t, 0)
    s = Solution()
    for e in s.postorderTraversal(root):
        print e,
