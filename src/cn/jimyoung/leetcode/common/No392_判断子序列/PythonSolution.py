class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        t_index = 0
        t_len = len(t)
        for s_char in s:
            for t_char_index in range(t_index, t_len):
                if s_char == t[t_char_index]:
                    t_index = t_char_index + 1
                    break
            else:
                return False
        return True


if __name__ == '__main__':
    print(Solution().isSubsequence('abc', 'ahbgdc'))
