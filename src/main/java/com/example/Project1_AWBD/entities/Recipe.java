package com.example.Project1_AWBD.entities;

import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable
    private String description;

    @Min(value=10, message ="Minim time for preparation is 10 minutes")
    @Max(value=100, message ="Max time for preparation is 100 minutes")
    private String prepTime;

    @Min(value=10, message ="Minim time for cooking is 10 minutes")
    @Max(value=100, message ="Max time for cooking is 100 minutes")
    private String cookTime;

    @Digits(integer = 7, fraction = 0)
    private Integer servings;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredients;

    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "recipie_category",
            joinColumns = @JoinColumn(name = "recipe_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id",referencedColumnName = "id"))
    private List<Category> categories;

    public Recipe removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
        ingredient.setRecipe(null);
        return this;
    }

    @OneToOne
    private Note note;
}
