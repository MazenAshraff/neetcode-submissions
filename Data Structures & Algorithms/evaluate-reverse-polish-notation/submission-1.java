class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++){
            switch(tokens[i]){
                case "+" : stack.push(stack.pop() + stack.pop());break;
                case "-" :stack.push(-(stack.pop() - stack.pop())); break;
                case "/" : {
                    int op2 = stack.pop();
                    int op1 = stack.pop();
                    stack.push(op1/op2); break;}
                case "*": stack.push(stack.pop() * stack.pop()); break;
                default:{
                   stack.push(Integer.parseInt(tokens[i]));
                }
            }
        }
        return (int) stack.pop();
    }
}
