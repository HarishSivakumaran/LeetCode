// 1993. Operations on Tree
class LockingTree {

    Integer[] locked;
    int[] parent;
    HashMap<Integer, List<Integer>> map = new HashMap();
    boolean check = false;

    public LockingTree(int[] parent) {
        this.parent = parent;
        for (int i = 0; i < parent.length; i++) {
            this.map.computeIfAbsent(parent[i], v -> new ArrayList()).add(i);
        }
        locked = new Integer[parent.length];
    }

    public boolean lock(int num, int user) {
        if (locked[num] != null)
            return false;
        locked[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (locked[num] != null && locked[num] == user) {
            locked[num] = null;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        int curr = num;
        while (true) {
            if (curr == -1)
                break;
            if (locked[curr] != null)
                return false;
            curr = parent[curr];
        }
        checkDesc(num);

        if (check) {
            locked[num] = user;
            check = false;
            return true;
        }
        return false;
    }

    public void checkDesc(int node) {
        if (locked[node] != null) {
            check = true;
            locked[node] = null;
        }
        ;

        if (!map.containsKey(node))
            return;

        for (int i : map.get(node)) {
            checkDesc(i);
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */