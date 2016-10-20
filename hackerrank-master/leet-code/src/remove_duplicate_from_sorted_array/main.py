class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        i = 0
        ii = 1
        N = len(A)
        count = 0
        while ii < N:
            if A[i] == A[ii]:
                ii += 1
                count += 1
            else:
                i += 1
                A[i] = A[ii]
                ii += 1
        return len(A) - count

if __name__ == '__main__':
    s = Solution()
    print s.removeDuplicates([1,1,2,2, 2, 3, 4, 100])

