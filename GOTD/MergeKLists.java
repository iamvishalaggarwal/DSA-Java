package GOTD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class MergeKLists {
    Node mergeKLists(List<Node> arr) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr.size() == 0) {
            return null;
        }
        for (Node node : arr) {
            Node temp = node;
            while (temp != null) {
                list.add(temp.data);
                temp = temp.next;
            }
        }

        Collections.sort(list);

        Node result = new Node(list.get(0));
        Node temp = result;
        for (int i = 1; i < list.size(); i++) {
            temp.next = new Node(list.get(i));
            temp = temp.next;
        }
        return result;
    }
}
