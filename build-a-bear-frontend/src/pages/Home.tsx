import BuildABear from "../assets/logo.png";
import Paw from "../assets/paw.png";
import Page from "../components/Page";
import Section from "../components/Section";

const Home = () => {
  const sectionStyleEven = "bg-maize text-purple";
  const sectionStyleOdd = "bg-purple text-maize";
  return (
    <Page style="flex flex-col items-center font-bold">
      <Section
        img={BuildABear}
        style={sectionStyleOdd}
        title={"Welcome to the Magical World of Build-A-Bear!"}
        content={
          "Unleash your imagination and step into a realm where your dreams come to life. Dive into the enchanting journey of creating your very own furry friend."
        }
      />
      <Section
        style={sectionStyleEven}
        img={Paw}
        title={"Create, Customize, Cherish"}
        content={
          "At Build-A-Bear, we believe in the magic of creation. Our app lets you craft the perfect companion, from picking the softest fur to adding personal touches that make your bear truly unique. Every bear tells a story—start yours today!"
        }
      />
      <Section
        img={Paw}
        imgStyle="invert"
        style={sectionStyleOdd}
        title={"Meet Our Star Bears"}
        content={
          "Explore our collection of the most popular and beloved bears, each with their own personality and charm. From cuddly classics to limited-edition treasures, there's a friend waiting just for you."
        }
      />
      <Section
        img={Paw}
        style={sectionStyleEven}
        title={"Endless Possibilities"}
        content={
          "Dive into our wide range of customization options. Choose from a variety of outfits, accessories, and sounds to bring your bear to life. Whether you're looking for a superhero, a princess, or a best friend, the possibilities are endless."
        }
      />
      <Section
        img={Paw}
        imgStyle="invert"
        style={sectionStyleOdd}
        title={"Join the Fun!"}
        content={
          "Stay updated with our latest events, promotions, and exclusive offers. Whether it's a holiday celebration or a special release, there's always something exciting happening in the Build-A-Bear world."
        }
      />
      <Section
        img={Paw}
        style={sectionStyleEven}
        title={"Our Community"}
        content={
          "Read heartwarming stories from our Build-A-Bear family. From cherished childhood memories to unforgettable gifts, see how our bears have touched lives around the globe. Share your own story and become a part of our community."
        }
      />
      <Section
        img={Paw}
        imgStyle="invert"
        style={sectionStyleOdd}
        title={"Easy as 1-2-3!"}
        content={"Creating your bear is simple and fun:"}
        listTitle={"Choose Your Bear: Pick from a variety of adorable options."}
        list={[
          "Choose Your Bear: Pick from a variety of adorable options.",
          "Customize: Add outfits, sounds, and accessories.",
          "Cherish: Give your bear a name and watch it come to life!",
        ]}
      />
      <Section
        img={Paw}
        imgStyle="invert"
        style={sectionStyleEven}
        title={"We're Here to Help"}
        content={
          "Have questions or need assistance? Our friendly support team is here for you. Reach out to us anytime, and we'll ensure your Build-A-Bear experience is magical."
        }
      />
    </Page>
  );
};

export default Home;
