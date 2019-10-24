package com.future.disign_model.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zcd
 * @date 2019-06-12 23:05
 */
public class CauseCatalog extends CatalogComponent
{
    private List<CatalogComponent> item = new ArrayList<>();
    private String name;
    private Integer level;

    public CauseCatalog(String name, Integer level)
    {
        this.name = name;
        this.level = level;
    }

    /**
     * 课程目录有添加/删除功能
     * @param catalogComponent
     */
    @Override
    public void add(CatalogComponent catalogComponent)
    {
        item.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent)
    {
        item.remove(catalogComponent);
    }

    @Override
    public String getName(CatalogComponent catalogComponent)
    {
        return this.name;
    }

    @Override
    public void print()
    {
        System.out.println("name:" + this.name);
        for(CatalogComponent catalogComponent: item)
        {
            if(level != null)
            {
                for(int i = 0 ; i<= level ; i++)
                System.out.print(" ");
            }

            catalogComponent.print();
        }
    }
}
