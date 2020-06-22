package org.wecancodeit.reviewsite2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.reviewsite2.models.Category;
import org.wecancodeit.reviewsite2.models.Review;
import org.wecancodeit.reviewsite2.models.SubCategory;
import org.wecancodeit.reviewsite2.repositories.CategoryRepository;
import org.wecancodeit.reviewsite2.repositories.ReviewRepository;
import org.wecancodeit.reviewsite2.repositories.SubCategoryRepository;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerMVCTest {

    @MockBean
    private CategoryRepository categoryRepo;

    @MockBean
    private SubCategoryRepository subCategoryRepo;

    @MockBean
    private ReviewRepository reviewRepo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void categoriesShouldBeOkAndReturnCategoriesViewWithCategoriesModelAttribute() throws Exception {
        mockMvc.perform(get("/categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categoriesView"))
                .andExpect(model().attributeExists("categories"));
    }

    @Test
    public void shouldBeOkForSingleCategoryEndpointWithCategoryViewAndCategoryModelAttribute() throws Exception {
        Category testCategory = new Category("videogames");
        when(categoryRepo.findCategoryByCategoryName("videogames")).thenReturn(testCategory);
        mockMvc.perform(get("/categories/videogames"))
                .andExpect(status().isOk())
                .andExpect(view().name("categoryView"))
                .andExpect(model().attributeExists("category"));
    }

    @Test
    public void shouldBeOkForSingleReviewEndpointWithReviewViewAndReviewModelAttribute() throws Exception {
        Category testCategory = new Category("Food");
        SubCategory testSubCategory = new SubCategory("Fruit");
        Review testReview = new Review(
                "Item",
                "Description",
                "imageUrl",
                "positives",
                "negatives",
                "review section",
                testCategory,
                testSubCategory);
        when(reviewRepo.findById(1L)).thenReturn(java.util.Optional.of(testReview));
        mockMvc.perform(get("/reviews/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("reviewView"))
                .andExpect(model().attributeExists("review"));
    }
}
