import java.util.*;

public class Solution {
    List<Set<Integer>> candidateKeys;
    String[][] relation;
    int colSize;

    public int solution(String[][] relation) {
        this.relation = relation;
        this.colSize = relation[0].length;
        this.candidateKeys = new ArrayList<>();

        // i �� 1 ~ 4 (�� 4�� ���̺� ����)
        for (int i = 1; i <= colSize; i++) {
            makeCombinations(0, 0, i, new HashSet<>());
        }

        return candidateKeys.size();
    }

    /**
     * @param start ������ ������ ���� �ε���
     * @param depth ���� ������ ����
     * @param target ��ǥ�ϰ��� �ϴ� ������ ����
     * @param columns ������� ���� ������ ����
     */
    private void makeCombinations(int start, int depth, int target, Set<Integer> columns) {

        // if �� �ȿ����� dept, target, columns ���� ����ϸ� �ȴ�.
        if (depth == target) {
            // {�ĺ�Ű�� �� �� ������ ������ �𸣴� column(��) ����}�� {�̹� ���� ���ϼ��� �ּҼ��� �����ϴ� key}�� �����ϰ� ������ : �ּҼ��� �������� �� �� return �ʿ�.
            // ��, �ּҼ��� �������� �� �ϴ� ���
            for (Set<Integer> keySet : candidateKeys) {
                if (columns.containsAll(keySet)) return;
            }

            // �ּҼ��� ����������, ���ϼ��� �����ϴ��� ����
            if (checkUniqueness(columns)) {
                // ���ϼ��� �����Ѵٸ� ���������� �ĺ�Ű�� �� �� �ִ�.
                candidateKeys.add(columns);
            }
            return;
        }

        for (int i = start; i < colSize; i++) {
            // ��� ȣ���� columns�� �������� ���纻�� ���
            //  �� ��� ȣ�⿡�� columns�� ���¸� �����ص� �ٸ� ��� ȣ�⿡�� ������ ���� �ʴ´�.
            Set<Integer> newSet = new HashSet<>(columns);
            newSet.add(i);
            makeCombinations(i + 1, depth + 1, target, newSet);
        }
    }

    /**
     * @param columns ������� ���� ������ ����
     */
    private boolean checkUniqueness(Set<Integer> columns) {
        List<String> tuples = new ArrayList<>();

        // ���� columns �� �ִ� "�ĺ�Ű�� �� ���� �ְ� �ȵɼ��� �ִ�" Ű���� ���� �̴´�.
        // ��� ���� �� tuple�� �����´�.
        for (String[] tuple : relation) {
            // �ϳ��� row���� column�� �ش��ϴ� ��� ���ڿ��� �ϳ��� ��ģ��.
            // ex) 100ryanmusic2
            // column 1 index �� ����ϴ� ���, tuples�� "ryan", "apeach", "tube", "con", "muzi", "apeach" �� �ȴ�.
            StringBuilder sb = new StringBuilder();
            for (int column : columns) {
                sb.append(tuple[column]);
            }
            tuples.add(sb.toString());
        }

        // columns �������� ����, ��� tuple���� ������ �ߺ����� �ʴ´ٸ�, �ĺ�Ű�� �� �� �ִ�.
        Set<String> uniqueTuples = new HashSet<>(tuples);
        int rowCount = relation.length;

        return uniqueTuples.size() == rowCount;
    }

}
