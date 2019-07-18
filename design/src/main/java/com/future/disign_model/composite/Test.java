package com.future.disign_model.composite;

/**
 * @author zcd
 * @date 2019-06-12 22:57
 */
public class Test
{
    /**
     * 将对象组合成树形结构以表示‘部分-整体’的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性
     */
    public static void main(String[] args)
    {
        CatalogComponent javaCourseCatalog = new CauseCatalog("java", 2);
        CatalogComponent c1 = new Cause("java-基础", 10);
        CatalogComponent c2 = new Cause("java-中级", 20);
        CatalogComponent c3 = new Cause("java-高级", 30);
        javaCourseCatalog.add(c1);
        javaCourseCatalog.add(c2);
        javaCourseCatalog.add(c3);

        CatalogComponent courseCatalog = new CauseCatalog("main", 1);
        CatalogComponent linuxCouse = new Cause("linux", 25);
        CatalogComponent windowsCourse = new Cause("windows", 15);
        courseCatalog.add(linuxCouse);
        courseCatalog.add(windowsCourse);
        courseCatalog.add(javaCourseCatalog);
        courseCatalog.print();
    }
}
