package com.brianray.embedded_jython;

import com.brianray.embedded_jython.JythonFactory;
import com.brianray.embedded_jython.ExampleType;

public class Main {

    public static void main(String[] args) {
	   // write your code here

        JythonFactory factory = new JythonFactory("Example", "Example");

        ExampleType example  = factory.create();
        example.say_hello();

        System.out.println("done");
    }
}
