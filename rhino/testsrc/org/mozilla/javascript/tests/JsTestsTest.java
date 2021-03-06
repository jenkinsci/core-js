package org.mozilla.javascript.tests;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.mozilla.javascript.drivers.FileUtils;
import org.mozilla.javascript.drivers.JsTestsBase;

public class JsTestsTest extends JsTestsBase {
    static final String baseDirectory = "testsrc" + File.separator + "jstests";

    static final String jstestsExtension = ".jstest";

    public void runJsTests() throws IOException {
        File[] tests = FileUtils.recursiveListFiles(new File(baseDirectory),
                new FileFilter() {
                  public boolean accept(File f) {
                      return f.getName().endsWith(jstestsExtension);
                  }
                });
        runJsTests(tests);
    }
    
    public void testJsTestsInterpreted() throws IOException {
        setOptimizationLevel(-1);
        runJsTests();
    }
    
    public void testJsTestsCompiled() throws IOException {
        setOptimizationLevel(0);
        runJsTests();
    }
    
    public void testJsTestsOptimized() throws IOException {
        setOptimizationLevel(9);
        runJsTests();
    }
}
