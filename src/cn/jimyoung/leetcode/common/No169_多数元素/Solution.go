package main

import (
	"fmt"
	"sort"
)

/*
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于⌊ n/2 ⌋的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。

链接：https://leetcode-cn.com/problems/majority-element
*/
func main() {
	arr := []int{2, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1}
	fmt.Println(majorityElement3(arr))
}

func majorityElement(nums []int) int {
	m := make(map[int]int)
	for _, num := range nums {
		if _, ok := m[num]; ok {
			m[num]++
		} else {
			m[num] = 1
		}
	}
	maxNum := nums[0]
	maxCount := 0
	for num, count := range m {
		if count > maxCount {
			maxCount = count
			maxNum = num
		}
	}
	return maxNum
}

func majorityElement2(nums []int) int {
	sort.Ints(nums)
	return nums[len(nums)/2]
}

func majorityElement3(nums []int) int {
	candidate := nums[0]
	count := 0
	for _, num := range nums {
		if count == 0 {
			candidate = num
		}
		if num == candidate {
			count++
		} else {
			count--
		}
	}
	return candidate
}
