class Solution {
    public static Node reverseKGroup(Node head, int k) { // ← add 'static'
        if (head == null)
            return null;

        Node curr = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Reverse first k nodes
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Recurse for the rest
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        int k = 2;

        System.out.print("Original List: ");
        printList(head);

        head = reverseKGroup(head, k); // 

        System.out.print("Reversed in groups of " + k + ": ");
        printList(head);
    }
}
