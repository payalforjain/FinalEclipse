class Solution:
    # @param num, a list of integer
    # @return an integer

    def longestConsecutive(self, num):
        # use hashtable to get random element at O(1)
        numberSet = set(num)
        currMax = 0

        while len(numberSet) > 0:
            n = numberSet.pop()
            left = n
            right = n
            while right + 1 in numberSet:
                numberSet.remove(right + 1)
                right += 1
            while left - 1 in numberSet:
                numberSet.remove(left - 1)
                left -= 1
            currLen = right - left + 1
            currMax = max(currLen, currMax)
        return currMax

if __name__ == '__main__':
    s = Solution()
    data = [100, 4, 200, 1, 3, 2]
    print(s.longestConsecutive(data))
