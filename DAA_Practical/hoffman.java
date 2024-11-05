import java.util.*;

public class hoffman {
    public static class Node implements Comparable<Node> {
        char ch;
        int freq;
        Node left;
        Node right;

        public Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            this.left = this.right = null;
        }

        @Override
        public int compareTo(Node n2) {
            return Integer.compare(this.freq, n2.freq);
        }

    }

    public static HashMap<Character, String> generate(HashMap<Character, Integer> hs) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> ele : hs.entrySet()) {
            pq.add(new Node(ele.getKey(), ele.getValue()));
        }
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node internal = new Node('\0', left.freq + right.freq);
            internal.left = left;
            internal.right = right;
            pq.add(internal);
        }
        Node root = pq.poll();
        HashMap<Character, String> code_T = new HashMap<>();
        generate2(root, code_T, "");
        return code_T;

    }

    public static void generate2(Node root, HashMap<Character, String> code_T, String code) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            code_T.put(root.ch, code);
        }
        generate2(root.left, code_T, code + "0");
        generate2(root.right, code_T, code + "1");

    }

    public static void main(String[] args) {
        String str = "hhhhhdddddddddiiiiiiiidfdk";
        HashMap<Character, Integer> hs = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            hs.put(str.charAt(i), hs.getOrDefault(str.charAt(i), 0) + 1);
        }
        HashMap<Character, String> code = generate(hs);
        String ovreall = "";
        for (Map.Entry<Character, String> ele : code.entrySet()) {
            System.out.print("Character is " + ele.getKey() + "  Frequency is :"
                    + hs.get(ele.getKey()) + "  Huffmann Code is : " + ele.getValue());
            System.out.println();
        }
        for (int i = 0; i < str.length(); i++) {
            ovreall += code.get(str.charAt(i));
        }
        System.out.println(ovreall);

    }
}