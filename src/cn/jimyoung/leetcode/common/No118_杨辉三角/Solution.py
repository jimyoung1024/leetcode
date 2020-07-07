class Solution:
    def generate(self, num_rows: int) -> List[List[int]]:
        '''

        :param num_rows: int
        :return: List[List[int]]
        '''
        if num_rows == 0:
            return []
        result = [[1]]
        num_rows -= 1
        while num_rows > 0:
            result.append([1] + [result[-1][i] + result[-1][i + 1] for i in range(len(result[-1]) - 1)] + [1])
            num_rows -= 1
        return result


print(Solution.generate(Solution(), 5))
