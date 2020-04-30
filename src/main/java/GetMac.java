import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * @Author: Hiccup
 * @Date: 2020/1/9 16:44
 */
public class GetMac {


    public static void main(String[] args) {
        String[] macs = getMacs();
        for (int i = 0; i < macs.length; i++) {
            System.out.println(macs[i]);
        }
    }

    public static String[] getMacs() {
        try {
            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
            List<String> macList = new ArrayList<>();
            while (enumeration.hasMoreElements()) {
                StringBuilder sb = new StringBuilder();
                NetworkInterface networkInterface = enumeration.nextElement();
                if (networkInterface != null) {
                    byte[] bytes = networkInterface.getHardwareAddress();
                    System.out.println(Arrays.toString(bytes));
                    if (bytes != null) {
                        for (int i = 0; i < bytes.length; i++) {
                            if (i != 0) {
                                sb.append("-");
                            }
                            int tmp = bytes[i] & 0xff;
                            String str = Integer.toHexString(tmp);
                            if (str.length() == 1) {
                                sb.append("0" + str);
                            } else {
                                sb.append(str);
                            }
                        }
                        String mac = sb.toString().toUpperCase();
                        macList.add(mac);
                    }
                }
            }
            String[] macArray = new String[macList.size()];
            macList.toArray(macArray);
            return macArray;
        } catch (Exception e) {
            return new String[0];
        }

    }

}
