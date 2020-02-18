package com.future.dataModel;

import lombok.Data;

/**
 * @author zcd  2020/2/18 11:40
 */
@Data
public class FileInfo {
    /** 文件类型 */
    private FileType fileType;

    /** 存储路径 */
    private String path;
}
