package com.leetcode;

public class Leetcode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2  = new StringBuilder();

        collectNumber(l1, sb1);
        collectNumber(l2, sb2);

        int sum =  Integer.parseInt(sb1.reverse().toString()) + Integer.parseInt(sb2.reverse().toString());

        ListNode head = new ListNode();

        createNodeList(String.valueOf(sum), 0, head);

        return head;

    }

    private ListNode createNodeList(String s, int i, ListNode node) {
        if(i> s.length()) return null;

        node.val = s.charAt(i);

        node.next = new ListNode();

        return createNodeList(s, i+1, node.next);

    }

    private void collectNumber(ListNode node, StringBuilder sb) {

        if(node==null) return;

        sb.append(node.val);

        collectNumber(node.next, sb);
    }

    public static class ListNode {
    int val;
      ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
