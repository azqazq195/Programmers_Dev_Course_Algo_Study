import java.util.ArrayList;
import java.util.List;

class Solution {

    // ���� ����Ʈ�� ����Ͽ� Ʈ���� ��Ÿ���ϴ�.
    private List<List<Integer>> adjList = new ArrayList<>();

    // DFS�� ����Ͽ� ����Ʈ���� ��� ���� ���� �Լ��Դϴ�.
    private int dfsCountNodes(int current, int parent) {
        // ���� ��带 ����.
        int count = 1; 
        
        // ���� ��忡 ����� �̿� ������ Ȯ���մϴ�.
        for (int neighbor : adjList.get(current)) {
            // �̿��� �θ� ��尡 �ƴ� ��츸 ��������� DFS�� �����մϴ�.
            if (neighbor != parent) {
                count += dfsCountNodes(neighbor, current);
            }
        }
        
        return count;
    }
    
    public int solution(int n, int[][] wires) {
        // ���� ����Ʈ �ʱ�ȭ
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // ���� ����Ʈ�� ����Ͽ� �־��� ���� ������ Ʈ���� �����մϴ�.
        for (int[] wire : wires) {
            int v1 = wire[0], v2 = wire[1];
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }
        
        // �ּ� ���̸� �����ϴ� ������ �ִ밪���� �ʱ�ȭ�մϴ�.
        int minDifference = Integer.MAX_VALUE;
        
        // �� ������ �ϳ��� �����غ��� �� �׷��� ��� �� ���̸� ����մϴ�.
        for (int[] wire : wires) {
            int v1 = wire[0], v2 = wire[1];
            
            // v1�� ��Ʈ�� �ϴ� ����Ʈ���� ��� ���� ����
            int nodesInFirstPart = dfsCountNodes(v1, v2);
            // v2�� ��Ʈ�� �ϴ� ����Ʈ���� ��� ���� ����
            int nodesInSecondPart = dfsCountNodes(v2, v1);
            
            // �� ����Ʈ���� ��� ���� ���̸� ����մϴ�.
            int difference = Math.abs(nodesInFirstPart - nodesInSecondPart);
            // ���ݱ��� ã�� �ּ� ���̿� ���Ͽ� �� ���� ���� �����մϴ�.
            minDifference = Math.min(minDifference, difference);
        }
        
        return minDifference;
    }

 }