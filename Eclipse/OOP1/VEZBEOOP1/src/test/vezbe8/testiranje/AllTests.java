package test.vezbe8.testiranje;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.vezbe8.testiranje.primer1.Main2Test;
import test.vezbe8.testiranje.primer1.MainTest;

@RunWith(Suite.class)
@SuiteClasses({ MainTest.class, Main2Test.class })
public class AllTests {

}
