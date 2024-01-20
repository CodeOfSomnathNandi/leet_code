import java.util.Arrays;
import java.util.HexFormat;

/**
 * Given a string queryIP, return "IPv4" if IP is a valid IPv4 address, "IPv6"
 * if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any
 * type.
 * 
 * A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255
 * and xi cannot contain leading zeros. For example, "192.168.1.1" and
 * "192.168.1.0" are valid IPv4 addresses while "192.168.01.1", "192.168.1.00",
 * and "192.168@1.1" are invalid IPv4 addresses.
 * 
 * A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:
 * 
 * 1 <= xi.length <= 4
 * xi is a hexadecimal string which may contain digits, lowercase English letter
 * ('a' to 'f') and upper-case English letters ('A' to 'F').
 * Leading zeros are allowed in xi.
 * For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and
 * "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while
 * "2001:0db8:85a3::8A2E:037j:7334" and
 * "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: queryIP = "172.16.254.1"
 * Output: "IPv4"
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 * 
 * Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * Output: "IPv6"
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * Example 3:
 * 
 * Input: queryIP = "256.256.256.256"
 * Output: "Neither"
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 * 
 * 
 * Constraints:
 * 
 * queryIP consists only of English letters, digits and the characters '.' and
 * ':'.
 */

public class ValidateIp {
    public boolean validateInt(String s) {
        try {
            int value = Integer.parseInt(s);
            if (s.charAt(0) == '0' && s.length() != 1) {
                return false;
            }
            if (value < 256 && value >= 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

     public boolean isValideString(String s) {
        try {
            if (s.length() > 4) {
                return false;
            }
            if (s == "") {
                return false;
            }
            HexFormat.fromHexDigitsToLong(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
      public String validIPAddress(String queryIP) {
        boolean checkIp4 = false;
        if (queryIP.length() == 0) {
            return "Neither";
        }
        if (queryIP.contains(".")) {
            checkIp4 = true;
        }
        String split_str;
        if (checkIp4) {
            if (queryIP.charAt(queryIP.length()-1) == '.') {
                return "Neither";
            }
            if (queryIP.charAt(0) == '.') {
                return "Neither";
            }
            
            split_str = "\\.";
        }else {
            if (queryIP.charAt(queryIP.length()-1) == ':') {
                return "Neither";
            }
            if (queryIP.charAt(0) == ':') {
                return "Neither";
            }
            split_str = ":";
            
        }
        String[] tokens = queryIP.split(split_str);
        if (checkIp4) {
            if (tokens.length != 4) {
                return "Neither";
            }
        } else {
            if (tokens.length != 8) {
                return "Neither";
            }
        }
        System.out.println(Arrays.toString(tokens));
        System.out.println(queryIP);
        boolean isAllValid = true;

        if (checkIp4) {
            for (int i = 0; i < tokens.length; i++) {
                boolean isValideInt = validateInt(tokens[i]);
                if (isValideInt) {
                    isAllValid = true && isAllValid;
                } else {
                    isAllValid = false;
                }
            }
            if (!isAllValid) {
                return "Neither";
            }
            return "IPv4";
        }
        for (int i = 0; i < tokens.length; i++) {
            boolean isValid = isValideString(tokens[i]);
            if (isValid) {
                isAllValid = true && isAllValid;
            } else {
                isAllValid = false;
            }
        }
        if (!isAllValid) {
            return "Neither";
        }
        return "IPv6";
    }



    public static void main(String[] args) {
        String q = "192.0.0.1";
        ValidateIp foo = new ValidateIp();
        System.out.println(foo.validIPAddress(q));
    }

}
