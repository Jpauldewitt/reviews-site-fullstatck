package org.wecancodeit.reviewsite2.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String item;
    private String description;
    private String imageUrl;
    private String positives;
    private String negatives;
    @Lob
    private String reviewSection;

    @ManyToOne
    private Category category;

    @ManyToMany
    private Collection<SubCategory> subCategories;


    public Review(){
    }


    public Review(String item,
                  String description,
                  String imageUrl,
                  String positives,
                  String negatives,
                  String reviewSection,
                  Category category,
                  SubCategory... subCategories) {


        this.item = item;
        this.description = description;
        this.imageUrl = imageUrl;
        this.positives = positives;
        this.negatives = negatives;
        this.reviewSection = reviewSection;
        this.category = category;
        this.subCategories = new ArrayList<>(Arrays.asList(subCategories));
    }
    public Long getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPositives() {
        return positives;
    }

    public String getNegatives() {
        return negatives;
    }

    public String getReviewSection() {
        return reviewSection;
    }

    public Category getCategory() {
        return category;
    }

    public Collection <SubCategory> getSubCategories() {
        return subCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
