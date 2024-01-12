package fr.iutfbleau.but2.sae322023;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestWorksheet {
    @Test
    public void initialization() {
        Worksheet worksheet = new Worksheet();
        assertEquals(worksheet.getCells().size(), 81);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getUnknownCell() {
        Worksheet worksheet = new Worksheet();
        worksheet.get("Z0");
    }
}
