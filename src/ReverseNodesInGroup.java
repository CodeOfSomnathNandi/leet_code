//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class ReverseNodeInGroup {

    public ListNode[] reverse(int[] array) {
        ListNode node = new ListNode();
        ListNode returnNode = node;

        for (int i = array.length - 1; i >= 0; i--) {
            if (i == 0) {
                node.val = array[i];
            } else {
                node.val = array[i];
                node.next = new ListNode();
                node = node.next;
            }
        }
        node.next = null;
        return new ListNode[]{returnNode, node};
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int[] array = new int[k];
        int count = 0;
        ListNode returnHead = head, tail = head;
        boolean setReturnHead = true;
        if (k <= 1) {
            return head;
        }

        while (true) {
            array[count] = head.val;
            head = head.next;
            count++;

            if (count == k) {
                var nodes = reverse(array);
                if (setReturnHead) {
                    returnHead = nodes[0];
                    tail = nodes[1];
                } else {
                    tail.next = nodes[0];
                    tail = nodes[1];
                }
                count = 0;
                setReturnHead = false;

            }
            if (head == null) {
                if (0 < count && count <= k) {
                    for (int i = 0; i < count; i++) {
                        tail.next = new ListNode(array[i]);
                        tail = tail.next;
                    }

                }
                break;
            }

        }





        return returnHead;
    }

    public ListNode getHead(int[] array) {
        ListNode node = new ListNode();
        ListNode returnNode = node;

        for (int i = 0; i < array.length; i++) {
            if (i == array.length-1) {
                node.val = array[i];
            } else {
                node.val = array[i];
                node.next = new ListNode();
                node = node.next;
            }
        }
        return  returnNode;
    }

    void print(ListNode reversed) {
        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,2};
        var re = new ReverseNodeInGroup();
        var head = re.getHead(array);
        var reversed = re.reverseKGroup(head, 2);
        re.print(reversed);
        System.out.println("-----------");
        re.print(head);
    }
}