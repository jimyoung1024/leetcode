package No160_相交链表

import "go/types"

type ListNode struct {
	Val  int
	Next *ListNode
}

type EmptyStruct struct {
}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	if headB == nil || headA == nil {
		return nil
	}
	myMap := map[*ListNode]EmptyStruct{}
	for headA != nil {
		myMap[headA] = EmptyStruct{}
		headA = headA.Next
	}
	for headB != nil {
		_, ok := myMap[headB]
		if ok {
			return headB
		} else {
			headB = headB.Next
		}
	}
	return nil
}
