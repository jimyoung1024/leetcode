package main

func findMagicIndex(nums []int) int {

	for i := 0; i < len(nums); i++ {
		if nums[i] == i {
			return i
		}
	}
	return -1
}

func main() {
	print(findMagicIndex([]int{1, 1, 1}))
}
