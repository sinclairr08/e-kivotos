/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js,ts,jsx,tsx,vue}"],
  theme: {
    extend: {
      padding: {
        "1/4": "25%",
        "1/2": "50%",
      },
    },
    fontFamily: {
      sans: ["Roboto"],
      serif: ["Roboto"],
    },
  },
  plugins: [],
};
