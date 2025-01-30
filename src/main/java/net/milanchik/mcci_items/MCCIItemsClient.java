package net.milanchik.mcci_items;

import net.fabricmc.api.ClientModInitializer;
import net.milanchik.mcci_items.util.ModModelPredicates;

public class MCCIItemsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicates.registerModelPredicates();

    }
}
