package advanceMethod;

public class advance {
    public static int[] convertToIntArray(String[] stringArray) {
        // Tạo mảng int có cùng kích thước với mảng String
        int[] intArray = new int[stringArray.length];

        // Lặp qua mảng String và chuyển đổi từng phần tử
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]); // Chuyển đổi
        }

        return intArray; // Trả về mảng int
    }
}
