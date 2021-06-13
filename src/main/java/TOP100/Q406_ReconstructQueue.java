package TOP100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author xushu
 * @create 6/6/21 1:57 PM
 * @desc
 */
public class Q406_ReconstructQueue {

    /**
     * 1、先按照身高降序排列，如果身高相同，那么按照前面出现的次数生序排序
     * 2、排序完成之后，按照前面出现的次数作为索引插入到集合中（可以自己操作一遍）
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0){
            return new int[][]{};
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int value = o2[0] - o1[0];
                if(value == 0){
                    value = o1[1] - o2[1];
                }
                return value;
            }
        });

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }

        return list.toArray(people);
    }

    public static void main(String[] args) {
        int[][] people = {
                {7, 0},{4,4},{7,1},{5,0},{6,1},{5,2}
        };

        // fast、fast、fast、fast!!!!
        int[][] res = new Q406_ReconstructQueue().reconstructQueue(people);
        for (int[] re : res) {
            System.out.println(re[0] + ":" + re[1]);
        }
    }
}
