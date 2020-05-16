package org.mankell.gmall.vo.product;

import lombok.Data;
import org.mankell.gmall.pms.entity.ProductAttribute;
import org.mankell.gmall.pms.entity.ProductAttributeCategory;

import java.io.Serializable;
import java.util.List;

/**
 * 包含有分类下属性的vo
 */
@Data
public class PmsProductAttributeCategoryItem extends ProductAttributeCategory  implements Serializable {
    private List<ProductAttribute> productAttributeList;


}
