import org.junit.Assert;
import org.junit.Test;
import ua.tests.task2.model.CheckValueStatus;
import ua.tests.task2.model.Game;
import ua.tests.task2.model.GameIsEndException;
import ua.tests.task2.util.PropertiesReader;

import java.util.Map;

public class task2 {

    @Test
    public void testProperties() {

        Map<String, String> props = PropertiesReader.getPropertiesMap("game.properties");

        Assert.assertNotNull("null properties list", props);
        Assert.assertFalse("properties list is empty", props.isEmpty());

        for (String key :
                props.keySet()) {
            Assert.assertNotNull(
                    String.format("null value in %s key of properties list", key),
                    props.get(key));
            Assert.assertFalse(
                    String.format("empty value in %s key of properties list", key),
                    props.get(key) == "");
        }


    }

    @Test(expected = GameIsEndException.class)
    public void testGame() throws Exception{

        Game game = new Game();

        Assert.assertNotNull("Min diapason value doesn't initialized", game.getMinDiapason());
        Assert.assertNotNull("Max diapason value doesn't initialized", game.getMaxDiapason());


        Assert.assertTrue("Min diapason value greater than or equal to the max diapason value",
                game.getMaxDiapason() >= game.getMinDiapason());


        Assert.assertTrue("Doesn't controls out of min diapason",
                game.addNextValue(game.getMinDiapason()-1) == CheckValueStatus.OUT_OF_MIN_DIAPASON);

        Assert.assertTrue("Doesn't controls out of max diapason",
                game.addNextValue(game.getMaxDiapason() + 1) == CheckValueStatus.OUT_OF_MAX_DIAPASON);

        int i = game.getMinDiapason();
        int overMaxDiapason = game.getMaxDiapason() + 1;
        for (; i <= overMaxDiapason; i++) {
            if (game.addNextValue(i) == CheckValueStatus.WIN) {
                break;
            }
        }
        Assert.assertFalse("Game doesn't stop after looping over all diapason",
                i == overMaxDiapason);

        // here is expected an GameIsEndException
        game.addNextValue(++i);

    }

}
