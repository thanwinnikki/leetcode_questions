class ListNode:
    def __init__(self, val = 0, next = None):
        self.val = val
        self.next = next
    
    def to_list(self):
        to_print = []
        node = self
        while node is not None:
            to_print.append(node.val)
            node = node.next
        return to_print
    
def solution(node1: ListNode, node2: ListNode) -> ListNode:
    carry = 0
    pointer1 = node1
    pointer2 = node2
    solution_head = ListNode()
    current_node = solution_head

    while pointer1 is not None or pointer2 is not None:
        sum = 0
        if pointer2 is None:
            sum = carry + pointer1.val
            pointer1 = pointer1.next
        elif pointer1 is None:
            sum = carry + pointer2.val
            pointer2 = pointer2.next
        else:
            sum = carry + pointer1.val + pointer2.val
            pointer1 = pointer1.next
            pointer2 = pointer2.next
        
        if sum > 9:
            carry = 1
            sum = sum % 10
        else:
            carry = 0
        current_node.next = ListNode(sum)
        current_node = current_node.next
    if carry == 1:
        current_node.next = ListNode(1)
    return solution_head.next

NodeA = ListNode(5, ListNode(4, ListNode(3, ListNode(2, ListNode(1)))))
NodeB = ListNode(7, ListNode(6, ListNode(5)))

print(solution(NodeA, NodeB).to_list())

