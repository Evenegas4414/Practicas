package Clases.AlgoritmoPila;

public class Stack {
	 int[] stck = new int[10];
	    int tos;
	    // Initialize top-of-stack
	    Stack() {
	        tos = -1;
	    }
	    // Push an item onto the stack
	    void push(int item) {
	        if(tos==9)
	            System.out.println("Stack is full.");
	        else {
	            stck[++tos] = item;
	        }
	    }
	    // Pop an item from the stack
	    int pop() {
	        if(tos < 0) {
	            System.out.println("Stack underflow.");
	            return 0;
	        } else {
	            return stck[tos--];
	        }
	    }

	    void test(double d, int b){
	        System.out.println("hello");
	    }

	    void test(int b, double d){
	        System.out.println("hello");
	    }
}
