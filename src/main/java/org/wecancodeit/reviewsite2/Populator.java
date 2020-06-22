package org.wecancodeit.reviewsite2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancodeit.reviewsite2.models.Category;
import org.wecancodeit.reviewsite2.models.Review;
import org.wecancodeit.reviewsite2.models.SubCategory;
import org.wecancodeit.reviewsite2.repositories.CategoryRepository;
import org.wecancodeit.reviewsite2.repositories.ReviewRepository;
import org.wecancodeit.reviewsite2.repositories.SubCategoryRepository;

import javax.annotation.Resource;

@Component
public class Populator implements CommandLineRunner {

    @Resource
    private CategoryRepository categoryRepo;

    @Resource
    SubCategoryRepository subCategoryRepo;

    @Resource
    ReviewRepository reviewRepo;

    @Override
    public void run(String... args) throws Exception {
        Category food = new Category ("Food");
        Category videogames = new Category ("Video Games");
        Category animals = new Category ("Animals");
        Category actorActresses = new Category("Actors and Actresses");
        categoryRepo.save(food);
        categoryRepo.save(videogames);
        categoryRepo.save(animals);
        categoryRepo.save(actorActresses);

        SubCategory actionrpg = new SubCategory ("Action RPG");
        SubCategory firstPersonShooter = new SubCategory("1st Person Shooter");
        SubCategory fruit = new SubCategory("Fruit");
        SubCategory felineCreature = new SubCategory("Feline Creature");
        SubCategory good = new SubCategory("Good");
        subCategoryRepo.save(actionrpg);
        subCategoryRepo.save(firstPersonShooter);
        subCategoryRepo.save(fruit);
        subCategoryRepo.save(felineCreature);
        subCategoryRepo.save(good);

        Review Diablo3 = new Review(
                "Diablo 3",
                "Action RGP designed by Blizzard to give users the ability to annihilate all sorts of creatures by smashing buttons on a controller",
                "../images/diablo3Pic.jpg",
                "Great graphics",
                "Gets repetitive",
                "Diablo 3 is such a fun game, until your brain switches back on from off mode." +
                        " At that moment in time you are hit with the reality that you should probably be playing" +
                        " something else, or maybe even doing something with your life.",
                videogames,
                actionrpg);

        Review Overwatch = new Review (
                "Overwatch",
                "Team based, first person shooter, designed by Blizzard",
                "../images/overwatch.jpeg",
                "Great team game",
                "Online Community is brutal",
                "Overwatch, what a great game, for people who are good at first person shooters! "+
                        " Beware this isn't for the average gamer."+
                        " If you like competitive first person shooters, this one's for you." +
                        " My advice: remember to put on your big boy pants, strap on your serious gamer face, and get with it." +
                        " Don't forget your A game, because if you don't, someone will let you know that you forgot it.",
                videogames,
                firstPersonShooter);

        Review Banana = new Review (
                "Banana",
                "Easily distinguished by it's yellow outer peeling, the banana features an edible cream like colored interior.",
                "../images/bananaPic.jpg",
                "Unique flavor", "They go bad quickly",
                "Who doesn't love bananas. I mean they are great right? If you have been living in a cave, and for whatever reason"+
                        " have never tried one, stop what you are doing, and go! Now! ",
                food,
                fruit);

        Review Tiger = new Review (
                "Tiger",
                "Striped animal belonging to the feline family.",
                "../images/tigerPic.jpg",
                "Cool looking fur.",
                "They will eat you.",
                "This fur-ocious (ha.. see what I did there) creatures are just amazing. "+
                        "From what I have learned recently, is that if you own enough of these creatures" +
                        " you can pretty much run for mayor, expose the truth about Carol Baskin, and make "+
                        " your own music videos. Pretty neat huh?",
                animals,
                felineCreature);

        Review MarkWahlberg = new Review (
                "Mark Wahlberg",
                "Artist, Musician from Boston",
                "../images/markWahlbergPic.jpg",
                "Wicked Boston accent. Wicked Smart",
                "Sometimes he is a peakcock, and you gotta let him fly.",
                "What a great actor, most of the time.",
                actorActresses,
                good);

        reviewRepo.save(Diablo3);
        reviewRepo.save(Overwatch);
        reviewRepo.save(Banana);
        reviewRepo.save(Tiger);
        reviewRepo.save(MarkWahlberg);
    }
}
