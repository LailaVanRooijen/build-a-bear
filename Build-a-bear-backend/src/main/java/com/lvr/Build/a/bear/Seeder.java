package com.lvr.Build.a.bear;

import com.lvr.Build.a.bear.bear.Bear;
import com.lvr.Build.a.bear.bear.BearRepository;
import com.lvr.Build.a.bear.bearcolor.BearColor;
import com.lvr.Build.a.bear.bearcolor.ColorRepository;
import com.lvr.Build.a.bear.outfit.Outfit;
import com.lvr.Build.a.bear.outfit.OutfitRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Seeder implements CommandLineRunner {
  BearRepository bearRepository;
  ColorRepository colorRepository;
  OutfitRepository outfitRepository;

  @Override
  public void run(String... args) throws Exception {
    seedColors();
    seedOutfits();
    seedBears();
  }

  private void seedOutfits() {
    outfitRepository.save(new Outfit("princess", "Tiara", "pink corset", "glass pumps"));
    outfitRepository.save(new Outfit("Superhero", "Cape", "Tight Suit", "Boots"));
    outfitRepository.save(new Outfit("Pirate", "Tricorn Hat", "Striped Shirt", "Boots"));
    outfitRepository.save(new Outfit("Astronaut", "Helmet", "Space Suit", "Space Boots"));
    outfitRepository.save(new Outfit("Ballerina", "Tiara", "Tutu", "Ballet Shoes"));
    outfitRepository.save(new Outfit("Rockstar", "Sunglasses", "Leather Jacket", "Ankle Boots"));
    outfitRepository.save(new Outfit("Chef", "Chef Hat", "Apron", "Clogs"));
    outfitRepository.save(new Outfit("Wizard", "Wizard Hat", "Robe", "Pointy Shoes"));
    outfitRepository.save(new Outfit("Firefighter", "Helmet", "Fire Suit", "Fire Boots"));
    outfitRepository.save(new Outfit("Ninja", "Headband", "Black Suit", "Ninja Boots"));
    outfitRepository.save(new Outfit("Fairy", "Wings", "Sparkly Dress", "Slippers"));
    outfitRepository.save(new Outfit("Detective", "Fedora", "Trench Coat", "Loafers"));
    outfitRepository.save(new Outfit("Doctor", "Stethoscope", "Lab Coat", "Comfort Shoes"));
    outfitRepository.save(new Outfit("Cowboy", "Cowboy Hat", "Plaid Shirt", "Cowboy Boots"));
    outfitRepository.save(new Outfit("Swimmer", "Goggles", "Swimsuit", "Flip Flops"));
    outfitRepository.save(new Outfit("Gardener", "Sun Hat", "Overalls", "Gardening Boots"));
    outfitRepository.save(new Outfit("Knight", "Helmet", "Armor", "Metal Boots"));
    outfitRepository.save(new Outfit("Dancer", "Headband", "Leotard", "Dance Shoes"));
    outfitRepository.save(new Outfit("Scientist", "Safety Glasses", "Lab Coat", "Sneakers"));
  }

  public void seedColors() {
    colorRepository.save(new BearColor("Sunset Orange"));
    colorRepository.save(new BearColor("Mermaid Teal"));
    colorRepository.save(new BearColor("Candy Apple Red"));
    colorRepository.save(new BearColor("Mystic Purple"));
    colorRepository.save(new BearColor("Lemonade Yellow"));
    colorRepository.save(new BearColor("Dragonfly Blue"));
    colorRepository.save(new BearColor("Unicorn Pink"));
    colorRepository.save(new BearColor("Rainbow Sparkle"));
    colorRepository.save(new BearColor("Magical Mint"));
    colorRepository.save(new BearColor("Fairy Dust Silver"));
    colorRepository.save(new BearColor("Galaxy Black"));
    colorRepository.save(new BearColor("Aurora Green"));
    colorRepository.save(new BearColor("Midnight Blue"));
    colorRepository.save(new BearColor("Sunshine Yellow"));
    colorRepository.save(new BearColor("Emerald Green"));
    colorRepository.save(new BearColor("Coral Pink"));
    colorRepository.save(new BearColor("Royal Purple"));
    colorRepository.save(new BearColor("Ocean Blue"));
    colorRepository.save(new BearColor("Crimson Red"));
    colorRepository.save(new BearColor("Ivory White"));
    colorRepository.save(new BearColor("Ruby Red"));
    colorRepository.save(new BearColor("Sky Blue"));
    colorRepository.save(new BearColor("Moss Green"));
    colorRepository.save(new BearColor("Blush Pink"));
    colorRepository.save(new BearColor("Slate Gray"));
    colorRepository.save(new BearColor("Champagne"));
    colorRepository.save(new BearColor("Copper Brown"));
  }

  public void seedBears() {
    List<BearColor> colors = colorRepository.findAll();
    List<Outfit> outfits = outfitRepository.findAll();

    int counter = 0;
    bearRepository.save(new Bear("Fluffy McSnuggles", colors.get(counter++), outfits.get(counter)));
    bearRepository.save(new Bear("Cuddle Puff", colors.get(counter++), outfits.get(counter)));
    bearRepository.save(
        new Bear("Whiskers the Brave", colors.get(counter++), outfits.get(counter)));
    bearRepository.save(new Bear("Sir Hugs-a-Lot", colors.get(counter++), outfits.get(counter)));
    bearRepository.save(new Bear("Princess Fuzz", colors.get(counter++), outfits.get(counter)));
    bearRepository.save(new Bear("Snickerdoodle", colors.get(counter++), outfits.get(counter)));
    bearRepository.save(
        new Bear("Captain Snugglepants", colors.get(counter++), outfits.get(counter)));
    bearRepository.save(new Bear("Mr. Furrybottom", colors.get(counter++), outfits.get(counter)));
    bearRepository.save(new Bear("Honey Paws", colors.get(counter++), outfits.get(counter)));
    bearRepository.save(new Bear("Snuggle Wuggles", colors.get(counter++), outfits.get(counter)));
    bearRepository.save(new Bear("Fuzzy Wuzzy", colors.get(counter++), outfits.get(counter)));
    bearRepository.save(new Bear("Tickletoes", colors.get(counter++), outfits.get(counter)));
  }
}
