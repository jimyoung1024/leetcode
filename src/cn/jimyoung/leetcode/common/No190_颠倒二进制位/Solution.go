package main

import "fmt"

func reverseBits(num uint32) uint32 {
	var res uint32 = 0
	for i := 0; i < 32; i++ {
		if num&1 == 1 {
			res += 1
		}
		num >>= 1
		if i < 31 {
			res <<= 1
		}
	}
	return res
}

func main() {
	fmt.Println(reverseBits(43261596))
}
