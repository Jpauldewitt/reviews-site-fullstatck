package org.wecancodeit.reviewsite2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class SubCategory {

    @Id
    @GeneratedValue
    private Long id;
    private String subCategoryName;

    @ManyToMany(mappedBy = "subCategories")
    private Collection<Review> reviews;

    public Long getId() {
        return id;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public Collection <Review> getReviews(){
        return reviews;
    }


    public SubCategory(){
    }

    public SubCategory(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubCategory that = (SubCategory) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
