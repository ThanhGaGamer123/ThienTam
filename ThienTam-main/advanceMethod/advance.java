package advanceMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class advance {
    public static final String img = "D:\\IT\\GitHub Projects\\ThienTam\\img\\";
    public static final String medIMG = "D:\\IT\\GitHub Projects\\ThienTam\\img\\medIMG\\";
    public static final String file_path = "C:\\Users\\thanh\\Downloads\\";

    public static ArrayList<Double> StringArrayListToDoubleArrayList(ArrayList<String> stringArray) {
        try {
            ArrayList<Double> result = new ArrayList<>();
            for (String part : stringArray) {
                result.add(Double.parseDouble(part));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

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

    public static ArrayList<String> DoubleArrayListToStringArrayList(ArrayList<Double> doubleArray) {
        try {
            ArrayList<String> result = new ArrayList<>();
            for (double part : doubleArray) {
                result.add(String.valueOf(part));
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

    public static String DoubleArrayListToString(ArrayList<Double> doubleArray) {
        try {
            ArrayList<String> stringArray = DoubleArrayListToStringArrayList(doubleArray);
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
            for (int i = 0; i < temp.length; i++) {
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
        if (size < 10)
            return "000" + size;
        if (size < 100)
            return "00" + size;
        if (size < 1000)
            return "0" + size;
        return String.valueOf(size);
    }

    public static String currentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");

        return currentTime.format(format);
    }

    public static Boolean checkDate(String date) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(date, format);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean date1BeforeDate2(String date1, String date2) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate parse_date1 = LocalDate.parse(date1, format);
            LocalDate parse_date2 = LocalDate.parse(date2, format);
            return parse_date1.isBefore(parse_date2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean fulldate1BeforeFullDate2(String date1, String date2) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        try {
            LocalDateTime parse_date1 = LocalDateTime.parse(date1, format);
            LocalDateTime parse_date2 = LocalDateTime.parse(date2, format);
            return parse_date1.isBefore(parse_date2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
