import test.SecretCode;
import test.TestCase;

import static test.Comparator.compare;

public class Driver {

    public static void main(String[] args){


        SecretCode code = new SecretCode();
        System.out.print(code.decrypt("lazy!!!! s3o6 fe8l I"));


//        int[] array1 = new int[3];
//        int[] array2 = new int[3];
//        array1 = {1,2,3};
//        array2 = [1,2,3];
//        array1 = (1,2,3);
//        array1 = [1 2 3];
//
//        TestCase testcase1 = new TestCase(1, 2, "Hello", "Hello", array1, array2);
//
//
//        compare(testcase1.a, testcase1.b);
//        compare(testcase1.c, testcase1.d);
//        compare(testcase1.e, testcase1.f);
        }
    }
