package No160_相交链表

type ListNode struct {
	Val  int
	Next *ListNode
}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	if headB == nil || headA == nil {
		return nil
	}
	headA_copy := headA
	headB_copy := headB
	for headA_copy != headB_copy {
		if headA_copy == nil {
			headA_copy = headB
		} else {
			headA_copy = headA_copy.Next
		}
		if headB_copy == nil {
			headB_copy = headA
		} else {
			headB_copy = headB_copy.Next
		}
	}
	return headA_copy
}
