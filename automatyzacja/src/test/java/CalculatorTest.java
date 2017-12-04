import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void canAddPositiveIntegers() throws Exception {

        Assert.assertTrue("2+2=4",Calculator.add(2,2)==4);
    }

    @Test
    public void canSubtractPositiveIntegers() throws Exception {

        Assert.assertTrue("5-2=3",Calculator.subtract(5,2)==3);

    }

    @Test
    public void canMultiplyPositiveIntegers() throws Exception {

        Assert.assertTrue("5*2=10",Calculator.multiply(5,2)==10);

    }

    @Test
    public void canDividePositiveIntegers() throws Exception {

        Assert.assertTrue("5/1=5",Calculator.divide(5,1)==5);

    }

    @Test

    public void canAddNegativeIntegers() throws Exception{

        Assert.assertTrue("-10+-10",Calculator.add(-10,-10)==-20);
    }

    @Test

    public void canSubstractNegativeIntegers () throws  Exception{

        Assert.assertTrue("-5--5",Calculator.subtract(-5,-5)==0);
    }

    @Test

    public void canMultiplyNegativeIntegers () throws  Exception{

        Assert.assertTrue("-1*-1",Calculator.multiply(-1,-1)==1);
    }

    @Test

    public void canDivideBy0(){

        Assert.assertTrue("divide by zero returns infinity",Calculator.divide(8,0)==Double.POSITIVE_INFINITY);

    }


}