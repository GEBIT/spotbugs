package sfBugsNew;

import com.google.common.base.Preconditions;

import edu.umd.cs.findbugs.annotations.ExpectWarning;
import edu.umd.cs.findbugs.annotations.NoWarning;

public class Feature326 {
    @ExpectWarning("UC_USELESS_CONDITION")
    public int deadCode(int x) {
        if(x > 10) {
            return 1;
        }
        if(x <= 10) {
            return -1;
        }
        return 0;
    }
    
    @NoWarning("UC_USELESS_CONDITION")
    public int fp(int x) {
        if( x >= -1 )
        {
            int result = x == -1 ? 1 : 2;
            return result;
        }
        return 0;
    }
    
    @ExpectWarning("UC_USELESS_CONDITION")
    public int condition(int x) {
        if(x > 10 && x > 5) {
            return 2; 
        }
        return 1;
    }
    
    @NoWarning("UC_USELESS_CONDITION")
    public void testFinally(boolean c) {
        try {
            if(c) {
                System.out.println("1");
            }
        }
        finally {
            if(c)
                System.out.println("2");
            else
                System.out.println("3");
        }
    }

    @NoWarning("UC_USELESS_CONDITION")
    public void testTwoSlotParameters(long l1, int m2, long l3) {
        if(m2 == 199 || m2 == 200) {
            System.out.println("test");
        }
        if(l3 == 199) {
            System.out.println("test");
        }
        if(l1 == 199) {
            System.out.println("test");
        }
        System.out.println("best");
    }

    @NoWarning("UC_USELESS_CONDITION")
    public void testInverseCondition(int p) throws Exception {
        if(4<p) {
            throw new Exception();
        } else if(4>p) {
            System.out.println("!!!");
        }
        System.out.println("???");
    }

    @ExpectWarning("UC_USELESS_CONDITION")
    public void testInverseCondition2(int p) throws Exception {
        if(4<p) {
            throw new Exception();
        } else if(4>=p) {
            System.out.println("!!!");
        }
        System.out.println("???");
    }

    @ExpectWarning("UC_USELESS_CONDITION")
    public int localVarTest() throws Exception {
        int var = condition(1);
        if(var < 1) {
            return 0;
        }
        if(var > 0) {
            System.out.println("1");
        }
        if(var > 0) {
            System.out.println("1");
        }
        return 2;
    }

    @NoWarning("UC_USELESS_CONDITION")
    public void testAssert(int x) {
        if(x < 0) {
            return;
        }
        Preconditions.checkArgument(x >= 0);
        System.out.println(x);
    }
}
