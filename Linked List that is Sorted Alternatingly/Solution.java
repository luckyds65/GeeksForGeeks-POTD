class Solution {
    
    public Node sort(Node head){
         //your code here, return the head of the sorted list
 
         if (head.next == null || head.next.next == null) {
             return head;
         }
         
         Node c1 = head, c2 = head.next;
         Node c11 = null, c22 = null, h1 = null, h2 = null;
         while (c1 != null) {
             Node temp = new Node(c1.data);
             if (h1 == null) {
                 h1 = temp;
                 c11 = temp;
             } else {
                 c11.next = temp;
                 c11 = c11.next;
             }
             
             if (c1.next != null)
                 c1 = c1.next.next;
             else break;
         }
         
         while (c2 != null) {
             Node temp = new Node(c2.data);
             if (h2 == null) {
                 h2 = temp;
                 c22 = temp;
             } else {
                 temp.next = h2;
                 h2 = temp;
             }
             
             if (c2.next != null)
                 c2 = c2.next.next;
             else break;
         }
         
         c1 = h1;
         c2 = h2;
         
         Node newHead = null, curr = null;
         while (c1 != null && c2 != null) {
             Node temp;
             if (c1.data <= c2.data) {
                 temp = new Node(c1.data);
                 c1 = c1.next;
             } else {
                 temp = new Node(c2.data);
                 c2 = c2.next;
             }
             if (newHead == null) {
                 newHead = temp;
                 curr = temp;
             } else {
                 curr.next = temp;
                 curr = curr.next;
             }
         }
         
         while (c1 != null) {
             Node temp = new Node(c1.data);
             curr.next = temp;
             curr = curr.next;
             c1 = c1.next;
         }
         
         while (c2 != null) {
             Node temp = new Node(c2.data);
             curr.next = temp;
             curr = curr.next;
             c2 = c2.next;
         }
         
         return newHead;
    }
 }