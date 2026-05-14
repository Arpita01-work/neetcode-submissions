/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode temp = head;
        while(temp != null){
            if(map.containsKey(temp)){
                return true;
            }   
            else{
                map.put(temp, 1);
                temp = temp.next;
            }
        }
        return false;
    }
}
