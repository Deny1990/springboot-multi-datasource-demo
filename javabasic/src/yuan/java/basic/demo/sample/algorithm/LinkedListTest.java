package yuan.java.basic.demo.sample.algorithm;

/**
 * Created by yuanxin on 17/12/18.
 */
public class LinkedListTest {
    /*
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // write your code here
        if (head == null) {
            return null;
        }
        int i = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            i++;
        }
        ListNode[] listnodes = new ListNode[i];
        int j = 0;

        p = head;
        while (p != null) {
            if (p.val != val) {
                listnodes[j] = new ListNode(p.val);
                j++;
            }
            p = p.next;

        }
        for (int k = 1; k < j; k++) {
            listnodes[k - 1].next = listnodes[k];
        }
        ListNode h = listnodes[0];
        while(h != null){
            System.out.println(h.val);
            h=h.next;
        }
        return listnodes[0];

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

//        ListNode node1 = new ListNode(5);
        LinkedListTest test = new LinkedListTest();
        test.removeElements(node1, 6);
    }
}
