package com.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Author: Hiccup
 * @Date: 2019/12/18 14:20
 */
public class PipedTest {

    public static void main(String[] args) throws IOException {
        PipedReader pipedReader = new PipedReader();
        PipedWriter pipedWriter = new PipedWriter();
        // 连接输入输出流
        pipedWriter.connect(pipedReader);

        Thread print = new Thread(new Print(pipedReader), "PrintThread");
        print.start();
        int receive;
        try {
            while ((receive = System.in.read()) != -1){
                pipedWriter.write(receive);
            }
        } finally {
            pipedWriter.close();
        }
    }
    static class Print implements Runnable{

        private PipedReader in;

        Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive;

            try {
                while (((receive = in.read()) != -1)){
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
