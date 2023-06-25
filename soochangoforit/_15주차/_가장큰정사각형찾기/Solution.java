class Solution
{
 public int solution(int[][] board)
    {
        // ������ ������ �����ɴϴ�.
        int rows = board.length;
        int cols = board[0].length;
        
        // �� �迭�� ��ġ (i, j)���� ������ ���� ū ���簢���� ũ�⸦ �����մϴ�.
        int[][] dp = new int[rows][cols];
        
        // ���� ū ���簢���� ũ�⸦ �����ϱ� ���� ����
        int maxSquareSide = 0;
        
        // ������ �� ���� �ݺ��մϴ�.
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                // ù ��° �� �Ǵ� ù ��° ���̸� ���忡�� ���� �״�� �����մϴ�.
                if(i == 0 || j == 0) {
                    dp[i][j] = board[i][j];
                }
                // �׷��� �ʰ� ���� ���� 1�̸� � ���簢���� ������ �ϴ� �𼭸��Դϴ�.
                else if(board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                // �ִ� ũ�� ������Ʈ
                maxSquareSide = Math.max(maxSquareSide, dp[i][j]);
            }
        }
        
        // ���� ū ���簢���� ���̸� ��ȯ�մϴ�.
        return maxSquareSide * maxSquareSide;
    }
}