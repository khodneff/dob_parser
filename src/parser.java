
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class parser {


    List<String> dob_list = new LinkedList<>();

    BufferedReader dob_Reader;

    {
        try {
            dob_Reader = new BufferedReader(new FileReader("C:/Путь к файлу"));    // Сюда пишем путь к файлу который будуем парсить
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            //e.printStackTrace();
        }
    }

    public void read_dob() throws IOException {

        if (dob_Reader != null) {

            int count_lines = 0;

            FileWriter writer = new FileWriter("C:/Путь к новому файлу"); // Создаем файл куда будем писат валид

            String line;
            String lineSeparator = System.getProperty("line.separator");
            while ((line = dob_Reader.readLine()) != null) {
                if (line.contains("/")) {   // Валидные строки содержат дату разделенную знаком "/"
                    dob_list.add(line);
                    count_lines++;
                }
            }
            for (String a : dob_list
            ) {
                writer.write(a + lineSeparator);

            }
            System.out.println(count_lines + " valid lines!");
            writer.flush();
            writer.close();
        }


    }




}
