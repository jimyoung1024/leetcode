package main

import "fmt"

func getRow(rowIndex int) []int {
	oldRow := []int{1}
	var newRow []int
	rowLen := 1
	for ; rowIndex > -1; rowIndex-- {
		newRow = make([]int, rowLen)
		newRow[0] = 1
		newRow[len(newRow)-1] = 1
		for i := 1; i < len(oldRow); i++ {
			newRow[i] = oldRow[i-1] + oldRow[i]
		}
		oldRow = newRow
		rowLen++
	}
	return newRow
}

func main() {
	fmt.Println(getRow(3))
}
