package util;

/**
 * @Author huanghe
 * @Date 2019/9/15 8:56
 * @Description 字符串的工具类
 */
public class StringUtils {

    public static final String EMPTY            = "";
    public static final String SEPARATOR_MULTI  = ";";
    public static final String SEPARATOR_SINGLE = "#";
    public static final String SQL_REPLACE      = "_";

    private static final String BOOLEAN_TRUE_STRING  = "true";
    private static final String BOOLEAN_FALSE_STRING = "false";
    private static final String BOOLEAN_TRUE_NUMBER  = "1";
    private static final String BOOLEAN_FALSE_NUMBER = "0";

    public boolean EmptyString(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        return false;
    }
}
