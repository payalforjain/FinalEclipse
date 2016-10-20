class Solution:
    # @param A, a list of integers
    # @return an integer

    def firstMissingPositive(self, A):
        size = len(A)
        for cursor in range(size):
            target = A[cursor]
            while target <= size and target > 0 and target != A[target - 1]:
                A[target - 1], target = target, A[target - 1]

        for cursor in range(size):
            if cursor + 1 != A[cursor]:
                return cursor + 1
        # edge case, last one not found
        return size + 1


def firstMissing2(A):
    size = len(A)
    for i in range(size):
        while A[i] <= size and A[i] > 0 and A[i] != A[A[i] - 1]:
            A[A[i] - 1], A[i] = A[i], A[A[i] - 1]

    for cursor in range(size):
        if cursor + 1 != A[cursor]:
            return cursor + 1
    return size + 1

if __name__ == '__main__':
    s = Solution()
    data = [-1, 4, 2, 1, 0, -1, -1, 3]
    print(s.firstMissingPositive(data))
    data = [-1, 4, 2, 1, 0, -1, -1, 3]
    print(firstMissing2(data))
