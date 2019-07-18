package com.future.disign_model.composite;

/**
 * @author zcd
 * @date 2019-06-12 22:28
 */
public abstract class CatalogComponent
{
    public void add(CatalogComponent catalogComponent)
    {
        throw new UnsupportedOperationException();
    }
    public void remove(CatalogComponent catalogComponent)
    {
        throw new UnsupportedOperationException();
    }
    public String getName(CatalogComponent catalogComponent)
    {
        throw new UnsupportedOperationException();
    }
    public Double getPrice(CatalogComponent catalogComponent)
    {
        throw new UnsupportedOperationException();
    }
    public void print()
    {
        throw new UnsupportedOperationException();
    }
}
