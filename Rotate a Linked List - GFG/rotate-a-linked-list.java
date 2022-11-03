//{ Driver Code Starts
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
} 

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;
            
            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution ob = new Solution();
            head = ob.rotate(head,k);
            printList(head);
        }
    }
    
    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends
class Solution{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        Node temp = head;
        int size = 1;
        while(temp.next != null) {
            temp = temp.next;
            size++;
        }
        if(k == size) return head;
        temp.next = head;
        temp = head;
        k %= size;
        for(int i = 1; i < k; i++) temp = temp.next;
        head = temp.next;
        temp.next = null;
        return head;
    }
}