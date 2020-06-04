package lab2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class maintest {
	public static void main(String[] args) {
		FileOutputStream fos = null;

        File file;

        

        try {

            // 指定写入文件的路径

            file = new File("src/lab2/logtest.txt");

            fos = new FileOutputStream(file);

            /* 先检测文件是否存在，如果不存在则先创建*/ 

            if (!file.exists()) {

                file.createNewFile();

            }

            /*

             * 字符串的内容没法直接写到文件，我们需要先使用getBytes转换为bytes。

             */
            String mycontent = "";
            for(int i=0;i<1000000;i++)
            {
            	int max=10000,min=1;
            	 int ran2 = (int) (Math.random()*(max-min)+min); 
            	String xString = "UserId = "+ran2;
            	System.out.println(i);
            	mycontent = xString+"\n";
            	  byte[] bytesArray = mycontent.getBytes();

                  fos.write(bytesArray);
            }
          

            fos.flush();

            System.out.println("File Written Successfully");

        } catch (IOException ioe) {

            ioe.printStackTrace();

        } finally {

            try {

                if (fos != null) {

                    fos.close();

                }

            } catch (IOException ioe) {

                System.out.println("Error in closing the Stream");

            }

        }
	}
}
