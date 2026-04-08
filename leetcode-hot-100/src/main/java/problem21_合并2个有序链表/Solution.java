package problem21_合并2个有序链表;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int x) { val = x; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tmp=new ListNode(0);
        ListNode p=tmp;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                p.next=list1;
                list1=list1.next;
            }else{
                p.next=list2;
                list2=list2.next;
            }
            p=p.next;
        }
        if(list1!=null){
            p.next=list1;
            list1=list1.next;
        }
        if(list2!=null){
            p.next=list2;
            list2=list2.next;
        }
        return tmp.next;
    }
}
// https://www.doubao.com/thread/wd4fd3389ceadffc2
