class LinkedList {
    Node head; // Head of the linked list

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to delete a node at the beginning
    public void deleteAtBeginning() {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        head = head.next; // Move the head pointer to the next node
    }

    // Method to delete a node at the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        if (head.next == null) { // If only one node is present
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) { // Traverse until the second last node
            temp = temp.next;
        }
        temp.next = null; // Remove the last node
    }
}