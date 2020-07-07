package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func hasPathSum(root *TreeNode, sum int) bool {
	if root == nil {
		return false
	}

	var temp = sum - root.Val
	if root.Left == nil && root.Right == nil {
		return temp == 0
	}

	return hasPathSum(root.Left, temp) || hasPathSum(root.Right, temp)
}
