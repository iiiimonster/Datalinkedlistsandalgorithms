package cn.zwy.algorithm.everyday.leetcode.simple;

/**
 * &#064;Description:  <a href="https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/">1450. 在既定时间做作业的学生人数</a><BR/>
 * &#064;author:  zwy<BR/>
 * &#064;date:  2022年08月19日 9:50<BR/>
 *<BR/>
 * 给你两个整数数组 startTime（开始时间）和 endTime（结束时间），并指定一个整数 queryTime 作为查询时间。<BR/>
 * 已知，第 i 名学生在 startTime[i] 时开始写作业并于 endTime[i] 时完成作业。<BR/>
 * 请返回在查询时间 queryTime 时正在做作业的学生人数。形式上，返回能够使 queryTime 处于区间 [startTime[i], endTime[i]]（含）的学生人数。<BR/>
 * 来源：力扣（LeetCode）<BR/>
 * 链接：<a href="https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time">1450. 在既定时间做作业的学生人数</a><BR/>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。<BR/>
 */
public class BusyStudent {


    /**
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param queryTime 查询时间
     * @return 在查询时间内的 总数
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int sum = 0;
        for (int i = 0; i < startTime.length; i++) {
            int start = startTime[i];
            int end = endTime[i];
            if (start< queryTime && end > queryTime) {
                sum++;
            }else if (start== queryTime || end ==queryTime){
                sum++;
            }
        }
        return sum;
    }
}
