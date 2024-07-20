/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      boxShadow: {
        "shadow-b":
          "0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06)",
      },
      colors: {
        purple: "#201335",
        violet: "#4F4789",
        sand: "#FFB17A",
        ivory: "#FFFDED",
        maize: "#FCE762",
      },
    },
  },
  plugins: [],
};
