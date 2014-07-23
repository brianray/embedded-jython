package com.brianray.embedded_jython;


import org.python.core.PyObject;
// import org.python.core.PyString;
import org.python.util.PythonInterpreter;
import org.python.core.PySystemState;
import org.python.core.PyString;
import com.brianray.embedded_jython.ExampleType;


public class JythonFactory {

    private PyObject ExampleClass;

    public JythonFactory(String modulename, String classname) {
        PythonInterpreter interpreter = new PythonInterpreter(null, new PySystemState());
        PySystemState sys = interpreter.getSystemState();
        String rootPath = JythonFactory.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        System.out.println(rootPath);
        sys.path.append(new PyString(rootPath));
        interpreter.exec("from "+modulename+" import "+classname);
        ExampleClass = interpreter.get(classname);
    }

    public ExampleType create () { // (String userid, String passw, String namespace, String URL, String api_level) {

        /* PyObject[] arguments = new PyObject[] {
        }
                new PyString(userid),
                new PyString(passw),
                new PyString(namespace),
                new PyString(URL),
                new PyString(api_level)
        }; */

        PyObject ExampleObject = ExampleClass.__call__(); // (arguments);
        return (ExampleType) ExampleObject.__tojava__(ExampleType.class);
    }
}
