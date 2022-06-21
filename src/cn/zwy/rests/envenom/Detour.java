package cn.zwy.rests.envenom;

/**
 * @Description: 舍近求远 有简单的可读性代码 但是非要使用复杂的代码去实现，配合上一步漫天过海使用 效果更佳
 * @author: zwy
 * @date: 2022年06月16日 16:43
 */
public class Detour {
    //定义一个别人看不懂的 零 ！！
    static int ZERO = Integer.MAX_VALUE >> 31 >> 1;
    static int wu = Integer.MAX_VALUE >> 32;

    static int tminus = -151 >> 31;
    static int thminus = -151 >>> 31;

    public static void main(String[] args) {

        System.out.println("ZERO: " + ZERO);
        System.out.println("wu: " + wu);
        System.out.println("tminus: " + tminus);
        System.out.println("thminus: " + thminus);
    }

}
