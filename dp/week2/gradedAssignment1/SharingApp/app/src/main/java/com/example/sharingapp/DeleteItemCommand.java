package com.example.sharingapp;

import android.content.Context;

/**
 * Created by dieb7 on 26/10/17.
 */

public class DeleteItemCommand extends Command {

    private ItemList item_list;
    private Item item;
    private Context context;

    public DeleteItemCommand(ItemList item_list, Item item, Context context) {
        this.item_list = item_list;
        this.item = item;
        this.context = context;
    }

    public void execute() {
        item_list.removeItem(item);
        item_list.saveItems(context);
        setIsExecuted(true);
    }
}
