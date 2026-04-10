package problem21_合并2个有序链表;


import java.util.Scanner;

class Test {
    public ListNode fun(ListNode l1,ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode head;
        ListNode cur;

        if(l1.val<=l2.val){
            head=l1;
            cur=l1;
            l1=l1.next;
        }else{
            head=l2;
            cur=l2;
            l2=l2.next;
        }

        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                cur=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                cur=l2;
                l2=l2.next;
            }
        }

        if(l1!=null) cur.next=l1;
        if(l2!=null) cur.next=l2;

        return head;
    }
    public static ListNode arrayToList(int[] arr) {
        if(arr==null||arr.length==0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for(int i=1;i<arr.length;i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1);
//        l1.next = new ListNode(3);
//        l1.next.next = new ListNode(5);
//        l1.next.next.next = new ListNode(5);
//        ListNode l2 = new ListNode(2);
//        l2.next = new ListNode(4);
//        l2.next.next = new ListNode(6);

        Scanner sc=new Scanner(System.in);

        int n1=sc.nextInt();
        int[] a1=new int[n1];
        for(int i=0;i<n1;i++){
            a1[i]=sc.nextInt();
        }

        int n2=sc.nextInt();
        int[] a2=new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i]=sc.nextInt();
        }

        ListNode l1=arrayToList(a1);
        ListNode l2=arrayToList(a2);


        Test test=new Test();
        ListNode res=test.fun(l1,l2);

        while(res!=null){
            System.out.print(res.val + " ");
            res=res.next;
        }
    }
}
