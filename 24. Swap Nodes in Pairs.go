/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapPairs(head *ListNode) *ListNode {

	curr, next := head, head
	var root *ListNode = head
	var nextPair *ListNode
	var prevCurr *ListNode
	for curr != nil && curr.Next != nil {
		next = curr.Next
		nextPair = next.Next
		next.Next = curr
		curr.Next = nextPair
		if root == head {
			root = next
		}

		if prevCurr != nil {
			prevCurr.Next = next
		}
		prevCurr = curr
		curr = nextPair
	}

	return root
}