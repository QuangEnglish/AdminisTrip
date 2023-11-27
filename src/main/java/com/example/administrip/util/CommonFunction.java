package com.example.administrip.util;

import java.io.File;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;

@Slf4j
public class CommonFunction {

    public static final String SPECIAL_CHARACTERS_TEMP = "àÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬđĐèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆìÌỉỈĩĨíÍịỊòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰýÝ :+\\<>\"*,!?%$=@#~[]`|^";
    public static final String REPLACEMENTS_TEMP = "aAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAdDeEeEeEeEeEeEeEeEeEeEeEiIiIiIiIiIoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOuUuUuUuUuUuUuUuUuUuUuUyY-___\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000";
    private static final char[] REPLACEMENTS = "aAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAaAdDeEeEeEeEeEeEeEeEeEeEeEiIiIiIiIiIoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOuUuUuUuUuUuUuUuUuUuUuUyY-___\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000".toCharArray();
    protected static final String STR_SPEC = "áàảãạăắằẳẵặâấầẩẫậđéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴ";
    protected static final String STR_REPL = "aaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyAAAAAAAAAAAAAAAAADEEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYY";
    protected static char[] REPLACEMENTS_URL = "aaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyAAAAAAAAAAAAAAAAADEEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYY".toCharArray();

    private static final String KHU_HOI = "Khứ hồi";
    private static final String MOT_CHIEU = "Một chiều";

    public CommonFunction() {
    }

    public static String toUrlFriendly(String s) {
        int maxLength = Math.min(s.length(), 236);
        char[] buffer = new char[maxLength];
        int n = 0;

        for (int i = 0; i < maxLength; ++i) {
            char ch = s.charAt(i);
            buffer[n] = removeAccent(ch);
            if (buffer[n] > 31) {
                ++n;
            }
        }

        while (n > 0 && buffer[n - 1] == '/') {
            --n;
        }

        return String.valueOf(buffer, 0, n);
    }

    public static char removeAccent(char ch) {
        int index = "àÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬđĐèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆìÌỉỈĩĨíÍịỊòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰýÝ :+\\<>\"*,!?%$=@#~[]`|^".indexOf(ch);
        if (index >= 0) {
            ch = REPLACEMENTS[index];
        }

        return ch;
    }

    public static String removeAccent(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); ++i) {
            sb.setCharAt(i, removeAccent(sb.charAt(i)));
        }

        return sb.toString();
    }

    public static char convertUnsign(char ch) {
        int index = "áàảãạăắằẳẵặâấầẩẫậđéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴ".indexOf(ch);
        if (index >= 0) {
            ch = REPLACEMENTS_URL[index];
        }

        return ch;
    }

    public static String removeUnsign(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); ++i) {
            sb.setCharAt(i, convertUnsign(sb.charAt(i)));
        }

        return sb.toString();
    }

    public static String escapeSql(String input) {
        String result = input.trim().replace("/", "//").replace("_", "/_").replace("%", "/%");
        return result;
    }

    public static long getFileSize(String filename) {
        File file = new File(filename);
        if (file.exists() && file.isFile()) {
            return file.length();
        } else {
            System.out.println("File doesn't exist");
            return -1L;
        }
    }

    public static String convertValueToJson(Map<String, Object> params) {
        JSONObject json = new JSONObject();
        if (params != null) {
            Iterator var3 = params.entrySet().iterator();

            while (var3.hasNext()) {
                Map.Entry param = (Map.Entry) var3.next();

                try {
                    json.put((String) param.getKey(), param.getValue());
                } catch (JSONException var5) {
                    log.error("Loi goi service 2.0 khi truyen tham so: " + var5.getMessage(), var5);
                }
            }
        }

        return json.toString();
    }

    public static Object getItemInJson(String item, String strJsonData) {
        Object result = null;

        try {
            JSONObject obj = new JSONObject(strJsonData);
            result = obj.get(item);
        } catch (Exception var4) {
            log.error("Loi! jsonGetItem: " + var4.getMessage(), var4);
        }

        return result;
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }

        return data;
    }

    public static String bytesToHex(byte[] bytes) {
        String result = null;
        if (bytes != null) {
            char[] hexArray = "0123456789ABCDEF".toCharArray();
            char[] hexChars = new char[bytes.length * 2];

            for (int j = 0; j < bytes.length; ++j) {
                int v = bytes[j] & 255;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 15];
            }

            result = new String(hexChars);
        }

        return result;
    }

    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        byte[] var5 = a;
        int var4 = a.length;

        for (int var3 = 0; var3 < var4; ++var3) {
            byte b = var5[var3];
            sb.append(String.format("%02x", b & 255));
        }

        return sb.toString();
    }

    public static String createTokenRandom() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        return token;
    }

    public static Boolean isNullorEmpty(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            return str.isEmpty() || str.isBlank();
        } else if (obj instanceof List) {
            List lst = (List) obj;
            return lst == null || lst.size() < 0;
        }
        return true;
    }

    public static String emptyStrToNull(String str) {
        str = str.trim();
        if (str.isBlank())
            return null;
        else
            return str;
    }

    public static String getTicketName(Long ticketId) {
        if (ticketId == 1) {
            return MOT_CHIEU;
        }
        return KHU_HOI;
    }
}
