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
     // Method to delete a node at a specific position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        if (position == 0) { // If deleting the first node
            deleteAtBeginning();
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1; i++) { // Traverse to the node before the target node
            if (temp.next == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        temp.next = temp.next.next; // Remove the target node
    }

    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding some nodes to the list
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);

        System.out.println("Original list:");
        list.display();

        System.out.println("\nDeleting at the beginning:");
        list.deleteAtBeginning();
        list.display();

        System.out.println("\nDeleting at the end:");
        list.deleteAtEnd();
        list.display();

        System.out.println("\nDeleting at position 1:");
        list.deleteAtPosition(1);
        list.display();
    }
}
