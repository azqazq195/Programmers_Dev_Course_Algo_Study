import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int rowBegin, int rowEnd) {
        
        // ���� ǥ������ ����Ͽ� ������ ����
        Arrays.sort(data, (row1, row2) -> {
            int colIdx = col - 1;
            if (row1[colIdx] == row2[colIdx]) {
                // �⺻������ �������� ����
                return Integer.compare(row2[0], row1[0]);
            } else {
                // col��° ���� �������� �������� ����
                return Integer.compare(row1[colIdx], row2[colIdx]);
            }
        });

        int answer = 0;

        // S_i�� ���� ���� XOR ���
        for (int i = rowBegin - 1; i <= rowEnd - 1; i++) {
            int sum = 0;
            for (int num : data[i]) {
                sum += num % (i + 1);
            }
            answer ^= sum;
        }

        return answer;
    }
}