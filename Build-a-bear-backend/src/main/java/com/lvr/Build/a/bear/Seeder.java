package com.lvr.Build.a.bear;

import com.lvr.Build.a.bear.bear.Bear;
import com.lvr.Build.a.bear.bear.BearRepository;
import com.lvr.Build.a.bear.bearcolor.BearColor;
import com.lvr.Build.a.bear.bearcolor.ColorRepository;
import com.lvr.Build.a.bear.furpattern.FurPattern;
import com.lvr.Build.a.bear.furpattern.FurPatternRepository;
import com.lvr.Build.a.bear.furtype.FurType;
import com.lvr.Build.a.bear.furtype.FurTypeRepository;
import com.lvr.Build.a.bear.outfit.Outfit;
import com.lvr.Build.a.bear.outfit.OutfitRepository;
import com.lvr.Build.a.bear.voice.Voice;
import com.lvr.Build.a.bear.voice.VoiceRepository;
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
  FurTypeRepository furTypeRepository;
  FurPatternRepository furPatternRepository;
  VoiceRepository voiceRepository;

  @Override
  public void run(String... args) throws Exception {
    seedVoices();
    seedFurTypes();
    seedFurPatterns();
    seedColors();
    seedOutfits();
    seedBears();
  }

  private void seedVoices() {
    voiceRepository.save(new Voice("Whisper"));
    voiceRepository.save(new Voice("Giggle"));
    voiceRepository.save(new Voice("Squeak"));
    voiceRepository.save(new Voice("Roar"));
    voiceRepository.save(new Voice("Chuckle"));
    voiceRepository.save(new Voice("Growl"));
    voiceRepository.save(new Voice("Purr"));
    voiceRepository.save(new Voice("Hum"));
    voiceRepository.save(new Voice("Chime"));
    voiceRepository.save(new Voice("Sing"));
    voiceRepository.save(new Voice("Laugh"));
    voiceRepository.save(new Voice("Buzz"));
    voiceRepository.save(new Voice("Tweet"));
    voiceRepository.save(new Voice("Hiss"));
    voiceRepository.save(new Voice("Yodel"));
  }

  private void seedFurPatterns() {
    furPatternRepository.save(new FurPattern("Tiger Print"));
    furPatternRepository.save(new FurPattern("Leopard Spots"));
    furPatternRepository.save(new FurPattern("Zebra Stripes"));
    furPatternRepository.save(new FurPattern("Polka Dots"));
    furPatternRepository.save(new FurPattern("Paisley Swirl"));
    furPatternRepository.save(new FurPattern("Checkerboard"));
    furPatternRepository.save(new FurPattern("Camouflage"));
    furPatternRepository.save(new FurPattern("Marble"));
    furPatternRepository.save(new FurPattern("Hounds tooth"));
    furPatternRepository.save(new FurPattern("Plaid"));
    furPatternRepository.save(new FurPattern("Galaxy"));
    furPatternRepository.save(new FurPattern("Floral"));
    furPatternRepository.save(new FurPattern("Gradient Fade"));
    furPatternRepository.save(new FurPattern("Chevron"));
    furPatternRepository.save(new FurPattern("Abstract Brushstrokes"));
    furPatternRepository.save(new FurPattern("Pearl White"));
  }

  private void seedFurTypes() {
    furTypeRepository.save(new FurType("Fluffy"));
    furTypeRepository.save(new FurType("Sleek"));
    furTypeRepository.save(new FurType("Bristly"));
    furTypeRepository.save(new FurType("Velvety"));
    furTypeRepository.save(new FurType("Curly"));
    furTypeRepository.save(new FurType("Shaggy"));
    furTypeRepository.save(new FurType("Feathery"));
    furTypeRepository.save(new FurType("Silky"));
    furTypeRepository.save(new FurType("Woolly"));
    furTypeRepository.save(new FurType("Spiky"));
    furTypeRepository.save(new FurType("Fuzzy"));
    furTypeRepository.save(new FurType("Matted"));
    furTypeRepository.save(new FurType("Glossy"));
    furTypeRepository.save(new FurType("Frizzy"));
    furTypeRepository.save(new FurType("Downy"));
  }

  private void seedOutfits() {
    outfitRepository.save(new Outfit("Princess", "Tiara", "Pink Corset", "Glass Pumps"));
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
    List<FurType> furTypes = furTypeRepository.findAll();
    List<FurPattern> furPatterns = furPatternRepository.findAll();
    List<Voice> voices = voiceRepository.findAll();

    int counter = 0;
    bearRepository.save(
        new Bear(
            "Fluffy McSnuggles",
            colors.get(counter),
            outfits.get(counter),
            furPatterns.get(counter),
            furTypes.get(counter),
            voices.get(counter++)));
    bearRepository.save(
        new Bear(
            "Cuddle Puff",
            colors.get(counter),
            outfits.get(counter),
            furPatterns.get(counter),
            furTypes.get(counter),
            voices.get(counter++)));
    bearRepository.save(
        new Bear(
            "Whiskers the Brave",
            colors.get(counter),
            outfits.get(counter),
            furPatterns.get(counter),
            furTypes.get(counter),
            voices.get(counter++)));
    bearRepository.save(
        new Bear(
            "Sir Hugs-a-Lot",
            colors.get(counter),
            outfits.get(counter),
            furPatterns.get(counter),
            furTypes.get(counter),
            voices.get(counter++)));
    bearRepository.save(
        new Bear(
            "Princess Fuzz",
            colors.get(counter),
            outfits.get(counter),
            furPatterns.get(counter),
            furTypes.get(counter),
            voices.get(counter++)));
    bearRepository.save(
        new Bear(
            "Snickerdoodle",
            colors.get(counter),
            outfits.get(counter),
            furPatterns.get(counter),
            furTypes.get(counter),
            voices.get(counter++)));
    bearRepository.save(
        new Bear(
            "Captain Snugglepants",
            colors.get(counter),
            outfits.get(counter),
            furPatterns.get(counter),
            furTypes.get(counter),
            voices.get(counter++)));
    bearRepository.save(
        new Bear(
            "Mr. Furrybottom",
            colors.get(counter),
            outfits.get(counter),
            furPatterns.get(counter),
            furTypes.get(counter),
            voices.get(counter++)));
    bearRepository.save(
        new Bear(
            "Honey Paws",
            colors.get(counter),
            outfits.get(counter),
            furPatterns.get(counter),
            furTypes.get(counter),
            voices.get(counter++)));
    bearRepository.save(
        new Bear(
            "Snuggle Wuggles",
            colors.get(counter),
            outfits.get(counter),
            furPatterns.get(counter),
            furTypes.get(counter),
            voices.get(counter++)));
    bearRepository.save(
        new Bear(
            "Fuzzy Wuzzy",
            colors.get(counter),
            outfits.get(counter),
            furPatterns.get(counter),
            furTypes.get(counter),
            voices.get(counter++)));
    bearRepository.save(
        new Bear(
            "Tickletoes",
            colors.get(counter),
            outfits.get(counter),
            furPatterns.get(counter),
            furTypes.get(counter),
            voices.get(counter++)));
  }
}
