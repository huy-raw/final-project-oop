package utils;

import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {

    private static Scanner sc;

    //hàm nhập 1 số nguyên
    public static int getAnInteger(String inputMsg, String errorMsg) {
        sc = new Scanner(System.in);
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < 1) throw new IncorrectNumberException(Language.MSG_MUST_GREATER_THAN_ZERO);
                return n;
            } catch (NumberFormatException | IncorrectNumberException e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        sc = new Scanner(System.in);
        int n, tmp;
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            } finally {

            }
        }
    }

    //hàm nhập vào 1 chuỗi
    public static String getString(String inputMsg, String errorMsg) {
        sc = new Scanner(System.in);
        String string;
        while (true) {
            System.out.print(inputMsg);
            string = sc.nextLine().trim();
            if (string.length() == 0) {
                System.out.println(errorMsg);
            } else {
                return string;
            }
        }
    }

    //hàm nhập ID theo định dạng có sẵn
    public static String getID(String inputMsg, String errorMsg, String format) {
        sc = new Scanner(System.in);
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);

            id = sc.nextLine().trim().toLowerCase();

            match = id.matches(format);
            if (match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());

            return convertByteToHex(messageDigest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String convertByteToHex(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(Integer.toString((data[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public static void printAuthMenu() {
        System.out.println(Constants.UI_DIV);
        System.out.println("Hệ thống quản lí tài khoản");
        System.out.println(Constants.UI_DIV);
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Đăng nhập tài khoản khách");
        System.out.println("4 - Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    public static void printGuestManageMenu() {
        System.out.println(Constants.UI_DIV);
        System.out.println("Hệ thống quản lí tài liệu (chế độ khách)");
        System.out.println(Constants.UI_DIV);
        System.out.println("1 - Hiển thị tất cả tài liệu");
        System.out.println("2 - Tìm tài liệu theo ID");
        System.out.println("3 - Tìm tài liệu theo tên");
        System.out.println("4 - Tìm tài liệu theo nhà xuất bản");
        System.out.println("5 - Tìm tài liệu theo loại");
        System.out.println("6 - Sắp xếp tài liệu");
        System.out.println("7 - Xuất các tài liệu trong hệ thống ra file");
        System.out.println("8 - Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    public static void printAdminManageMenu() {
        System.out.println(Constants.UI_DIV);
        System.out.println("Hệ thống quản lí tài liệu (chế độ người dùng)");
        System.out.println(Constants.UI_DIV);
        System.out.println("1 - Tạo tài liệu mới");
        System.out.println("2 - Hiển thị tất cả tài liệu");
        System.out.println("3 - Xoá tài liệu");
        System.out.println("4 - Cập nhật tài liệu");
        System.out.println("5 - Tìm tài liệu theo ID");
        System.out.println("6 - Tìm tài liệu theo tên");
        System.out.println("7 - Tìm tài liệu theo nhà xuất bản");
        System.out.println("8 - Tìm tài liệu theo loại");
        System.out.println("9 - Sắp xếp tài liệu");
        System.out.println("10 - Xuất các tài liệu trong hệ thống ra file");
        System.out.println("11 - Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }
}

class IncorrectNumberException extends Exception { 
    public IncorrectNumberException(String errorMessage) {
        super(errorMessage);
    }
}