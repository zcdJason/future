package com.future.dataModel;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MetaInfo implements Serializable {
    private static final long serialVersionUID = -8175560157590977982L;
    private List<SchemaItem> schemaItemList;
}
