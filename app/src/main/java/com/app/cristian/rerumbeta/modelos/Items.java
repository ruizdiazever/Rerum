package com.app.cristian.rerumbeta.modelos;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
/**
 * Created by nicolaspickelny on 5/13/17.
 */

@Root(name = "Items")
public class Items
{

    @ElementList(entry="Item", inline=true)
    private ArrayList<Item> Item;

    public ArrayList<Item> getItem ()
    {
        return Item;
    }

    public void setItem (ArrayList<Item> Item)
    {
        this.Item = Item;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Item = "+Item+"]";
    }
}