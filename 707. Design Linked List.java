class MyLinkedList {
    Node head = new Node(-1), tail = new Node(-1);
    public MyLinkedList() {
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int index) {
        Node curr = head.next;
        int i = 0;
        while(i < index && curr.val != -1) {
            i++;
            curr = curr.next;
        }

        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
    }
    
    public void addAtIndex(int index, int val) {
        int i = 0;
        Node curr = head;
        while(i < index) {
            i++;
            curr = curr.next;
            if(curr.val == -1) break;
        }
        if(curr != head && curr.val == -1) return; // can't add out of scope

        Node next = curr.next;
        Node node = new Node(val);
        node.next = next;
        node.prev = curr;
        next.prev = node;
        curr.next = node;
    }
    
    public void deleteAtIndex(int index) {
        int i = 0;
        Node curr = head.next;
        while(i < index) {
            i++;
            curr = curr.next;
            if(curr.val == -1) break;
        }
        if(curr.val == -1) return; // can't delete out of scope
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.next = null;
        curr.prev = null;

    }
}

class Node{
    int val;
    Node next;
    Node prev;
    Node(int v) {
        this.val = v;
    }
}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */