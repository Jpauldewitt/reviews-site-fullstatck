package org.wecancodeit.reviewsite2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewsite2.models.Category;

public interface CategoryRepository extends CrudRepository <Category, Long> {
    Category findCategoryByCategoryName(String categoryName);
}
