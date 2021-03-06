package org.parabot.randoms.pkhonor;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.randoms.Random;
import org.parabot.environment.randoms.RandomType;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.wrappers.Item;

/**
 * @author Fryslan
 */
public class TriangleSandwich implements Random {

    private Item item;
    private final int id = 6963;

    @Override
    public boolean activate() {
        if (Inventory.getItems() != null) {
            for (Item i : Inventory.getItems(id)) {
                if (i != null) {
                    this.item = i;
                    return true;

                }
            }
        }

        return false;
    }

    @Override
    public void execute() {
        if (this.item != null) {
            final int sandwich = Inventory.getCount(id);
            item.drop();
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Inventory.getCount(id) != sandwich;
                }
            }, 1500);
        }
    }

    @Override
    public String getName() {
        return "Triangle Sandwich Handler";
    }

    @Override
    public String getServer() {
        return "pkhonor";
    }

    @Override
    public RandomType getRandomType() {
        return RandomType.SCRIPT;
    }
}
