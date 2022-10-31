package com.components.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2014-11-20.
 */
public class StringUtil extends StringUtils {

    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String STR_BR = "<br/>";
    public static final String STR_BR2 = "<br>";
    public static final String STR_STAR = "*";
    public static final String STR_SET = "set";
    public static final String STR_ZERO = "0";
    public static final String STR_ONE = "1";
    public static final String STR_DOT = ".";
    public static final String STR_COLON = ":";
    public static final String STRING_REVERSE_LEVER = "/";
    public static final String STR_SEMICOLON = ";";
    public static final String STR_ESCAPE = "\\";
    public static final String STR_UNDERLINE = "_";
    public static final String STR_COMMA = ",";
    public static final String STR_MIDDLELINE = "-";
    public static final String STR_PERCENT = "%";
    public static final String STR_QUOTE = "'";
    public static final String STRING_SHUGANG= "|";
    public static final String STR_COLON_SPACE= "：";
    public static final String SEPARATOR = "、";
    public static final String STR_TO = "=>";

    public static final String STR_FOLLOW_INDEX_IMPORT_DATE = "2015-01-01";

    public static final String STR_E = "E";

    public static final String SPACE_SBC = "　";
    public static final String STR_DIRECTION = " =》";
    public static final String STR_COMMA2="、";//顿号

    public static final String STR_DOUBLUE_QUOTE= "\"";//双引号
    public static final String STR_LFET_BRACE= "{";//大括号
    public static final String STR_RIGHT_BRACE= "}";//小括号
    public static final String STR_LFET_BRACKET = "[";//左中括号
    public static final String STR_RIGHT_BRACKET= "]";//右中括号

    public static final String STR_FONT_BEGIN = "<font color=\"red\">";
    public static final String STR_FONT_BEGIN_RED = "<font color='red'>";
    public static final String STR_FONT_BEGIN_GREEN = "<font color='green'>";
    public static final String STR_FONT_END = "</font>";

    public static final String STR_INTEGER_COLOR = "<span style='color:#333;' title='";//整数的颜色
    public static final String STR_DECIMAL_COLOR = "<span style='color:#999;' title='";//小数点后的颜色1(灰色)
    public static final String STR_DECIMAL_COLOR_BLACK = "<span style='color:#333;' title='";//小数点后的颜色2(黑色)
    public static final String STR_COLOR_BEGIN = "'>";
    public static final String STR_COLOR_END = "</span>";

    public static final String MATCH_LETTER="^[a-zA-Z]+$";
    public static final String MATCH_NUMBER="^[0-9]+$";
    public static final String MATCH_NUMBER_CONTAIN_NEGATIVE="^(-)?[0-9]+$";
    public static String getString(Object o) {
        if (o == null) {
            return "";
        } else if (o instanceof String) {
            return (String) o;
        }
        return String.valueOf(o);
    }

    public static String getTrimString(Object o) {
        if (o == null) {
            return "";
        } else if (o instanceof String) {
            return ((String) o).trim();
        }
        return String.valueOf(o).trim();
    }

    /**
     *
     * @param list
     * @return '1','2','3' ...
     */
    public static String join(List list) {
        return "'" + StringUtils.join(list, "','") + "'";
    }

    public static String convertDoubleToString(double d) { //13115041510d
        String s = StringUtil.getString(d);
        int indexE = s.indexOf(StringUtil.STR_E);
        if (indexE != -1) {
            int afterE = Integer.valueOf(s.substring(indexE + 1)); //1.311504151E10
            s = s.substring(0, indexE);
            s = s.replace(StringUtil.STR_DOT, "");//1311504151
            if (s.length() - 1 < afterE) {
                int x = afterE - (s.length() - 1);
                StringBuffer sb = new StringBuffer(s);
                for (int i = 0; i < x; i++) {
                    sb.append(0);
                }
                s = sb.toString();
            }
            String s1 = s.substring(0, afterE + 1);//13115041510
            String s2 = s.substring(afterE + 1);
            if (StringUtil.isBlank(s2)) {
                return s1;
            } else {
                return (s1 + StringUtil.STR_DOT + s2);
            }
        }
        return s;
    }

    public static String getHidePhone(String keyWords, String oriStr) {
        try {
            int i = oriStr.indexOf(keyWords) + 6;
            String s1 = "";
            String s2 = "";
            int indexEqual = oriStr.indexOf("=");
            int subEndIndex = 0;
            if (oriStr.charAt(i) != '：') {
                subEndIndex = i;
            } else {
                subEndIndex = i + 1;
            }
            s1 = oriStr.substring(0, subEndIndex);
            if (indexEqual == -1) {
                s2 = "";
            } else {
                s2 = "[原] " + oriStr.substring(subEndIndex, indexEqual);
            }
            return (s1 + s2);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    /**
     * 半角转全角
     *
     * @param input String.
     * @return 全角字符串.
     */
    public static String toSBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = '\u3000';
            } else if (c[i] < '\177') {
                c[i] = (char) (c[i] + 65248);
            }
        }
        return new String(c);
    }

    /**
     * 全角转半角
     *
     * @param input String.
     * @return 半角字符串
     */
    public static String toDBC(String input) {
        char c[] = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '\u3000') {
                c[i] = ' ';
            } else if (c[i] > '\uFF00' && c[i] < '\uFF5F') {
                c[i] = (char) (c[i] - 65248);
            }
        }
        return new String(c);
    }

    public static String getStatisticsNum(Object o) {
        if (o == null) {
            return "0";
        } else if (o instanceof String) {
            return (String)o;
        }
        return String.valueOf(o);
    }

    /**
     * 填充数字为多少位
     * @param length
     * @param number
     * @return
     */
    public static String lpad(int length, Long number) {
        String f = "%0" + length + "d";
        return String.format(f, number);
    }

    /**
     * 去掉字符串最后一个逗号，如果没逗号，就正常返回
     * @param src
     * @return
     */
    public static String trimLastComma(String src){
        if(src.endsWith(STR_COMMA)){
            return src.substring(0,src.length()-1);//不包含最后一个逗号
        }else{
            return src.substring(0,src.length());//正常返回
        }
    }

    /**
     * 拼接uuid, 第一次不加入逗号
     * @param builder
     * @param uuid
     */
    public static void joinUuidToStringBuilder(StringBuilder builder,String uuid){
        if(builder.length() > 0){
            builder.append(STR_COMMA);
        }
        builder.append("'");
        builder.append(uuid);
        builder.append("'");
    }

    /**
     * 拼接id,第一次不加入逗号
     * @param builder
     * @param id
     */
    public static void joinIdToStringBuilder(StringBuilder builder,Long id){
        if(builder.length() > 0){
            builder.append(STR_COMMA);
        }
        builder.append(id);
    }

    /**字符串全是数字
     * @param str
     * @return
     */
    public static boolean strIsNumber(String str){
        if(isNotBlank(str)){
            return str.matches(MATCH_NUMBER);
        }else{
            return false;
        }
    }

    /**字符串是整数（包含负数）
     * @param str
     * @return
     */
    public static boolean strIsNumberContainNegative(String str){
        if(isNotBlank(str)){
            return str.matches(MATCH_NUMBER_CONTAIN_NEGATIVE);
        }else{
            return false;
        }
    }

    /**字符串全是字母
     * @param str
     * @return
     */
    public static boolean strIsLetter(String str){
        if(isNotBlank(str)){
            return str.matches(MATCH_LETTER);
        }else{
            return false;
        }
    }

    /**
     * 判断字符是否存在于数组中
     * @param values
     * @param value
     * @return
     */
    public static boolean exist(String[] values,String value){
        if(value == null){
            return false;
        }

        int headLength = values.length;
        for (int i = 0; i < headLength; i++) {
            if (StringUtil.equals(value, values[i])) {
                return true;
            }
        }
        return false;
    }

    public static String escape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // These characters are part of the query syntax and must be escaped
            if (c == '\\' || c == '+' || c == '-' || c == '!' || c == '(' || c == ')' || c == ':'
                    || c == '^' || c == '[' || c == ']' || c == '\"' || c == '{' || c == '}' || c == '~'
                    || c == '*' || c == '?' || c == '|' || c == '&' || c == '/') {
                sb.append('\\');
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static Set<Long> splitIdStr2Set(String idsStr){
        if(StringUtil.isBlank(idsStr)){
            return null;
        }
        String[] ids=idsStr.split(STR_COMMA);

        Set<Long> idSet=null;
        for (String idStr : ids) {
            if (StringUtil.isBlank(idStr)){
                continue;
            }
            idStr=idStr.trim();
            if(StringUtil.isNumeric(idStr)){
                if(idSet==null){
                    idSet=new HashSet<>();
                }
                Long id=Long.valueOf(idStr);
                idSet.add(id);
            }
        }

        return idSet;
    }

    /**
     * 字符串转换为list
     * @param value 字符串
     * @param sptr 分隔符，为空默认使用【，】
     * @return list
     */
    public static List<String> convertString2List(String value, String sptr){
        if(StringUtils.isBlank(value)){
            return null;
        }
        if (sptr == null) {
            sptr = STR_COMMA;
        }
        List<String> result = new ArrayList<>();
        String[] array = value.split(sptr);
        for(String str : array){
            if(StringUtils.isNotBlank(str)){
                result.add(str);
            }
        }
        return result;
    }

    /**
     * list转换为字符串
     * @param value list
     * @param sptr 分隔符，为空默认使用【，】
     * @return 字符串
     */
    public static String convertList2String(List<String> value, String sptr) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        if (sptr == null) {
            sptr = STR_COMMA;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : value) {
            stringBuffer.append(sptr);
            stringBuffer.append(str);
        }
        return stringBuffer.substring(sptr.length());
    }
}
