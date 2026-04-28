package HomeworkNumFour;

import java.net.NetworkInterface;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Enumeration;

public class MyHWInfo {

    public static void printInfo() {
        System.out.println("Date : " + LocalDate.now());
        System.out.println("Time : " + LocalTime.now());

        try {
            // 모든 네트워크 인터페이스를 불러옵니다.
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            byte[] mac = null;

            while (interfaces.hasMoreElements()) {
                NetworkInterface netIn = interfaces.nextElement();
                // 루프백이 아니고, 작동 중이며, 하드웨어 주소가 있는 인터페이스만 선택
                if (!netIn.isLoopback() && netIn.isUp()) {
                    mac = netIn.getHardwareAddress();
                    if (mac != null) break;
                }
            }

            if (mac != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                }
                System.out.println("Mac Addr. : " + sb.toString());
            } else {
                System.out.println("Mac Addr. : Could not find active MAC address.");
            }

        } catch (Exception e) {
            System.err.println("오류 발생: " + e.getMessage());
        }

        System.out.println("USER : " + System.getProperty("user.name"));
        System.out.println("=====================================================\n");
    }
}