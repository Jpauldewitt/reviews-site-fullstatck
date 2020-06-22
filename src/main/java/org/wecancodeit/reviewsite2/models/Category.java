package org.wecancodeit.reviewsite2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private Collection<Review> reviews;

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public Category(){
    }

    @Override
    public String toString() {
        return categoryName;
    }

    public Category(String categoryName){
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
