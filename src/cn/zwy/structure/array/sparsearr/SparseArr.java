package cn.zwy.structure.array.sparsearr;

/**
 * &#064;Description:  稀疏数组
 * &#064;author:  zwy
 * &#064;date:  2022年06月27日 14:58
 */
public class SparseArr {




    /**
     * 解压稀疏数组
     *
     * @param sparseArr 稀疏数组
     * @return 解压后二维数组
     */
    public static int[][] decoSparse(int[][] sparseArr) {
        int[][] arr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i <= sparseArr[0][2]; i++) {
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return arr;
    }


    /**
     * 压缩稀疏数组
     *
     * @param arr 数组
     * @return 返回数组
     */
    public static int[][] sparse(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }
        int[][] sparse = new int[sum + 1][3];
        sparse[0][0] = arr.length;
        sparse[0][1] = arr[0].length;
        sparse[0][2] = sum;
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sparse[count][0] = i;
                    sparse[count][1] = j;
                    sparse[count][2] = arr[i][j];
                    count++;
                }
            }
        }
        return sparse;
    }


    /**
     * 输出 int 二维数组
     *
     * @param arr
     */
    public static void sout(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }


    /**
     * 初始化二维数组
     * <p>
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	0	1	0	0	0	0	0	0	0	0
     * 0	0	0	0	2	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * 0	0	0	0	0	0	0	0	0	0	0
     * </p>
     *
     * @return int 二维数组
     */
    public static int[][] getIntArr() {
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][4] = 2;
        arr[3][4] = 2;
        return arr;
    }


    public static void main(String[] args) {
        int[][] sparse = sparse(getIntArr());
        sout(decoSparse(sparse));
    }
}
