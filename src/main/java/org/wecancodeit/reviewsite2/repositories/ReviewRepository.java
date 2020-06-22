package org.wecancodeit.reviewsite2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewsite2.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}
