package metisto.crc;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CRCTest {
    @DataProvider(name = "samples")
    public static Object[][] samples() {
        return new Object[][]{
                {0x0000, "01/01", 0x0000},
                {0x0000, "12/05", 0x0000},
                {0x0001, "01/01", 0x00c0},
                {0x3408, "18/07", 0x2e0c},
                {0xffff, "01/08", 0x0101},
        };
    }

    @Test(dataProvider = "samples")
    public void check_on_samples(final int input, final String date, final int expected) {
        Assert.assertEquals(CRC.encryptCrc(input, date), expected);
    }
}

