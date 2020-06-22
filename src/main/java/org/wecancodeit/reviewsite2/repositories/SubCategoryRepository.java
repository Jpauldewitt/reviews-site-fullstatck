package org.wecancodeit.reviewsite2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewsite2.models.SubCategory;

public interface SubCategoryRepository extends CrudRepository<SubCategory, Long> {
    SubCategory findCategoryBySubCategoryName(String subCategoryName);
}
