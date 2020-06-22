package org.wecancodeit.reviewsite2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviewsite2.models.Category;
import org.wecancodeit.reviewsite2.models.SubCategory;
import org.wecancodeit.reviewsite2.repositories.SubCategoryRepository;

import javax.annotation.Resource;

@Controller
public class SubCategoryController {

    @Resource
    private SubCategoryRepository subCategoryRepo;

    @RequestMapping("/subcategories")
    public String displaySubCategories(Model model) {
        model.addAttribute("subcategories", subCategoryRepo.findAll());
        return "subCategoriesView";
    }

    @GetMapping("/subcategories/{subCategoryName}")
    public String displaySingleSubCategory(@PathVariable String subCategoryName, Model model) {
        SubCategory retrievedSubCategory = subCategoryRepo.findCategoryBySubCategoryName(subCategoryName);
        model.addAttribute("subcategory", retrievedSubCategory);
        return "subCategoryView";
    }
}
