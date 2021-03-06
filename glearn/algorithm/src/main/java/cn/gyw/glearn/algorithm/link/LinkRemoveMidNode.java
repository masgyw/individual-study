package cn.gyw.glearn.algorithm.link;

/**
 * 删除单链表的中间节点和a/b处的节点
 *
 * 题目：
 * 给定链表的头结点head，实现删除链表的中间节点的函数
 *
 * 进阶：
 * 给定链表的头结点head、整数a和整数b，实现删除位于a/b 处节点的函数
 *
 */
public class LinkRemoveMidNode {

    /**
     * 给定链表的头结点head，实现删除链表的中间节点的函数
     * @param head
     * @return
     */
    public SingleNode removeMidNode(SingleNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        SingleNode pre = head;
        SingleNode cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    /**
     * 给定链表的头结点head、整数a和整数b，实现删除位于a/b 处节点的函数
     * @param head
     * @param a
     * @param b
     * @return
     */
    public SingleNode removeByRatio(SingleNode head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        SingleNode cur = head;
        while (cur != null) {
            n ++;
            cur = cur.next;
        }

        n = (int) Math.ceil(((double)(a * n)) / (double) b);
        if (n == 1) {
            head = head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

}
