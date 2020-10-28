package com.future.thinkInJava5.file;
import java.nio.file.*;
/**
 * 可以通过 getName() 来索引 Path 的各个部分，直到达到上限 getNameCount()**。Path** 也实现了 Iterable 接口，
 * 因此我们也可以通过增强的 for-each 进行遍历。请注意，即使路径以 .java 结尾，使用 endsWith() 方法也会返回 false。
 * 这是因为使用 endsWith() 比较的是整个路径部分，而不会包含文件路径的后缀。
 * 通过使用 startsWith() 和 endsWith() 也可以完成路径的遍历。但是我们可以看到，遍历 Path 对象并不包含根路径，
 * 只有使用 startsWith() 检测根路径时才会返回 true
 * @author Cock-a-doodle-doo!
 */
public class PartsOfPaths {
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("PartsOfPaths.java").toAbsolutePath();
        System.out.println(p);

        for(int i = 0; i < p.getNameCount(); i++)
            System.out.println(p.getName(i));
        System.out.println("ends with '.java': " +
                p.endsWith(".java"));
        for(Path pp : p) {
            System.out.print(pp + ": ");
            System.out.print(p.startsWith(pp) + " : ");
            System.out.println(p.endsWith(pp));
        }
        System.out.println("Starts with " + p.getRoot() + " " + p.startsWith(p.getRoot()));
    }
}
