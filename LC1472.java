// 1472. Design Browser History

class BrowserHistory {

    Node curr;

    class Node {
        Node next = null, prev = null;
        String URL = "";

        public Node(String url) {
            this.URL = url;
        }
    }

    public BrowserHistory(String homepage) {
        visit(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        if (curr == null) {
            curr = newNode;
            return;
        } else {
            if (curr.next != null)
                curr.next.prev = null;
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }
    }

    public String back(int steps) {
        while (curr.prev != null && steps > 0) {
            steps--;
            curr = curr.prev;
        }

        return curr.URL;
    }

    public String forward(int steps) {
        while (curr.next != null && steps > 0) {
            steps--;
            curr = curr.next;
        }

        return curr.URL;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */