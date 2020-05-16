package org.mankell.gmall.vo.product;


import lombok.Data;
import org.mankell.gmall.pms.entity.ProductCategory;

import java.io.Serializable;
import java.util.List;

/**
 */
@Data
public class PmsProductCategoryWithChildrenItem extends ProductCategory implements Serializable {
    private List<ProductCategory> children;

}
