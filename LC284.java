// 284. Peeking Iterator

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Integer top = null;
    Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator = iterator;
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(this.top == null){
            this.top = this.iterator.next();
        }

        return this.top;
        
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(this.top != null){
            int n = this.top;
            this.top = null;
            return n;
        }	 

        return this.iterator.next();   
	}
	
	@Override
	public boolean hasNext() {
        return this.top != null || this.iterator.hasNext();	    
	}
}
