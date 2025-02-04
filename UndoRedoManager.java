/**
 * Implement an application that supports undo/redo functionality. Use a linked list to maintain a sequence of states.
 * Each state change is stored as a node in the list, allowing for easy navigation.
 */

public class UndoRedoManager<T> {
    // Inner Node class
    private class Node {
        T state;
        Node prev;
        Node next;

        Node(T state) {
            this.state = state;
        }
    }

    private Node currentState;

    public T undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("No more states to undo.");
            return null;
        }
        currentState = currentState.prev;
        return currentState.state;
    }

    public void addState(T newState) {
        Node newNode = new Node(newState);
        if (currentState != null) {
            currentState.next = null;
            newNode.prev = currentState;
        }
        currentState = newNode;
    }

    public T redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("No more states to redo.");
            return null;
        }
        currentState = currentState.next;
        return currentState.state;
    }

    public T getCurrentState() {
        return currentState != null ? currentState.state : null;
    }

    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        manager.addState("State 1");
        manager.addState("State 2");
        manager.addState("State 3");

        System.out.println("Current State: " + manager.getCurrentState());
        System.out.println("Undo: " + manager.undo());
        System.out.println("Redo: " + manager.redo());
        System.out.println("Undo: " + manager.undo());
        manager.addState("State 4");
        System.out.println("Current State: " + manager.getCurrentState());
    }
}
