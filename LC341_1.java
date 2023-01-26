// 341. Flatten Nested List Iterator

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<Iterator<NestedInteger>> stack = new Stack();
    Integer next = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        // buildFlatList(nestedList);
        stack.push(nestedList.iterator());
        advance();     

    }

    public void advance(){
        if(next != null) return;

        while(stack.size() > 0){
            Iterator<NestedInteger> nestedIter = stack.peek();

            if(!nestedIter.hasNext()){
                stack.pop();
            }else{
                NestedInteger ni = nestedIter.next();
                if(ni.isInteger()){
                    next = ni.getInteger();
                    return;
                }else{
                    stack.push(ni.getList().iterator());
                }
            }
        }
    }

    // public void buildFlatList(List<NestedInteger> nestedList){
        
    //     for(NestedInteger nInt : nestedList){
    //         if(nInt.isInteger()){
    //             flatList.add(nInt.getInteger());
    //         }else{
    //             buildFlatList(nInt.getList());
    //         }
    //     }
    // }

    @Override
    public Integer next() {
        Integer res = next;
        next = null;
        advance();
        return res;
    }

    @Override
    public boolean hasNext() {
        return next != null;
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */