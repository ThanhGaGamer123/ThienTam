package advanceMethod;

import java.util.ArrayList;

public class advance {
    public static final String img = "D:\\IT\\GitHub Projects\\ThienTam\\img\\";

    public static ArrayList<Integer> StringArrayListToIntArrayList(ArrayList<String> stringArray) {
        try {
            ArrayList<Integer> result = new ArrayList<>();
            for (String part : stringArray) {
                result.add(Integer.parseInt(part));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<String> IntArrayListToStringArrayList(ArrayList<Integer> intArray) {
        try {
            ArrayList<String> result = new ArrayList<>();
            for (int part : intArray) {
                result.add(String.valueOf(part));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String StringArrayListToString(ArrayList<String> stringArray) {
        try {
            String result = String.join(";", stringArray);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String IntArrayListToString(ArrayList<Integer> intArray) {
        try {
            ArrayList<String> stringArray = IntArrayListToStringArrayList(intArray);
            String result = StringArrayListToString(stringArray);
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public static String[] StringconvertToStringArray(String string) {
        try {
            String[] result = string.split(";");
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public static ArrayList<String> StringconvertToStringArrayList(String string) {
        try {
            String[] temp = StringconvertToStringArray(string);
            ArrayList<String> result = new ArrayList<>();
            for (int i=0;i<temp.length;i++) {
                result.add(temp[i]);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean checkTextField(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String calculateID(int size) {
        size++;
        if(size < 10) return "000"+size;
        if(size < 100) return "00"+size;
        if(size < 1000) return "0"+size;
        return String.valueOf(size);
    }
}
