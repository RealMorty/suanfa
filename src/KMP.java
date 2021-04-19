import java.util.Arrays;

public class KMP {
    /**
     * 利用最大前缀后缀求大字符串中匹配小字符串的位置
     * @param s long string
     * @param m short string
     * @return 匹配index
     */
    public static int getIndexOf(String s, String m) {
        /**
         * @Param:s long string
         * @Param:m short string
         */
        if (s == null || m == null || m.length() < 1 || s.length() < m.length())
            return -1;
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private static int[] getNextArray(char[] str) {
        if (str.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int[str.length];
        next[0]=-1;
        next[1]=0;
        int i=2;
        int cn = 0;
        while (i<next.length) {
            if (str[i-1]==str[cn]) {
                next[i++] = ++cn;
            } else if (cn>0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int[] nextArray = getNextArray("abbabba".toCharArray());
        System.out.println(Arrays.toString(nextArray));
    }
}

