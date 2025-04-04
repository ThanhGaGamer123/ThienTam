package advanceMethod;

public class advance {
    public static final String img = "D:\\IT\\GitHub Projects\\ThienTam\\img\\";

    public static int[] convertToIntArray(String[] stringArray) {
        // Tạo mảng int có cùng kích thước với mảng String
        int[] intArray = new int[stringArray.length];

        // Lặp qua mảng String và chuyển đổi từng phần tử
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]); // Chuyển đổi
        }

        return intArray; // Trả về mảng int
    }

    public static String convertToString(String[] stringArray) {
        String result = stringArray[0];
        for (int i = 1; i < stringArray.length; i++) {
            result+=";"+stringArray[i];
        }
        return result;
    }

    public static String convertToString(int[] stringArray) {
        String result = String.valueOf(stringArray[0]);
        for (int i = 1; i < stringArray.length; i++) {
            result+=";"+stringArray[i];
        }
        return result;
    }

    public static String[] convertToStringArray(String string) {
        String[] result = string.split(";");
        return result;
    }
}
