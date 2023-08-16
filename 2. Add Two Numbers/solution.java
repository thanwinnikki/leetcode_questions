class solution {
    
  /* Definition for singly-linked list. */
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {};
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  public String printListNode(ListNode l1) {
    ListNode traverser = l1;
    String printString = "";
    while (traverser != null) {
        printString = printString + traverser.val;
        traverser = traverser.next; 
    }
    return printString;
  }

/* The idea is to traverse through the two lists while maintaining a carry variable.
 We stop doing the while loop when both lists come to an end. Cover the cases for when the lists are unequal in length.
 Cover the edge case for when the while loop ends, but there is a carry left over - when the last 2 digits in the linked list is 9 and 9.*/
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode resultFirst = new ListNode(0);
    ListNode resultTraverser = resultFirst;
    ListNode l1Traverser = l1;
    ListNode l2Traverser = l2;

    while (l1Traverser != null || l2Traverser != null) {
        int l1CurrVal = (l1Traverser == null) ? 0 : l1Traverser.val;
        int l2CurrVal = (l2Traverser == null) ? 0 : l2Traverser.val;

        int currSum = carry + l1CurrVal + l2CurrVal;
        carry = currSum / 10;
        int resultCurrVal = currSum % 10;
        resultTraverser.next = new ListNode(resultCurrVal);

        if (l1Traverser != null ) {
            l1Traverser = l1Traverser.next;
        }

        if (l2Traverser != null) {
            l2Traverser = l2Traverser.next;
        }
        resultTraverser = resultTraverser.next;
    }

    if ( carry > 0) {
        resultTraverser.next = new ListNode(carry);
    }

    return resultFirst.next;
  }

  
  public static void main(String[] args) {
        solution code = new solution(); 
        ListNode l1 = code.new ListNode(3); 
        ListNode l2 = code.new ListNode(4, l1);
        ListNode l3 = code.new ListNode(2, l2);
        ListNode l4 = code.new ListNode(4);
        ListNode l5 = code.new ListNode(6, l4);
        ListNode l6 = code.new ListNode(5, l5);
        ListNode l7 = code.addTwoNumbers(l3, l6);
        System.out.println("The Solution is: " + code.printListNode(l7));
  }
}
