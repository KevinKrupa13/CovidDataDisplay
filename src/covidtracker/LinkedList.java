package covidtracker;

import list.ListInterface;

public class LinkedList<T> implements ListInterface<T> {
    
    private int size;
    private Node<T> head;
    
    private static class Node<T> {
        
        private T data;
        private Node<T> next;
        
        public Node(T data) {
            this(data, null);
        }
        
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
        
        
        
    }
    
    
}
