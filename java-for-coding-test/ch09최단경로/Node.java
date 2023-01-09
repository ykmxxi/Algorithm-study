package ch09최단경로;

public class Node implements Comparable<Node> {
    private final int index;
    private final int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    /**
     * 거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
     * @param other
     * @return
     */
    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}