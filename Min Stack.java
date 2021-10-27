class MinStack {
    Stack<Integer> mainSrack;
    Stack<Integer> minstack;
    public MinStack() {
        mainSrack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {
        mainSrack.push(val);
        if(!minstack.isEmpty()){
            if(mainSrack.peek() <= minstack.peek())
                minstack.push(val);
        }else{
            minstack.push(val);
        }
    }
    
    public void pop() {
        int v = mainSrack.pop();
        if(minstack.peek()== v){
            minstack.pop();
        }
    }
    
    public int top() {
        return mainSrack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
