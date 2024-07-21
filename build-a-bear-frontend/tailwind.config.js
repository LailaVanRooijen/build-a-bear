/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      boxShadow: {
        bottom:
          "0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06)",
        card: "0 2px 4px rgba(0, 0, 0, 0.1), 0 6px 12px rgba(0, 0, 0, 0.1), 0 12px 24px rgba(0, 0, 0, 0.1)",
        "card-sand":
          "0 2px 4px rgba(255, 177, 122, 0.1), 0 6px 12px rgba(255, 177, 122, 0.1), 0 12px 24px rgba(255, 177, 122, 0.1)",
        "card-hover":
          "0 4px 8px rgba(0, 0, 0, 0.2), 0 12px 24px rgba(0, 0, 0, 0.2), 0 24px 48px rgba(0, 0, 0, 0.2)",
        "card-hover-sand":
          "0 4px 8px rgba(255, 177, 122, 0.2), 0 12px 24px rgba(255, 177, 122, 0.2), 0 24px 48px rgba(255, 177, 122, 0.2)",
      },
      colors: {
        purple: "#201335",
        violet: "#4F4789",
        sand: "#FFB17A",
        "dark-sand": "#ff954a",
        "light-sand": "#ffbd8e",
        ivory: "#FFFDED",
        maize: "#FCE762",
        "dark-maize": "#fbdc1d",
        "light-maize": "#fdee92",
      },
      fontFamily: {
        comforta: "Comfortaa",
        hand: "Edu AU VIC WA NT Hand",
      },
    },
  },
  plugins: [],
};
