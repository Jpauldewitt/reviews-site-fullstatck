package org.wecancodeit.reviewsite2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wecancodeit.reviewsite2.models.Category;
import org.wecancodeit.reviewsite2.models.Review;
import org.wecancodeit.reviewsite2.models.SubCategory;
import org.wecancodeit.reviewsite2.repositories.CategoryRepository;
import org.wecancodeit.reviewsite2.repositories.ReviewRepository;
import org.wecancodeit.reviewsite2.repositories.SubCategoryRepository;

import java.util.Optional;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CategoryRepository categoryRepo;

    @Autowired
    private SubCategoryRepository subCategoryRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    @Test
    public void categoryShouldHaveAListOfReviews(){
        Category testCategory = new Category("Test Category");
        Category testCategory2 = new Category("Test Category2");
        SubCategory testSubCategory = new SubCategory("Test SubCategory");
        Review testReview = new Review(
                "Item",
                "Description",
                "imageUrl",
                "positives",
                "negatives",
                "review section",
                testCategory,
                testSubCategory);
        Review testReview2 = new Review(
                "Item2",
                "Description2",
                "imageUrl2",
                "positives2",
                "negatives2",
                "review section2",
                testCategory,
                testSubCategory);
        categoryRepo.save(testCategory);
        categoryRepo.save(testCategory2);
        subCategoryRepo.save(testSubCategory);
        reviewRepo.save(testReview);
        reviewRepo.save(testReview2);

        entityManager.flush();
        entityManager.clear();

        Optional <Category> retrievedCategoryOpt = categoryRepo.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoryOpt.get();
        Assertions.assertThat(retrievedCategory.getReviews()).contains(testReview);
    }

    @Test
    public void reviewsShouldBeAbleToHaveMultipleSubCategories (){
        Category testCategory = new Category("Test Category");
        SubCategory testSubCategory = new SubCategory("Test SubCategory");
        SubCategory testSubCategory2= new SubCategory("Test SubCategory2");
        Review testReview = new Review(
                "Item",
                "Description",
                "imageUrl",
                "positives",
                "negatives",
                "review section",
                testCategory, testSubCategory2,
                testSubCategory);
        Review testReview2 = new Review(
                "Item2",
                "Description2",
                "imageUrl2",
                "positives2",
                "negatives2",
                "review section2",
                testCategory,
                testSubCategory);
        Review testReview3 = new Review(
                "Item3",
                "Description2",
                "imageUrl2",
                "positives2",
                "negatives2",
                "review section2",
                testCategory,
                testSubCategory2);
        categoryRepo.save(testCategory);
        subCategoryRepo.save(testSubCategory);
        subCategoryRepo.save(testSubCategory2);
        reviewRepo.save(testReview);
        reviewRepo.save(testReview2);
        reviewRepo.save(testReview3);
        entityManager.flush();
        entityManager.clear();

        Review retrievedReview = reviewRepo.findById(testReview.getId()).get();
        SubCategory retrieveSubCategory = subCategoryRepo.findById(testSubCategory.getId()).get();
        SubCategory retrieveSubCategory2 = subCategoryRepo.findById(testSubCategory2.getId()).get();
        Assertions.assertThat(retrievedReview.getSubCategories()).contains(testSubCategory,testSubCategory2);
    }
}
