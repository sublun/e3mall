package cn.e3mall.common.utils;

public class StringUtil {

	/**
	 * 字符串超长时进行字符串截取并在字符串后添加...
	 * <p>Title: cutString</p>
	 * <p>Description: </p>
	 * @param source
	 * @param length 显示多少个汉字的长度。一个汉字=2个英文字符
	 * @return
	 */
	public static String cutString(String source, int length) {
		
		if (length < 1) return "";
		//取字符串长度
		int strLent = length(source);
		if (strLent <= length * 2) {
			return source;
		}
		int strLen = 0;
		StringBuffer sb = new StringBuffer();
		String chinese = "[\u0391-\uFFE5]";
		int i = 0;
		while(strLen < length * 2) {
			//顺次取字符
			String s = source.substring(i, i + 1);
			//判断字符是否为中文
			if(s.matches(chinese)) {
				strLen += 2;
			} else {
				strLen += 1;
			}
			//将字符添加到StringBuffer
			sb.append(s);
			i++;
		}
		//如果是全角半角字符混杂情况下最后一个字符为汉字则超过限制长度，应该从后面去掉两个字符
		if (strLen > length * 2) {
			sb.delete(sb.length() - 2, sb.length());
		} else {
			//如果获取字符串长度和限制长度相同则判断最后一个字符是全角还是半角
			char endChar = sb.charAt(sb.length() - 1);
			//如果是全角删除最后一个字符即可
			if ((endChar + "").matches(chinese)) {
				sb.deleteCharAt(sb.length() - 1);
			} else {
			//如果是半角则需删除两个字符
				sb.delete(sb.length() - 2, sb.length());
			}
		}
		//将字符串最后添加“…”
		sb.append("…");
		return sb.toString();
	}
	
	/**
     * 获取字符串的长度，如果有中文，则每个中文字符计为2位
     * @param value 指定的字符串
     * @return 字符串的长度
     */
    public static int length(String value) {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        /* 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1 */
        for (int i = 0; i < value.length(); i++) {
            /* 获取一个字符 */
            String temp = value.substring(i, i + 1);
            /* 判断是否为中文字符 */
            if (temp.matches(chinese)) {
                /* 中文字符长度为2 */
                valueLength += 2;
            } else {
                /* 其他字符长度为1 */
                valueLength += 1;
            }
        }
        return valueLength;
    }
    
    public static void main(String[] args) {
		//System.out.println(cutString("【套装】小米5s 全网通 高配版 4GB内存 128GB ROM 银色 移动联通电信4G手机", 15));
    	StringBuffer sBuffer = new StringBuffer("【套装】小米5s 全网通 高配版 4");
    	/*sBuffer.append("1");
    	sBuffer.append("2");
    	sBuffer.append("3");
    	sBuffer.append("4");
    	sBuffer.append("5");
    	sBuffer.append("6");*/
    	System.out.println(sBuffer.length());
    	//sBuffer.deleteCharAt(sBuffer.length() - 1);
    	System.out.println(sBuffer);
    	sBuffer.delete(sBuffer.length()-2, -1);
    	System.out.println(sBuffer);
	}
}
