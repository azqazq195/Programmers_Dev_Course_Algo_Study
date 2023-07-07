import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        // 0. ������ �����Ͽ�, ���� ���� ������ ���� (�ڽź��� ���� ���Կ� ���Ͽ� answer�� �� ����)
        Arrays.sort(weights);
        
        // 1. Map<����, weight �迭���� �ش� ����(key)�� ������ ����� ��>
        Map<Double, Integer> map = new HashMap<>();
        
        
        for(int weight : weights) {
            double cur_weight = weight * 1.0;
            
            // 2. ���� ������ �������� ���� �üҸ� Ż �� �ִ� �ĺ� ���� ���ϱ�
            double candidate1 = cur_weight * 1.0;
            double candidate2 = cur_weight * (2.0/3.0);
            double candidate3 = cur_weight * (2.0/4.0);
            double candidate4 = cur_weight * (3.0/4.0);
            
            // 3. �ĺ� ���Ե��� Map�� ����Ǿ� �ִ� ���, �ش� ���Ը� ���� ����� ¦�� �̷�� (answer�� �߰�)
            if (map.containsKey(candidate1)) answer += map.get(candidate1);
            if (map.containsKey(candidate2)) answer += map.get(candidate2);
            if (map.containsKey(candidate3)) answer += map.get(candidate3);
            if (map.containsKey(candidate4)) answer += map.get(candidate4);
            
            // 4. ���� �ڱ� �ڽ� ���Ե� Map�� ��� ����, �ٸ� �������� �ĺ��� �� �� �ֵ��� �ϱ�
            map.put(cur_weight, map.getOrDefault(cur_weight, 0) + 1);
            
        }
        
        return answer;
    }
}