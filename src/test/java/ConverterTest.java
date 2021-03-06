/**
 * Created by stephenpegram on 5/22/17.
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ConverterTest {

    Converter exchanger;

    @Before
    public void setUp(){
        exchanger = new Converter();
    }

    @Test
    public void testConvertDollarToEuro(){
    //Given
        String startingCurrency = "US Dollar";
        String endingCurrency = "Euro";
        double amount = 150.00;
        String expected = new Money<>(141,0).toString();

    //When
        String actual = exchanger.convert(startingCurrency, endingCurrency, amount).toString();

    //Then
        assertEquals("Amounts should equal", expected, actual);
    }


    @Test
    public void testConvertEuroToDollar(){
        //Given
        String startingCurrency = "Euro";
        String endingCurrency = "US Dollar";
        double amount = 150.00;
        String expected = new Money<>(159,57).toString();

        //When
        String actual = exchanger.convert(startingCurrency, endingCurrency, amount).toString();

        //Then
        assertEquals("Amounts should equal", expected, actual);
    }


    @Test
    public void testConvertEuroToPound(){
        //Given
        String startingCurrency = "Euro";
        String endingCurrency = "British Pound";
        double amount = 150.00;
        String expected = new Money<>(130,85).toString();

        //When
        String actual = exchanger.convert(startingCurrency, endingCurrency, amount).toString();

        //Then
        assertEquals("Amounts should equal", expected, actual);
    }


    @Test
    public void testConvertPoundToRupee(){
        //Given
        String startingCurrency = "British Pound";
        String endingCurrency = "Indian Rupee";
        double amount = 150.00;
        String expected = new Money<>(12497,94).toString();

        //When
        String actual = exchanger.convert(startingCurrency, endingCurrency, amount).toString();

        //Then
        assertEquals("Amounts should equal", expected, actual);
    }


    @Test
    public void testConvertRupeeToCanadianDollar(){
        //Given
        String startingCurrency = "Indian Rupee";
        String endingCurrency = "Canadian Dollar";
        double amount = 150.00;
        String expected = new Money<>(2,89).toString();

        //When
        String actual = exchanger.convert(startingCurrency, endingCurrency, amount).toString();

        //Then
        assertEquals("Amounts should equal", expected, actual);
    }


    @Test
    public void testConvertCanadianDollarToSingaporeDollar(){
        //Given
        String startingCurrency = "Canadian Dollar";
        String endingCurrency = "Singapore Dollar";
        double amount = 150.00;
        String expected = new Money<>(162,49).toString();

        //When
        String actual = exchanger.convert(startingCurrency, endingCurrency, amount).toString();

        //Then
        assertEquals("Amounts should equal", expected, actual);
    }


    @Test
    public void testConvertSingaporeDollarToFranc(){
        //Given
        String startingCurrency = "Singapore Dollar";
        String endingCurrency = "Swiss Franc";
        double amount = 150.00;
        String expected = new Money<>(105,94).toString();

        //When
        String actual = exchanger.convert(startingCurrency, endingCurrency, amount).toString();

        //Then
        assertEquals("Amounts should equal", expected, actual);
    }


    @Test
    public void testConvertFrancToRinggit(){
        //Given
        String startingCurrency = "Swiss Franc";
        String endingCurrency = "Malaysian Ringgit";
        double amount = 150.00;
        String expected = new Money<>(663,84).toString();

        //When
        String actual = exchanger.convert(startingCurrency, endingCurrency, amount).toString();

        //Then
        assertEquals("Amounts should equal", expected, actual);
    }


    @Test
    public void testConvertRinggitToYen(){
        //Given
        String startingCurrency = "Malaysian Ringgit";
        String endingCurrency = "Japanese Yen";
        double amount = 150.00;
        String expected = new Money<>(3886,43).toString();

        //When
        String actual = exchanger.convert(startingCurrency, endingCurrency, amount).toString();

        //Then
        assertEquals("Amounts should equal", expected, actual);
    }


    @Test
    public void testConvertYenToYuan(){
        //Given
        String startingCurrency = "Japanese Yen";
        String endingCurrency = "Chinese Yuan Renminbi";
        double amount = 150.00;
        String expected = new Money<>(8,93).toString();

        //When
        String actual = exchanger.convert(startingCurrency, endingCurrency, amount).toString();

        //Then
        assertEquals("Amounts should equal", expected, actual);
    }

    @Test
    public void testToUsRate(){
    //Given
        String currency = "Euro";
        String expected = new Money<>(1,0).toString();

    //When
        String actual = exchanger.toUsRate(currency, 94).toString();

    //Then
        assertEquals("Should be converted to $1.00", expected, actual);

    }


    @Test
    public void testToDesiredRate(){
    //Given
        String currency = "US Dollar" ;
        String expected = new Money<>(4,47).toString();

    //When
        String actual = exchanger.toDesiredRate("Malaysian Ringgit", new Money<>(1, 0)).toString();

    //Then
        assertEquals("Should be converted to $4.47", expected, actual);

    }

    @Test
    public void testToCents(){
    //Given
        String currency = "Malaysian Ringgit";
        int expected = 447;

    //When
        int actual = exchanger.toCents(currency);

    //Then
        assertEquals("Should equal 447 cents", expected, actual);
    }


    @Test
    public void testToLength(){
    //Given
        int num = 438743;
        int expected = 6;

    //When
        int actual = exchanger.lengthOfInt(num);

    //Then
        assertEquals("Length should be 6", expected, actual);
    }


    @Test
    public void testFindRoundingThreshHoldNum(){
    //Given
        int num = 387943;
        int expected = 7;

    //When
        int actual = exchanger.findRoundingThreshholdNum(num, 6);

    //Then
        assertEquals("Should be 7", expected, actual);
    }

    @Test
    public void testChopToDesiredDigits(){
    //Given
        int num = 12349678;
        int expected = 12349;

    //When
        int actual = exchanger.chopToDesiredDigits(num, 8, 5);

    //Then
        assertEquals("Should be chopped to 1234", expected, actual);
    }

}