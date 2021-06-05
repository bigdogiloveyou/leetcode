package TOP100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xushu
 * @create 5/22/21 7:49 PM
 * @desc
 */
public class Q56_Merge {

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int res = o1[0] - o2[0];
                if(res == 0){
                    return o2[1] - o1[1];
                }
                return res;
            }
        });

        List<int[]> list = new ArrayList<>();
        int[] start = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i][0] >= start[0] && intervals[i][0] <= start[1]){
                // 只留下大的
                start[1] = Math.max(start[1], intervals[i][1]);
            }else if(intervals[i][0] > start[1]){
                list.add(Arrays.copyOf(start, start.length));
                start[0] = intervals[i][0];
                start[1] = intervals[i][1];
            }
        }
        list.add(Arrays.copyOf(start, start.length));

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] res = new Q56_Merge().merge(intervals);
        for (int[] re : res) {
            System.out.println(re[0] + ":" + re[1]);
        }
    }
}
