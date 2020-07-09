package main

import "fmt"

func divingBoard(shorter int, longer int, k int) []int {
	if k == 0 {
		return []int{}
	}
	if shorter == longer {
		return []int{k * shorter}
	}
	result := make([]int, k+1)
	result[0] = shorter * k
	for i := 1; i <= k; i++ {
		result[i] = result[i-1] - shorter + longer
	}
	return result
}

func main() {
	fmt.Println(divingBoard(1, 2, 3))
}
